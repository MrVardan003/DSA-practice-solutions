import java.util.*;

class Edge {
    int root, destination, weight;

    public Edge(int root, int destination, int weight) {
        this.root = root;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int V, E;
    Edge[] edges;

    Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new Edge[E];
    }

    void bellmanFord(int root) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[root] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int j = 0; j < E; j++) {
                int u = edges[j].root;
                int v = edges[j].destination;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i].root;
            int v = edges[i].destination;
            int weight = edges[i].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph has -ve weight");
                return;
            }
        }
        
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + ": Distance from root = " + dist[i]);
        }
    }
}

public class BellmanFordShortestPath {
    public static void main(String[] args) {
        int V = 5;
        int E = 8;

        Graph graph = new Graph(V, E);

        graph.edges[0] = new Edge(0, 1, -1);
        graph.edges[1] = new Edge(0, 2, 4);
        graph.edges[2] = new Edge(1, 2, 3);
        graph.edges[3] = new Edge(1, 3, 2);
        graph.edges[4] = new Edge(1, 4, 2);
        graph.edges[5] = new Edge(3, 2, 5);
        graph.edges[6] = new Edge(3, 1, 1);
        graph.edges[7] = new Edge(4, 3, -3);

        int root = 0;

        graph.bellmanFord(root);
    }
}
