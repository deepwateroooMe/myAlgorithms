package com;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toMap;

class AVLNode<T> {
    AVLNode(T t) {
        this(t, null, null);
    }
    AVLNode(T data, AVLNode<T> lt, AVLNode<T> rt){
        this.data = data;
        left = lt;
        right = rt;
        this.height = 0;
    }

    T data;
    AVLNode<T> left;
    AVLNode<T> right;
    int height;
}

public class AVLTree<T extends Comparable<? super T>> {
    private AVLNode<T> root; // <<<<<<<<<<<<<<<<<<<< 
    // 节点的左右孩子高度差不能超过该值
    private static final int HEIGHT_DIFFERENCE  =  1;

    public AVLTree(AVLNode<T> root) {
        this.root = root;
    }

    public void insert(T data) {
        if (data == null) 
            throw new IllegalArgumentException("数据为空");
        root = insert(data, this.root);
    }
    private AVLNode<T> insert(T data, AVLNode<T> t) {
        if (t == null) 
            return new AVLNode<>(data, null, null);
        int compareResult = data.compareTo(t.data);
        if (compareResult < 0) {
            t.left = insert(data, t.left);
        } else if (compareResult > 0) {
            t.right = insert(data, t.right);
        }
        // else {
        //     ;
        // }
        return balance(t);
    }
    /**
     * 对节点t进行平衡
     * @param t
     * @return
     */
    // 1.在A的左孩子的左子树进行插入 （单旋转，向右旋转）
    // 2.在A的左孩子的右子树进行插入 （双旋转，先左 再右）
    // 3.在A的右孩子的左子树进行插入 （双旋转，先右 再左）
    // 4.在A的右孩子的右子树进行插入 （单旋转，向左旋转）
    private AVLNode<T> balance(AVLNode<T> t) {
        if (t == null) 
            return null;
        if (height(t.left) - height(t.right) > HEIGHT_DIFFERENCE) {
            // 左边高
            if (height(t.left.left) >= height(t.left.right)) {
                // 左子树的左子树高
                // 此为情形1，在左子树的左子树插入了元素，直接右旋转
                t = rotateRight(t);
            } else {
                // 左子树的右子树高
                // 此为情形2，在左子树的右子树插入了元素，先左旋转再右旋转
                t = doubleLeftAndRight(t);
            }

        } else if (height(t.right) - height(t.left) > HEIGHT_DIFFERENCE) {
            // 右边高
            if (height(t.right.left) > height(t.right.right)) {
                // 右子树的左子树高了
                // 此为情形3，在右子树的左子树插入了元素，先右旋转再左旋转
                t = doubleRightAndLeft(t);
            } else {
                // 右子树的右子树高
                // 此为情形4，在右子树的右子树插入了元素，直接左旋转
                t = rotateLeft(t);
            }
        }
        // 重新计算该节点的高度
        t.height = Math.max(height(t.left), height(t.right))+1;
        return t;
    }

    /**
     * 单旋转(左旋转)(情形4)
     * @param node
     * @return
     */
    private AVLNode<T> rotateLeft(AVLNode<T> node){
        AVLNode<T> right = node.right;
        node.right = right.left;
        right.left = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        right.height = Math.max(node.height,height(right.right))+1;
        return right;
    }

    /**
     * 单旋转(右旋转)(情形1)
     * @param node
     * @return
     */
    private AVLNode<T>rotateRight(AVLNode<T> node){
        AVLNode<T> left = node.left;
        node.left = left.right;
        left.right = node;
        node.height = Math.max(height(node.left),height(node.right))+1;
        left.height = Math.max(height(node.left),node.height)+1;
        return left;
    }

    /**
     * 双旋转(先左后右)(针对情形2)
     * @param node
     * @return
     */
    private AVLNode<T> doubleLeftAndRight(AVLNode<T> node){
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    /**
     * 双旋转(先右再左) (针对情形3)
     * @param node
     * @return
     */
    private AVLNode<T> doubleRightAndLeft(AVLNode<T> node){
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    
    private int height(AVLNode<T>  t) {
        return t == null? - 1:t.height;
    }

    /**
     * 删除数据
     * @param x
     */
    public void remove(T x ) {
        root  =  remove( x,  root );
    }
    private AVLNode<T> remove(T data, AVLNode<T>  root) {
        if (root == null) 
            return null;
        int compareResult = data.compareTo(root.data);
        if (compareResult < 0) {
            root.left = remove(data, root.left);
        } else if (compareResult > 0) {
            root.right = remove(data, root.right);
        } else if (root.left != null && root.right != null) {
            // 待删除节点有两个孩子
            root.data = findMin(root).data; // <<<<<<<<<<<<<<<<<<<< ??? 没仔细去想，要再想一遍/执行一遍
            root.right = remove(root.data, root.right);
        } else {
            // 待删除节点没有孩子或有一个孩子
            root = root.left == null?root.right:root.left;
        }
        // 重新平衡树
        return balance(root);
    }

    /**
     * 返回数据队列
     * @return
     */
    public Queue<T> iterator() {
        if (isEmpty()) {
            return null;
        } else {
            Queue<T> queue = new Queue <  > ();
            return iterator(root, queue);
        }
    }
    private Queue<T>  iterator( AVLNode<T>  t, Queue <T>  queue ) {
        if (t != null) {
            iterator( t.left, queue );
            queue.enqueue(t.data);
            iterator( t.right,  queue);
        }
        return queue;
    }

    public static void main(String[] args) {
        AVLTree < Integer >  avlTree  =  new AVLTree <  > (new AVLNode <  > (1));

        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.insert(15);
        avlTree.insert(16);
        avlTree.insert(14);

        // 中序遍历打印
        avlTree.printTree();
        System.out.println(" ==  ==  ==  ==  == 删除节点15 ==  ==  ==  ==  = ");
        
        avlTree.remove(15);
        Queue < Integer >  queue  =  avlTree.iterator();
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        Integer max  =  avlTree.findMax();
        System.out.println("最大元素:"+max);
        System.out.println("节点17是否存在"+avlTree.contains(17));
    }
}
