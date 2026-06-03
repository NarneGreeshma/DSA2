import java.util.*;

public class CO3 {

    private int vertices;
    private LinkedList<Integer>[] adjList;

    CO3(int v) {
        vertices = v;
        adjList = new LinkedList[v];

        for (int i = 0; i < v; i++)
            adjList[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    void BFS(int start, String[] content) {

        boolean[] visited = new boolean[vertices];

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.println("\nRecommended Content Order:\n");

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.println(content[node]);

            for (int neighbour : adjList[node]) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {

        String[] content = {
                "Stranger Things",
                "Dark",
                "Wednesday",
                "Black Mirror",
                "Money Heist",
                "Lucifer"
        };

        CO3 graph = new CO3(6);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);

        System.out.println("======================================");
        System.out.println(" NETFLIX CONTENT RECOMMENDATION SYSTEM");
        System.out.println("======================================");

        System.out.println("\nContent Connections:");

        System.out.println("Stranger Things <-> Dark");
        System.out.println("Stranger Things <-> Wednesday");
        System.out.println("Dark <-> Black Mirror");
        System.out.println("Wednesday <-> Lucifer");
        System.out.println("Black Mirror <-> Money Heist");

        graph.BFS(0, content);

        System.out.println("\nBFS Traversal Complexity: O(V + E)");
    }
}