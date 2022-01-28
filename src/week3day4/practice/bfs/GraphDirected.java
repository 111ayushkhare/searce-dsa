package week3day4.practice.bfs;

import inputreader.InputReader;

import java.io.*;
import java.util.ArrayList;

public class GraphDirected {
    public static void main(String[] args) throws IOException {
        File input = new File("src/week3day4/practice/bfs/input.txt");
        FileWriter output = new FileWriter("src/week3day4/practice/bfs/output.txt", false);

        InputReader ir = new InputReader(new BufferedReader(new FileReader(input)));

        int T = ir.nextInt();
        while (T-- > 0) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            int V = ir.nextInt();
            int E = ir.nextInt();

            for (int i = 0; i < V; i++) { graph.add(new ArrayList<>()); }
            for (int i = 0; i < E; i++) { graph.get(ir.nextInt()).add(ir.nextInt()); }

            BreadthFirstSearch bfs = new BreadthFirstSearch(output);

            bfs.bfsInitials(graph, V);
        }

        output.close();
    }
}
