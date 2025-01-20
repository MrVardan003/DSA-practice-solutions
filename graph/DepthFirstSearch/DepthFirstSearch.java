import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

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

    void makeDFS(int root) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(root, visited);
    }

    void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbour : adjList.get(vertex)) {
            if (!visited[neighbour]) {
                dfsUtil(neighbour, visited);
            }
        }
    }
}

public class DepthFirstSearch {
    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        graph.makeDFS(0);
    }
}
