package week4day3.practice.q2;

class MinHeap {
    private final int[] arr;
    private int size;
    private final int CAPACITY;

    MinHeap(int capacity) {
        CAPACITY = capacity;
        arr = new int[CAPACITY];
        size = 0;
    }

    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return 2 * i + 1; }
    int right(int i) { return 2 * i + 2; }

    void minHeapify(int i) {
        int leftTree = left(i), rightTree = right(i);
        int smallest = i;

        if (leftTree < size && arr[leftTree] < arr[i]) { smallest = leftTree; }
        if (rightTree < size && arr[rightTree] < arr[smallest]) { smallest = rightTree; }
        if (smallest != i) {
            arr[i] = arr[i] + arr[smallest];
            arr[smallest] = arr[i] - arr[smallest];
            arr[i] = arr[i] + arr[smallest];

            minHeapify(smallest);
        }
    }

    void insert(int data) {
        if (size == CAPACITY) { return; }

        size++;
        arr[size - 1] = data;

        for (int i = size - 1; i >= 0 && arr[parent(i)] > arr[i];) {
            arr[parent(i)] = arr[parent(i)] + arr[i];
            arr[i] = arr[parent(i)] - arr[i];
            arr[parent(i)] = arr[parent(i)] - arr[i];

            i = parent(i);
        }
    }

    int extractMin() {
        if (size == 0) { return Integer.MAX_VALUE; }
        if (size == 1) {
            size--;
            return arr[0];
        }

        arr[0] = arr[0] + arr[size - 1];
        arr[size - 1] = arr[0] - arr[size - 1];
        arr[0] = arr[0] - arr[size - 1];

        size--;
        minHeapify(0);
        return arr[size];
    }
}