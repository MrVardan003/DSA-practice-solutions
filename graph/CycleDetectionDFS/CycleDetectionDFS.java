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

    boolean makeDFS(int root) {
        boolean[] visited = new boolean[vertices];
        boolean[] recStack = new boolean[vertices];
        return dfsUtil(root, visited, recStack);
    }

    boolean dfsUtil(int vertex, boolean[] visited, boolean[] recStack) {
        if (recStack[vertex]) {
            System.out.println("Cycle detected");
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        
        visited[vertex] = true;
        recStack[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbour : adjList.get(vertex)) {
            if (dfsUtil(neighbour, visited, recStack)) {
                return true;
            }
        }
        
        recStack[vertex] = false;
        return false;
    }
}

public class CycleDetectionDFS {
    public static void main(String[] args) {
        int vertices = 5;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        if (!graph.makeDFS(0)) {
            System.out.println();
            System.out.println("No cycle detected");
        }
    }
}
