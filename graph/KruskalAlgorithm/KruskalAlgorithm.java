import java.util.*;

class Graph {
    int vertices;
    List<Edge> edges;
    int[] p;

    class Edge implements Comparable<Edge> {
        int src, dest, wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        public int compareTo(Edge that) {
            return this.wt - that.wt;
        }
    }

    Graph(int v) {
        vertices = v;
        edges = new ArrayList<>();
        p = new int[v];
        for (int i = 0; i < v; i++) {
            p[i] = i; // initialize the parent array
        }
    }

    void addEdge(int src, int dest, int wt) {
        edges.add(new Edge(src, dest, wt));
    }

    int find(int x) {
        if (p[x] == x) return x;
        return find(p[x]);
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            p[ry] = rx;
        }
    }

    void KruskalAlgo() {
        Collections.sort(edges);

        int mstWeight = 0;
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;

            if (find(u) != find(v)) {
                union(u, v);
                mst.add(edge);
                mstWeight += edge.wt;
            }
        }

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + ": " + edge.wt);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }
}

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 3, 15);
        graph.addEdge(2, 3, 4);
        graph.KruskalAlgo();
    }
}
