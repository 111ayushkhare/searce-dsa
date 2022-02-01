package week4day2.practice;

class BubbleSort {
    int[] bubbleSortOptimized(int[] arr, int n) {
        boolean swapped;

        for (int i = 0; i < n; i++) {
            swapped = false;

            for (int j = 1; j < n - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap
                    arr[j - 1] = arr[j - 1] + arr[j];
                    arr[j] = arr[j - 1] - arr[j];
                    arr[j - 1] = arr[j - 1] - arr[j];

                    swapped = true;
                }
            }

            // If swapped at this point is false
            // That means inner loop hasn't run
            // Which indicates all comparisons were false
            // Hence no swapping occurred
            // So array at this point is completely sorted
            // Therefore it is good to stop the entire sorting process as it is done
            if (!swapped) { break; }
        }

        return arr;
    }

    int[] bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap
                    arr[j - 1] = arr[j - 1] + arr[j];
                    arr[j] = arr[j - 1] - arr[j];
                    arr[j - 1] = arr[j - 1] - arr[j];
                }
            }
        }
        return arr;
    }
}
