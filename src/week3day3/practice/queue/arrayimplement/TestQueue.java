package week3day3.practice.queue.arrayimplement;

import inputreader.InputReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestQueue {
    public static void main(String[] args) throws IOException {
        // Reading input from a text file
        File input = new File("src/week3day3/practice/queue/arrayimplement/input.txt");
        FileWriter output = new FileWriter("src/week3day3/practice/queue/arrayimplement/output.txt");
        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            QueueArrayImplementation queue = new QueueArrayImplementation(ir.nextInt());

            output.write("Testcase " + (t + 1) + ":- \n");
            output.write("---------------------------\n");

            int numOfItems = ir.nextInt();
            for (int i = 0; i < numOfItems; i++) {
                if (queue.enqueue(ir.nextInt())) {
                    output.write("Item enqueued: " + queue.rearElement() + "\n");
                }
            }

            output.write("Queue size: " + queue.qSize() + " \n");
            output.write("Front element: " + queue.frontElement() + " \n");
            output.write("Rear element: " + queue.rearElement() + " \n");

            output.write("\nItem Dequeued: " + queue.dequeue() + " \n");
            output.write("Queue size: " + queue.qSize() + " \n");
            output.write("Front element: " + queue.frontElement() + " \n");
            output.write("Rear element: " + queue.rearElement() + " \n");

            if (queue.enqueue(ir.nextInt())) {
                output.write("\nItem enqueued: " + queue.rearElement() + " \n");
                output.write("Queue size: " + queue.qSize() + " \n");
                output.write("Front element: " + queue.frontElement() + " \n");
                output.write("Rear element: " + queue.rearElement() + " \n");
            }

            output.write("\n");
        }

        output.close();
    }
}
