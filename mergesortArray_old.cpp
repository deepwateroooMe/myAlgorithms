#include <stdio.h>
//#include <stdlib.h> // rand sranddev
#include <cstdlib>

#define DEBUG 1
#define SORT_NUM 10
 
void print_array(int *list, int len);
void merge_array(int *list1, int list1_size, int *list2, int list2_size);
  
void merge_sort(int *list, int list_size) {
    if (list_size > 1) {	
	// 把数组平均分成两个部分
	int *list1 = list;
	int list1_size = list_size / 2;
	int *list2 = list + list_size / 2;
	int list2_size = list_size - list1_size;
	// 分别归并排序
	merge_sort(list1, list1_size);
	merge_sort(list2, list2_size);
 
	// 归并
	merge_array(list1, list1_size, list2, list2_size);
    }
}
 
void merge_array(int *list1, int list1_size, int *list2, int list2_size) {
    int i, j, k;
    i = j = k = 0;
 
    // 声明临时数组用于存储归并结果
    int list[list1_size + list2_size];
 
    // note: 只要有一个数组到达了尾部就要跳出
    // 也就是说只有两个都没有到达尾部的时候才执行这个循环
    while (i < list1_size && j < list2_size) {	
	// 把较小的那个数据放到结果数组里， 同时移动指针
	list[k++] = list1[i] < list2[j] ? list1[i++] : list2[j++];
    }
 
    // 如果 list1 还有元素，把剩下的数据直接放到结果数组
    while (i < list1_size) {	
	list[k++] = list1[i++];
    }
 
    // 如果 list2 还有元素，把剩下的数据直接放到结果数组
    while (j < list2_size) {	
	list[k++] = list2[j++];
    }
 
    // 把结果数组 copy 到 list1 里
    for (int ii = 0; ii < (list1_size + list2_size); ++ii) {	
	list1[ii] = list[ii];
    }
 
}
 
void print_array(int *list, int len) {
    int i;
    for (i = 0; i < len; ++i) {	
	// printf("%3d", *(list+i));
	printf("%3d", list[i]);
	if (i < len - 1)
	    printf(" ");
    }
    printf("\n");
}
 
int main(void) {
    int len = SORT_NUM;
    int list[len];
    for (int i = 0; i < len; ++i) {	
	//sranddev();
	//srand();
	list[i] = rand() % (SORT_NUM * SORT_NUM);
    }
 
    print_array(list, len);
    merge_sort(list, len);
    print_array(list, len);
 
    return 0;
}
