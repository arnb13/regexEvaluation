import java.util.*;

public class NFA {
    private char[] re; 
    private diGraph G; 
    private int M; 

    public NFA(String regexp) {
        M = regexp.length();
        re = regexp.toCharArray();
        G = buildEpsilonTransitionGraph();
    }

    public diGraph buildEpsilonTransitionGraph() {
        diGraph G = new diGraph(M + 1); 
        Stack<Integer> op = new Stack<Integer>();
        for (int i = 0; i < M; i++) {
            int lp = i;
   int rp = i;
            if (re[i] == '(' || re[i] == '|') {
                op.push(i);
            }
            else if (re[i] == ')') {
                rp = i;
                int or = op.pop();
                if (re[or] == '|') {
                    lp = op.pop();
                    G.addEdge(or, i);
                    G.addEdge(lp, or+1);
                }
                else { 
    lp = or; 
    }
            }
            if (i < M-1 && re[i+1] == '*') { 
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }
            if (i < M-1 && re[i + 1] == '+') { 
                G.addEdge(rp, lp);
                G.addEdge(rp, i + 1);
            }
            if (i < M-1 && re[i + 1] == '?') { 
                G.addEdge(lp, i + 1);
            }
            if (re[i] == '(' || re[i] == ')' || re[i] == '*' || re[i] == '+' || re[i] == '?') {
                G.addEdge(i, i + 1);
            }
        }
        return G;
    }

    public boolean matched(String txt) {
        DirectedDFS dfs = new DirectedDFS(G, 0);
        ArrayList<Integer> reachable = new ArrayList<Integer>();
        for (int i = 0; i < G.V(); i++) {
            if (dfs.marked(i)) {
                reachable.add(i);
            }
        }
        for (int i = 0; i < txt.length(); i++) {
            ArrayList<Integer> match = new ArrayList<Integer>();
            char character = txt.charAt(i);
            for (int v : reachable) {
                if (v == M) { 
    continue; 
    }
                if (re[v] == character) {
                    match.add(v+1);
                }
            }
            dfs = new DirectedDFS(G, match);
            reachable = new ArrayList<Integer>();
            for (int j = 0; j < G.V(); j++) {
                if (dfs.marked(j)) {
                    reachable.add(j);
                }
            }
        }
        for (int v : reachable) {
            if (v == M) { 
   return true;
   }
        }
        return false;
    }
}