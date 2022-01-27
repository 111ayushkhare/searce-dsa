package week3day3.practice.queue.linkedlistimplement;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class QueueLinkedListImplementation {
    private Node front, rear;
    private final int CAPACITY;

    QueueLinkedListImplementation(int capacity) {
        CAPACITY = capacity;
        front = rear = null;
    }

    // Method to add an element in the queue
    boolean enqueue(int val) {
        // Condition to check if queue is full
        // then element cannot be added, return false
        if (isQFull()) { return false; }

        Node newNode = new Node(val);

        // Condition if element is added to empty queue
        if (isQEmpty()) {
            front = rear = newNode;
            return true;
        }

        // When queue is neither empty nor full, simply add the element
        rear.next = newNode;
        rear = newNode;
        return true;
    }

    // Method to remove an element from the queue
    int dequeue() {
        if (isQEmpty()) { return Integer.MIN_VALUE; }
        int x = front.data;
        front = front.next;
        return x;
    }

    // Method to retrieve the element at front end
    // If queue is empty, Integer.MIN_VALUE is returned
    int frontElement() { return isQEmpty() ? Integer.MIN_VALUE : front.data; }

    // Method to retrieve the element at rear end
    // If queue is empty, Integer.MIN_VALUE is returned
    int rearElement() { return isQEmpty() ? Integer.MIN_VALUE : rear.data; }

    // Method to find number of elements in the queue
    int qSize() {
        Node curr = front;
        int itemCount = 0;

        while (curr != null) {
            curr = curr.next;
            itemCount++;
        }

        return itemCount;
    }

    // Method to check if the queue is full
    boolean isQFull() { return qSize() == CAPACITY; }

    // Method to check if the queue is empty
    boolean isQEmpty() { return front == null; }
}
