package week4day1.practice.q2;

import inputreader.InputReader;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array, and a sum
 * Find whether there are pairs in the given array whose
 * sum is equal to the given sum
 */
class PairSum {
    public static void main(String[] args) throws IOException {
        File input = new File("src/week4day1/practice/q2/input.txt");
        FileWriter output = new FileWriter("src/week4day1/practice/q2/output.txt", false);

        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            output.write("Testcase " + (t + 1) + ":- \n");

            int n = ir.nextInt();
            int sum = ir.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = ir.nextInt();
            }

            output.write("Array has pairs with given sum=" + sum + ": " + hasPairWithGivenSum(arr, n, sum) + "\n\n");
        }

        output.close();
    }

    private static boolean hasPairWithGivenSum(int[] arr, int n, int sum) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (set.contains(sum - arr[i])) {
                return true;
            }
            set.add(arr[i]);
        }

        return false;
    }
}
