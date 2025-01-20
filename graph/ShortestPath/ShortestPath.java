import java.util.Arrays;

public class ShortestPath {

    int minDistance(int dist[], boolean visited[], int l) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < l; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    void dijkstra(int graph[][], int root, int l) {
        int dist[] = new int[l];
        boolean visited[] = new boolean[l];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        dist[root] = 0;

        for (int count = 0; count < l - 1; count++) {
            int u = minDistance(dist, visited, l);

            visited[u] = true;

            for (int v = 0; v < l; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, l);
    }

    void printSolution(int dist[], int l) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < l; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
            {0, 2, 0, 0, 4, 0},
            {2, 0, 6, 0, 0, 0},
            {0, 6, 0, 4, 8, 0},
            {0, 0, 4, 0, 0, 3},
            {4, 0, 8, 0, 0, 10},
            {0, 0, 0, 3, 10, 0}
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0, graph.length);
    }
}
