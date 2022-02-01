package week4day2.practice;

class InsertionSort {
    // Logic is to take a key element at ith position
    // And make the array sorted (i-1)th element
    int[] insertionSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        return arr;
    }
}
