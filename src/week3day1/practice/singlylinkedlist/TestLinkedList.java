package week3day1.practice.singlylinkedlist;

import inputreader.InputReader;

import java.io.*;

public class TestLinkedList {
    public static void main(String[] args) throws IOException {
        // Reading input from a text file
        File input = new File("src/week3day1/practice/singlylinkedlist/input.txt");
        FileWriter output = new FileWriter("src/week3day1/practice/singlylinkedlist/output.txt");
        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            // This SinglyLinkedList class and all of its various methods are defined in week3day1/practice/singlylinkedlist package
            // Refer the code for linked list implementation from there
            SinglyLinkedList list = new SinglyLinkedList();

            int p = ir.nextInt();
            for (int i = 0; i < p; i++) {
                list.insertNodeAtEnd(ir.nextInt());
            }
            output.write("Testcase " + (t + 1) + ":\n");
            list.printLinkedList(output);

            list.insertNodeAtFront(ir.nextInt());
            list.printLinkedList(output);

            list.insertNodeAtPosition(ir.nextInt(), ir.nextInt(), list.listSize());
            list.printLinkedList(output);

            list.deleteNodeFromFront();
            list.printLinkedList(output);

            list.deleteNodeFromEnd();
            list.printLinkedList(output);

            list.deleteNodeFromPosition(ir.nextInt(), list.listSize());
            list.printLinkedList(output);
        }

        output.close();
    }
}
