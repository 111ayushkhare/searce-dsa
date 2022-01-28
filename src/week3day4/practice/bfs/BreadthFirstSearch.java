package week3day4.practice.bfs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class BreadthFirstSearch {
    private final FileWriter output;
    private boolean[] visited;

    public BreadthFirstSearch(FileWriter output) { this.output = output; }

    public void bfsInitials(ArrayList<ArrayList<Integer>> graph, int V) throws IOException {
        visited = new boolean[V];
        for (int i = 0; i < V; i++) { visited[i] = false; }

        output.write("BFS Traversal: \n");

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfsTraversal(graph, i);
            }
        }
    }
    
    private void bfsTraversal(ArrayList<ArrayList<Integer>> graph, int s) throws IOException {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            output.write(u + " ");

            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

        output.write("\n");
    }
}
