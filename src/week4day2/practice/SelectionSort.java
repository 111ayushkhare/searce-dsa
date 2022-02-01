package week4day2.practice;

class SelectionSort {
    // Logic is to find the index of minimum element
    // in the range of start = i+1 to n
    // And swapping it with the current element
    // If it is smaller than the current element
    int[] selectionSort(int[] arr, int n) {
        int start, minIdx;
        for (int i = 0; i < n - 1; i++) {
            start = i + 1;
            minIdx = getIndexOfMinElt(arr, start, n);

            if (arr[i] > arr[minIdx]) {
                arr[i] = arr[i] + arr[minIdx];
                arr[minIdx] = arr[i] - arr[minIdx];
                arr[i] = arr[i] - arr[minIdx];
            }
        }
        return arr;
    }

    // Method to find the location of minimum element
    // in the specified range of indices
    private int getIndexOfMinElt(int[] arr, int start, int n) {
        int j = start, min = arr[start];
        for (int i = start; i < n; i++) { j =  min > arr[i] ? i : j; }
        return j;
    }
}
