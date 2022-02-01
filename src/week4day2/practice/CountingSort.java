package week4day2.practice;

class CountingSort {
    int[] countingSort(int[] arr, int n) {
        int maxVal = arr[0];
        for (int i = 1; i < n; i++) { maxVal = Math.max(maxVal, arr[i]); }

        int[] count = new int[maxVal + 1];

        // Initialize count array with zeros at each index
        for (int i = 0; i <= maxVal; i++) { count[i] = 0; }

        // Storing the count of each element in count array
        for (int i = 0; i < n; i++) { count[arr[i]]++; }

        // Assigning cumulative count
        for (int i = 1; i <= maxVal; i++) { count[i] += count[i - 1]; }

        // Finding the index of each element of the original array in count array
        // Then place the elements in the output array
        int[] outputArr = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            outputArr[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copying sorted output array to the original array
        System.arraycopy(outputArr, 0, arr, 0, n);

        return arr;
    }
}
