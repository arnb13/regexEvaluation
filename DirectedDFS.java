import java.util.ArrayList;

public class DirectedDFS {
    private boolean flag [];

    public DirectedDFS(diGraph g, int s) {
        flag = new boolean[ g.V () ];
        dfs(g, s);
    }

    public DirectedDFS(diGraph g, ArrayList<Integer> vertices) {
        flag = new boolean[ g.V() ];
        for (int v : vertices) {
            if (!flag[v]) { 
   dfs(g, v); 
   }
        }
    }

    private void dfs(diGraph g, int s) {
        flag[s] = true;
        ArrayList <Integer> adj = g.adj(s);
        for (int v : adj) {
            if (!flag[v]) { 
   dfs(g, v); 
   }
        }
    }

    public boolean marked(int v) {
        return flag[v];
    }
}