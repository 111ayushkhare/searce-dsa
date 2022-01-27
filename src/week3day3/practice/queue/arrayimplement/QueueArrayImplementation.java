package week3day3.practice.queue.arrayimplement;

class QueueArrayImplementation {
    private final int CAPACITY;
    private int front, rear;
    private final int[] qArr;

    QueueArrayImplementation(int maxElements) {
        front = -1;
        rear = -1;
        CAPACITY = maxElements;
        qArr = new int[CAPACITY];
    }

    // Method to add an element in the queue
    boolean enqueue(int val) {
        // Condition to check if queue is full
        // then element cannot be added, return false
        if (isQFull()) { return false; }

        // Condition if element is added to empty queue
        if (isQEmpty()) {
            qArr[++front] = val;
            rear++;
            return true;
        }

        // When queue is neither empty nor full, simply add the element
        qArr[++rear] = val;
        return true;
    }

    // Method to remove an element from the queue
    int dequeue() {
        if(isQEmpty()) { return Integer.MIN_VALUE; }
        return qArr[front++];
    }

    // Method to retrieve the element at front end
    // If queue is empty, Integer.MIN_VALUE is returned
    int frontElement() { return isQEmpty() ? Integer.MIN_VALUE : qArr[front]; }

    // Method to retrieve the element at rear end
    // If queue is empty, Integer.MIN_VALUE is returned
    int rearElement() { return isQEmpty() ? Integer.MIN_VALUE : qArr[rear]; }

    // Method to find number of elements in the queue
    int qSize() { return isQEmpty() ? 0 : rear - front + 1; }

    // Method to check if the queue is full
    boolean isQFull() { return rear == CAPACITY - 1; }

    // Method to check if the queue is empty
    boolean isQEmpty() { return front == -1 && rear == -1; }
}
