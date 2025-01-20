import java.util.*;

class Edge {
    int src, des, wt;

    Edge(int src, int des, int wt) {
        this.src = src;
        this.des = des;
        this.wt = wt;
    }
}

public class KMaxStopsBellmanFord {

    public static void bellmanFord(List<Edge> edge, int v, int src, int trgt, int k) {
        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[src] = 0;

        for (int stops = 0; stops < k; stops++) {
            int[] temp = dis.clone();

            for (Edge e : edge) {
                int u = e.src;
                int dest = e.des;
                int wt = e.wt;

                if (dis[u] != Integer.MAX_VALUE && dis[u] + wt < temp[dest]) {
                    temp[dest] = dis[u] + wt;
                }
            }

            dis = temp;
        }

        System.out.println("Shortest distance from " + src + " to " + trgt + " is " + (dis[trgt] == Integer.MAX_VALUE ? "unreachable" : dis[trgt]) + " with at most " + k + " stops.");
    }

    public static void main(String[] args) {
        List<Edge> edge = new ArrayList<>();
        int src = 0;
        int trgt = 4;
        int v = 5;
        int k = 4;

        edge.add(new Edge(0, 1, 2));
        edge.add(new Edge(0, 2, 4));
        edge.add(new Edge(1, 2, 6));
        edge.add(new Edge(1, 3, -1));
        edge.add(new Edge(1, 4, 3));
        edge.add(new Edge(2, 3, 4));
        edge.add(new Edge(3, 4, 8));

        bellmanFord(edge, v, src, trgt, k);
    }
}
