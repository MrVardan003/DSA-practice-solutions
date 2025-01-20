import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Graph {
    int v;
    List<LinkedList<Integer>> ancestors;

    Graph(int v) {
        this.v = v;
        ancestors = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            ancestors.add(new LinkedList<>());
        }
    }

    void addParent(int a, Integer b) {
        if (b != null) {
            ancestors.get(a).add(b);
        }
    }

    void algo() {
        int[] printable = new int[v];
        boolean[] present = new boolean[v];
        int p = 0;

        while (p < v) {
            for (int i = 0; i < v; i++) {
                if (!present[i]) {
                    if (ancestors.get(i).isEmpty()) {
                        printable[p] = i;
                        present[i] = true;
                        p++;
                    } else {
                        boolean check = true;
                        for (int parent : ancestors.get(i)) {
                            if (!present[parent]) {
                                check = false;
                                break;
                            }
                        }
                        if (check) {
                            printable[p] = i;
                            present[i] = true;
                            p++;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < v; i++) {
            System.out.print(printable[i] + " ");
        }
        System.out.println();
    }
}

public class TopologicalSort {
    public static void main(String[] args) {
        Graph graph = new Graph(12);

        graph.addParent(7, null);
        graph.addParent(8, null);
        graph.addParent(9, null);
        graph.addParent(10, null);
        graph.addParent(11, null);
        graph.addParent(3, 7);
        graph.addParent(3,8);
        graph.addParent(4,9);
        graph.addParent(5,10);
        graph.addParent(6,11);
        graph.addParent(1,3);
        graph.addParent(1,4);
        graph.addParent(2,5);
        graph.addParent(2,6);
        graph.addParent(0,1);
        graph.addParent(0,2);
        graph.addParent(7,10);
        graph.addParent(8,10);
        graph.addParent(9,10);

        graph.algo();
    }
}
