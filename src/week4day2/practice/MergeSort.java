package week4day2.practice;

class MergeSort {
    // Logic is : Divide and Conquer
    // Array is divided into two parts say left and right recursively
    // Each divided array is sorted within itself first
    // And then left and right arrays are merged in a sorted manner

    int[] mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            arr = mergeSort(arr, low, mid);
            arr = mergeSort(arr, mid + 1, high);
            arr = merge(arr, low, mid, high);
        }
        return arr;
    }

    private int[] merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n1];

        /**
         * for (int i = 0; i < n2; i++) { left[i] = arr[low + i]; }
         * for (int i = 0; i < n2; i++) { right[i] = arr[mid + 1 + i]; }
         *
         * Below two methods doing the same job af assigning values to left and right array
         */

        System.arraycopy(arr, low, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) { arr[k++] = left[i++]; }
        while (j < n2) { arr[k++] = right[j++]; }

        return arr;
    }
}
