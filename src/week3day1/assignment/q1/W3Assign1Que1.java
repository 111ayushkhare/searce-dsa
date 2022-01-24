package week3day1.assignment.q1;

import inputreader.InputReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * An array is a data structure that keeps items of the same kind in a single memory block.
 * Each memory position in an array, P, of size Q, has a unique index, I (where 0=i=Q), which may be referred as P[i] or Pi.
 * Reverse an integer array.
 */

public class W3Assign1Que1 {
    public static void main(String[] args) throws IOException {
        // Reading input from a text file
        File input = new File("src/week3day1/assignment/q1/input.txt");
        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int Q = ir.nextInt();
        int[] P = new int[Q];

        for (int i = 0; i < Q; i++) {
            P[i] = ir.nextInt();
        }

        displayArr(reverseArr(P, Q), Q);
    }

    // Array reversing method using two-pointer approach
    private static int[] reverseArr(int[] arr, int n) {
        int low = 0, high = n - 1;

        while (low < high) {
            arr[low] = arr[low] + arr[high];
            arr[high] = arr[low] - arr[high];
            arr[low] = arr[low] - arr[high];

            low++;
            high--;
        }

        return arr;
    }

    // Method to display array
    private static void displayArr(int[] arr, int n) throws IOException {
        FileWriter output = new FileWriter("src/week3day1/assignment/q1/output.txt", false);

        for (int i = 0; i < n; i++) {
            output.write(arr[i] + " ");
        }

        output.close();
    }
}
