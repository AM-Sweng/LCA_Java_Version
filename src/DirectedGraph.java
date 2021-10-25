import java.util.ArrayList;

// This class is for a Directed Graph, but will only be used as a DAG
// This is implemented where each node knows both its parents and its children
public class DirectedGraph
{
    // Arrays of arraylists, where each index represents a distinct node and the arraylist its parents/children
    private ArrayList<Integer>[] nodeParents;
    private ArrayList<Integer>[] nodeChildren;

    // Constructs a graph with a specified number of nodes and no edges
    public DirectedGraph(int numberOfNodes)
    {
        nodeParents = new ArrayList[numberOfNodes];
        nodeChildren = new ArrayList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++)
        {
            nodeParents[i] = new ArrayList<Integer>();
            nodeChildren[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int from, int to)
    {
        nodeParents[to].add(from);
        nodeChildren[from].add(to);
    }

    public ArrayList<Integer> LCAsOf(int a, int b)
    {
        // Find what ancestors the two given nodes have in common
        ArrayList<Integer> ancestorsOfA = ancestorsOf(a);
        ArrayList<Integer> ancestorsOfB = ancestorsOf(b);
        ArrayList<Integer> commonAncestors = new ArrayList<Integer>();
        for (int i = 0; i < ancestorsOfA.size(); i++)
        {
            for (int j = 0; j < ancestorsOfB.size(); j++)
            {
                if (ancestorsOfA.get(i).intValue() == ancestorsOfB.get(j).intValue())
                {
                    commonAncestors.add(ancestorsOfA.get(i));
                }
            }
        }

        // Check which ancestors have out-degree zero in the subgraph containing only the common ancestors
        ArrayList<Integer> LCAs = new ArrayList<Integer>();
        ArrayList<Integer> children;
        boolean hasOutDegreeZero;
        for (int i = 0; i < commonAncestors.size(); i++)
        {
            hasOutDegreeZero = true;
            children = nodeChildren[commonAncestors.get(i)];
            for (int j = 0; j < children.size(); j++)
            {
                if (commonAncestors.contains(children.get(j))) hasOutDegreeZero = false;
            }
            if (hasOutDegreeZero) LCAs.add(commonAncestors.get(i));
        }

        return LCAs;
    }

    public ArrayList<Integer> ancestorsOf(int a)
    {
        return ancestorsOf(a, new ArrayList<Integer>());
    }

    // Recursive function to find every ancestor of a node, using an accumulator.
    private ArrayList<Integer> ancestorsOf(int a, ArrayList<Integer> ancestors)
    {
        // Add the node 'a' if it is not already present
        if (!ancestors.contains(a)) ancestors.add(a);

        // find the ancestors of all of a's parents
        for (int i = 0; i < nodeParents[a].size(); i++)
            ancestors = ancestorsOf(nodeParents[a].get(i), ancestors);
        return ancestors;
    }
}
