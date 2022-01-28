package week3day4.practice.levelorder;

import inputreader.InputReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class LevelOrder {
    public static void main(String[] args) throws IOException {
        File input = new File("src/week3day4/practice/bfs/input.txt");
        FileWriter output = new FileWriter("src/week3day4/practice/bfs/output.txt", false);

        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        for (int t = 0; t < T; t++) {
            output.write("Testcase " + (t + 1) + ": \n");

            // tree initialization left
            // pseudocode for level order traversal done

            // ArrayList<Integer> treeLevelOrder = levelOrder(tree);

            output.write("\n");
        }

        output.close();

    }

    private static ArrayList<Integer> levelOrder(Node node)
    {
        ArrayList<Integer> levelList = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            levelList.add(curr.data);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return levelList;
    }
}
