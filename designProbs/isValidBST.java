public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

private TreeNode prev;

private boolean isMonotonicIncreasing(TreeNode p) {
    if (p == null) return true;
    if (isMonotonicIncreasing(p.left)) {
        if (prev != null && p.val <= prev.val) return false;
        prev = p;
        return isMonotonicIncreasing(p.right);
    }
    return false;
}

public boolean isValidBST(TreeNode root) {
    prev = null;
    return isMonotonicIncreasing(root);
}

// O(n) + On
private boolean valid(TreeNode p, int low, int high) {
    if (p == null) return true;
    return (low == null || p.val > low) && (high == null || p.val < high)
        && valid(p.left, low, p.val)
        && valid(p.right, p.val, high);
}

public boolean isValidBST(TreeNode root) {
    return valid(root, null, null);
}

// O(n^2)
private boolean isSubtreeLessthan(TreeNode root, int val) {
    if (root == null) return true;
    return root.val < val
        && isSubtreeLessthan(root.left, val)
        && isSubtreeLessthan(root.right, val);
}
private boolean isSubtreeGreaterthan(TreeNode root, int val) {
    if (root == null) return true;
    return root.val > val
        && isSubtreeGreaterthan(root.left, val)
        && isSubtreeGreaterthan(root.right, val);
}
public boolean isValidBST(TreeNode root) {
    if (root == null) return true;
    return isSubtreeLessthan(root.left, root.val)
        && isSubtreeGreaterthan(root.right, root.val)
        && isValidBST(root.left) && isValidBST(root.right);
    
}
    // 考虑得不够全面，所在subtree < > 
    // if (root.left == null && root.right == null) return true;
    // if (root.left != null && root.right != null) {
    //     if (root.left.val >= root.val || root.right.val <= root.val) return false;
    //     return isValidBST(root.left) && isValidBST(root.right);
    // } else if (root.left == null) {
    //     if (root.right.val <= root.val) return false;
    //     return isValidBST(root.right);
    // } else {
    //     if (root.left.val >= root.val) return false;
    //     return isValidBST(root.left);
    // }
// }