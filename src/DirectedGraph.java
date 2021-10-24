import java.util.ArrayList;

// This class is for a Directed Graph, but will only be used as a DAG
public class DirectedGraph
{
    private class Edge
    {
        int v, w;

        protected Edge(int v, int w)
        {
            this.v = v;
            this.w = w;
        }

        protected int from()
        {
            return v;
        }

        protected int to()
        {
            return w;
        }
    }

    private final int V;
    private ArrayList[] adj;

    public DirectedGraph(int V)
    {
        this.V = V;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++)
        {
            adj[i] = new ArrayList<Edge>();
        }
    }

    public int V()
    {
        return V;
    }

    public int E()
    {
        int result = 0;
        for(int i = 0; i < V; i++)
        {
            result += adj[i].size();
        }
        return result;
    }

    public void addEdge(int from, int to)
    {
        adj[from].add(new Edge(from, to));
    }

    public ArrayList adjacent(int v)
    {
        return adj[v];
    }

    public ArrayList<Integer> LCAsOf(int a, int b)
    {
        // TODO implement LCA for Directed Acyclic Graphs
        return null;
    }
}
