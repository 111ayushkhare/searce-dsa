package week3day2.practice.stack.linkedlistimplement;

class Node {
    int data;
    Node next;

    Node(int data) { this.data = data; }
}

class StackLinkedListImplementation {
    Node head;

    // Method to add an item at the top of the stack
    void push(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    // Method to remove an item from top of the stack
    int pop() {
        if (isStackEmpty()) { return Integer.MIN_VALUE; }
        int x = head.data;
        head = head.next;
        return x;
    }

    // Method to retrieve the top element in the stack
    int topElement() { return head.data; }

    // Method to check if stack is empty
    boolean isStackEmpty() { return head == null; }
}
