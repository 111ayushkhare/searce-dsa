package week3day2.practice.stack.arrayimplement;

class StackArrayImplementation {
    private final int CAPACITY;
    private int top;
    private final int[] arr;

    StackArrayImplementation(int cap) {
        CAPACITY = cap;
        arr = new int[CAPACITY];
        top = -1;
    }

    // Method to add an item at the top of the stack
    boolean push(int val) {
        if (top < CAPACITY - 1) {
            top++;
            arr[top] = val;
            return true;
        } else {
            return false;
        }
    }

    // Method to remove an item from top of the stack
    int pop() {
        if (top != -1) {
            int x = arr[top];
            top--;
            return x;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    // Method to retrieve the top element in the stack
    int topElement() { return arr[top]; }

    // Method to check if stack is empty
    boolean isStackEmpty() { return top == -1; }
}
