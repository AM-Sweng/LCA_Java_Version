import java.util.ArrayList;

// This class is for a Directed Graph, but will only be used as a DAG
// This is implemented where each node only knows its parents and not its children
public class DirectedGraph
{
    private ArrayList[] nodeParents;

    public DirectedGraph(int V)
    {
        nodeParents = new ArrayList[V];
        for(int i = 0; i < V; i++)
        {
            nodeParents[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int from, int to)
    {
        nodeParents[to].add(from);
    }

    public ArrayList<Integer> LCAsOf(int a, int b)
    {
        // TODO implement LCA for Directed Acyclic Graphs
        return null;
    }
}
