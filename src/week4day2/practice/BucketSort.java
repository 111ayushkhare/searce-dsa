package week4day2.practice;

import java.util.ArrayList;
import java.util.Collections;

class BucketSort {
    int[] bucketSort(int[] arr, int n) {
        // Setting number of buckets as half the array size
        // If array size is 1 then k = 1
        int k = n == 1 ? 1 : n/2;

        // Finding the maximum value
        int maxVal = arr[0];
        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, arr[i]);
        }
        maxVal++;

        // Creating buckets
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for (int i = 0; i < k; i++) { bucket.add(new ArrayList<>()); }

        // Distributing array elements in the bucket
        for (int i = 0; i < n; i++) {
            int bucketIdx = (k * Math.abs(arr[i]) / maxVal);
            if (bucketIdx >= n) { bucketIdx = k - 1; }
            bucket.get(bucketIdx).add(arr[i]);
        }

        // Sorting each bucket
        for (ArrayList<Integer> bkt: bucket) { Collections.sort(bkt); }

        // Combining all sorted buckets and finally getting the array sorted
        int index = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                arr[index++] = bucket.get(i).get(j);
            }
        }

        return arr;
    }
}
