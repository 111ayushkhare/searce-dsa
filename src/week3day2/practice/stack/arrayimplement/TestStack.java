package week3day2.practice.stack.arrayimplement;

import inputreader.InputReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class TestStack {
    public static void main(String[] args) throws IOException {
        // Reading input from a text file
        File input = new File("src/week3day2/practice/stack/arrayimplement/input.txt");
        FileWriter output = new FileWriter("src/week3day2/practice/stack/arrayimplement/output.txt");
        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            // Creating a stack object and passing max array capacity via constructor
            // Array implementation of stack
            StackArrayImplementation stack = new StackArrayImplementation(ir.nextInt());

            output.write("Testcase " + (t + 1) + ":- \n");

            // No. of items to pushed in the stack
            int numOfItems = ir.nextInt();
            for (int i = 0; i < numOfItems; i++) {
                // There can be a case when item count exceed array capacity
                // In such case nothing gets pushed onto the stack
                // Print only if element gets pushed onto the stack
                if (stack.push(ir.nextInt())) {
                    output.write("Item pushed: " + stack.topElement() + "\n");
                }
            }

            // If popped value = -2147483648 (Integer.MIN_VALUE)
            // Then stack is empty
            output.write("Item popped: " + stack.pop() + "\n");
            output.write("Stack empty: " + stack.isStackEmpty() + "\n\n");
        }

        output.close();
    }
}
