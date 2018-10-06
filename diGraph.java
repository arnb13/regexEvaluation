import java.util.ArrayList;

public class diGraph {
    private final int V;
    private final ArrayList<Integer>[] adj; //adjacency list

    public diGraph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public ArrayList<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }
}