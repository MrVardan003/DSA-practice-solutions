import java.util.*;

class Graph {
    int V = 5;
    int[][] graph;

    Graph(int[][] graph) {
        this.graph = graph;
    }

    class Node implements Comparable<Node> {
        int vertex, key;

        Node(int vertex, int key) {
            this.vertex = vertex;
            this.key = key;
        }

        public int compareTo(Node other) {
            return this.key - other.key;
        }
    }

    void primMST() {
        boolean[] visited = new boolean[V];
        Node[] nodes = new Node[V];
        int[] parent = new int[V];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < V; i++) {
            nodes[i] = new Node(i, Integer.MAX_VALUE);
            parent[i] = -1;
        }

        nodes[0].key = 0;
        pq.add(nodes[0]);

        while (!pq.isEmpty()) {
            Node u = pq.poll();
            visited[u.vertex] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u.vertex][v] != 0 && !visited[v] && graph[u.vertex][v] < nodes[v].key) {
                    nodes[v].key = graph[u.vertex][v];
                    parent[v] = u.vertex;
                    pq.add(new Node(v, nodes[v].key)); 
                }
            }
        }

        printMST(parent);
    }

    void printMST(int[] parent) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }
}

public class PrimMSTAlgorithm {
    public static void main(String[] args) {
        int[][] graph = new int[][] {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        Graph g = new Graph(graph);
        g.primMST();
    }
}
