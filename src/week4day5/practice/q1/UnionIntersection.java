package week4day5.practice.q1;

import inputreader.InputReader;

import java.io.*;
import java.util.HashSet;

class UnionIntersection {
    public static void main(String[] args) throws IOException {
        File input = new File("src/week4day5/practice/q1/input.txt");
        FileWriter output = new FileWriter("src/week4day5/practice/q1/output.txt", false);

        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            output.write("Testcase " + (t + 1) + ": \n");

            int n1 = ir.nextInt();
            int n2 = ir.nextInt();

            int[] arr1 = new int[n1];
            int[] arr2 = new int[n2];

            for (int i = 0; i < n1; i++) { arr1[i] = ir.nextInt(); }
            for (int i = 0; i < n2; i++) { arr2[i] = ir.nextInt(); }

            arrUnion(arr1, arr2, output);
            arrIntersection(arr1, arr2, n1, n2, output);
        }

        output.close();
    }

    private static void arrUnion(int[] a, int[] b, FileWriter output) throws IOException {
        HashSet<Integer> aOrb = new HashSet<>();

        for (int i: a) { aOrb.add(i); }
        for (int i: b) { aOrb.add(i); }

        output.write("Union: " + aOrb + "\n");
    }

    private static void arrIntersection(int[] a, int[] b, int n1, int n2, FileWriter output) throws IOException {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i: a) { set1.add(i); }
        for (int i: b) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }

        output.write("Intersection: " + set2 + "\n\n");
    }
}
