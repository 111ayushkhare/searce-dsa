package week3day4.practice.bfs;

import inputreader.InputReader;

import java.io.*;
import java.util.ArrayList;

public class GraphUndirected {
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
            for (int i = 0; i < E; i++) { addEdge(graph, ir.nextInt(), ir.nextInt()); }

            BreadthFirstSearch bfs = new BreadthFirstSearch(output);

            bfs.bfsInitials(graph, V);

            output.close();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
}
