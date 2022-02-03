package week4day4.practice.q3;

import inputreader.InputReader;

import java.io.*;

class TestSubsetSum {
    public static void main(String[] args) {
        try {
            File input = new File("src/week4day4/practice/q3/input.txt");
            FileWriter output = new FileWriter("src/week4day4/practice/q3/output.txt", false);

            InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

            SubsetSum subsetSumObj = new SubsetSum();

            int T = ir.nextInt();
            for (int i = 0; i < T; i++) {
                int n = ir.nextInt();
                int sum = ir.nextInt();

                int[] arr = new int[n];
                for (int j = 0; j < n; j++) { arr[j] = ir.nextInt(); }

                int choice = ir.nextInt();

                output.write("Testcase " + (i + 1) + ":-  \n");
                output.write("Subset sum with given sum output: " + subsetSumObj.isSubsetSum(arr, sum, n, choice) + "\n\n");
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
