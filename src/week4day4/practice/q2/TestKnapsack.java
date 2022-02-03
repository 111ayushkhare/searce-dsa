package week4day4.practice.q2;

import inputreader.InputReader;

import java.io.*;

class TestKnapsack {
    public static void main(String[] args) {
        try {
            File input = new File("src/week4day4/practice/q2/input.txt");
            FileWriter output = new FileWriter("src/week4day4/practice/q2/output.txt", false);

            InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));
            Knapsack01 knapObj = new Knapsack01();

            int T = ir.nextInt();
            while (T-- > 0) {
                int maxWt = ir.nextInt();
                int n = ir.nextInt();

                int[] wt = new int[n];
                int[] val = new int[n];

                for (int i = 0; i < n; i++) { wt[i] = ir.nextInt(); }
                for (int i = 0; i < n; i++) { val[i] = ir.nextInt(); }

                int choice = ir.nextInt();
                output.write(knapObj.knapsack01(wt, val, maxWt, n, choice) + "\n");
            }

            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
