package week3day1.practice.singlylinkedlist;

import java.io.FileWriter;
import java.io.IOException;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class SinglyLinkedList {
    private Node head;

    /**
     * Methods to insert a node
     */

    public void insertNodeAtFront(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void insertNodeAtEnd(int val) {
        Node newNode = new Node(val);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void insertNodeAtPosition(int val, int pos, int size) {
        if (pos <= 1) {
            insertNodeAtFront(val);
            return;
        }
        if (pos > size) {
            insertNodeAtEnd(val);
            return;
        }

        Node newNode = new Node(val);
        Node curr = head;
        //int currPos = 0;

        for (int currPos = 1; currPos < pos - 1; currPos++) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;
    }

    /**
     * Methods to delete node
     */

    public void deleteNodeFromEnd() {
        if (head == null) { return; }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    public void deleteNodeFromFront() {
        if (head == null) { return; }

        Node temp = head;
        head = temp.next;
        temp.next = null;
    }

    public void deleteNodeFromPosition(int pos, int size) {
        if (pos <= 1) {
            deleteNodeFromFront();
            return;
        }
        if(pos > size) {
            deleteNodeFromEnd();
            return;
        }
        if (head == null) { return; }

        Node curr = head;
        for(int currPos = 1; currPos < pos - 1; currPos++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
    }

    /**
     * Method to return number of items in the list
     */
    public int listSize() {
        Node curr = head;
        int size = 0;

        while (curr != null) {
            curr = curr.next;
            size++;
        }

        return size;
    }

    /**
     * Method to print the linked list
     */
    public void printLinkedList(FileWriter output) throws IOException {
        //FileWriter output = new FileWriter("src/week3day1/assignment/q2/output.txt", false);

        Node curr = head;

        while (curr != null) {
            output.write(curr.data + "\n");
            curr = curr.next;
        }

        output.write("\n");
        //output.close();
    }
}
