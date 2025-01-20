import java.util.*;

class Graph {
    int vertices;
    LinkedList<Edge>[] adj;

    class Edge {
        int to;
        int wt;
        Edge(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    Graph(int v) {
        vertices = v;
        adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int frm, int to, int wt) {
        adj[frm].add(new Edge(to, wt));
    }

    int minDist(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE, mi = -1;
        for (int v = 0; v < vertices; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                mi = v;
            }
        }
        return mi;
    }

    int find(int root, int fin) {
        int[] dist = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[root] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            int crnt = minDist(dist, visited);
            visited[crnt] = true;
            for (Edge edge : adj[crnt]) {
                int to = edge.to;
                int wt = edge.wt;
                if (!visited[to] && dist[crnt] != Integer.MAX_VALUE && dist[crnt] + wt < dist[to]) {
                    dist[to] = dist[crnt] + wt;
                }
            }
        }
        return dist[fin];
    }
}

public class ShortestDistanceGraph {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 2);
        graph.addEdge(3, 4, 1);
        int result = graph.find(2, 4);
        System.out.println("Min. Dist. is " + result);
    }
}
