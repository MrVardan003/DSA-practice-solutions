import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Graph {
    int vertices;
    List<LinkedList<Integer>> adjList;

    Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    void addEdge(int a, int b) {
        adjList.get(a).add(b);
    }

    void bfsMaker(int root) {
        Queue<Integer> visiting = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        visited[root] = true;
        visiting.add(root);

        while (!visiting.isEmpty()) {
            int i = visiting.poll();
            System.out.print(i + " ");

            for (int neighbour : adjList.get(i)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    visiting.add(neighbour);
                }
            }
        }
    }
}

public class BreadthFirstSearch {
    public static void main(String[] args) {
        int vertices = 6;

        Graph graph = new Graph(vertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        
        graph.bfsMaker(0);
    }
}
