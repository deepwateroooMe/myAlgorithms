int** My2DAlloc(int rows, int cols) {
    int **arr = (int**)malloc(rows*sizeof(int*));
    for (int i = 0; i < rows; ++i)
	arr[i] = new int[cols];
    return arr;
}

int** My2DAlloc1(int rows, int cols) {
    int header = rows * sizeof(int*);
    int data = rows * cols * sizeof(int);
    int **arr = (int**)malloc(header + data);
    int *buf = (int*)(arr + rows);
    for( int i = 0; i < rows; ++i)
	arr[i] = buf + i * cols;
    return arr;
}
