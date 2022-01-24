package week3day1.assignment.q2;

import inputreader.InputReader;
import week3day1.practice.singlylinkedlist.SinglyLinkedList;

import java.io.*;

/**
 * This is a good way to get some practise with traversing a linked list.
 * Print each node's data element, one per line, given a pointer to the head node of a linked list.
 * There is nothing to output if the head reference is null (meaning the list is empty).
 *
 * Create a function to print LinkedLists.
 *
 * The parameter(s) for printLinkedList are as follows:
 * SinglyLinkedList The head of the list is referred to as the node head.
 * Print the value of each node in a new line
 *
 * Input format
 * The first line of input contains p, which is the number of linked list entries.
 * The data values for each node are contained in the next p lines, each with one element.
 *
 * Constraints
 * 1<=P<=1000
 * 1<=list[i]<=1000 where list [i] is the ith element of the linked list
 */

public class W3Assign1Que2 {
    public static void main(String[] args) throws IOException {
        // Reading input from a text file
        File input = new File("src/week3day1/assignment/q2/input.txt");
        FileWriter output = new FileWriter("src/week3day1/assignment/q2/output.txt");
        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        // This SinglyLinkedList class and all of its various methods are defined in week3day1/practice/singlylinkedlist package
        // Refer the code for linked list implementation from there
        SinglyLinkedList list = new SinglyLinkedList();

        int p = ir.nextInt();
        for (int i = 0; i < p; i++) {
            list.insertNodeAtEnd(ir.nextInt());
        }

        list.printLinkedList(output);
        output.close();
    }
}
