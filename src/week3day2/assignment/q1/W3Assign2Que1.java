package week3day2.assignment.q1;

import inputreader.InputReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

/**
 * You have an empty sequence, and you will be given
 * queries. Each query is one of these three types:
 * 1 x  -Push the element x into the stack.
 * 2    -Delete the element present at the top of the stack.
 * 3    -Print the maximum element in the stack.
 *
 * Function Description
 * Complete the getMax function in the editor below.
 *
 * getMax has the following parameters:
 * - string operations[n]: operations as strings
 * Returns
 * - int[]: the answers to each type 3 query
 *
 * Input Format
 * The first line of input contains an integer.
 * The next lines each contain an above-mentioned query.
 *
 * Constraints
 * 1<=n<=105
 * 1<=x<=109
 * 1<=type<=3
 *
 * All queries are valid.
 */

class W3Assign2Que1 {
    public static void main(String[] args) throws IOException {
        // Reading input from a text file
        File input = new File("src/week3day2/assignment/q1/input.txt");
        FileWriter output = new FileWriter("src/week3day2/assignment/q1/output.txt", false);
        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            int n = ir.nextInt();
            String[] operations = new String[n];
            for (int i = 0; i < n; i++) {
                int x = ir.nextInt();
                StringBuilder str = new StringBuilder(String.valueOf(x));

                if (x == 1) {
                    str.append(" ").append(ir.nextInt());
                }
                operations[i] = String.valueOf(str);
            }

            ArrayList<Integer> query3Answers = getMax(operations, n);

            output.write("Testcase: " + (t + 1) + ":- \n");
            for (int i : query3Answers) { output.write(i + "\n"); }
            output.write("\n");
        }

        output.close();
    }

    private static ArrayList<Integer> getMax(String[] operations, int n) {
        ArrayList<Integer> query3 = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] queryAndData = new int[2];
            int j = 0;

            // Separating query parameter and data value
            // from single string in operations string array
            for (String s : operations[i].split(" ")) {
                queryAndData[j++] = Integer.parseInt(s);
            }

            if (queryAndData[0] == 1) {
                // If stack is empty maximum value is the first element to be inserted
                // Else max value is set to maximum of current max and element being inserted
                maxVal = stack.isEmpty() ? queryAndData[1] : Math.max(maxVal, queryAndData[1]);
                stack.push(queryAndData[1]);

                // Now if maxStack (which contains all maximum values till ith iteration)
                // is either empty or is top value <= maxVal
                // we need to add this to the maxStack
                if (maxStack.isEmpty() || maxStack.peek() <= maxVal) {
                    maxStack.push(maxVal);
                }
            }
            if (queryAndData[0] == 2) {
                // Removing if top elements in both regular stack and maxStack are equal
                // As now after removing that element will require new max value
                // and this max value is the second top element in the maxStack
                if (Objects.equals(maxStack.peek(), stack.peek())) {
                    maxStack.pop();
                }
                stack.pop();
            }

            // Max value is already compared and set while inserting it into the maxStack
            // So in query=3, directly adding to query3 array
            if (queryAndData[0] == 3) { query3.add(maxStack.peek()); }
        }

        return  query3;
    }
}
