import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DirectedGraphTest
{

    @Test
    void testLCAof()
    {
        DirectedGraph graph;
        ArrayList<Integer> LCAs;

        /*
         * Tests for a Graph with no edges
         */
        graph = new DirectedGraph(4);

        // Test LCA of two different nodes
        LCAs = graph.LCAsOf(1, 2);
        assertEquals(0, LCAs.size(), "Test number of LCAs returned on LCA of 1 and 2 in a graph with no edges");

        // Test LCA of a node with itself
        LCAs = graph.LCAsOf(1, 1);
        assertEquals(1, LCAs.size(), "Test number of LCAs returned on LCA of 1 and 1");
        assertTrue(LCAs.contains(1), "Test that LCA of 1 and 1 produced correct LCA 1");

        /*
         * Tests for a single graph with multiple edges (Graph_1.png)
         */
        graph = new DirectedGraph(8);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 6);
        graph.addEdge(2, 7);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);

        // Test LCA of two different nodes that have only one lowest common ancestor
        LCAs = graph.LCAsOf(2, 3);
        assertEquals(1, LCAs.size(), "Test number of LCAs returned on LCA of 2 and 3 in graph 1");
        assertTrue(LCAs.contains(0), "Test that LCA of 2 and 3 produced the correct LCA 0");

        // Test LCA of two different nodes that have multiple common ancestors
        LCAs = graph.LCAsOf(7, 6);
        assertEquals(2, LCAs.size(), "Test number of LCAs returned on LCA of 7 and 6 in graph 1");
        assertTrue(LCAs.contains(2), "Test that LCA of 7 and 6 produced 2 as an LCA");
        assertTrue(LCAs.contains(5), "Test that LCA of 7 and 6 produced 5 as an LCA");

        // Test LCA of two different nodes where the LCA is one of the given nodes
        LCAs = graph.LCAsOf(4, 0);
        assertEquals(1, LCAs.size(), "Test number of LCAs returned on LCA of 4 and 0 in graph 1");
        assertTrue(LCAs.contains(0), "Test that LCA of 4 and 0 produced the correct LCA 0");

        /*
         * Tests for a graph with multiple subgraphs that are not connected to each other (Graph_2.png)
         */
        graph = new DirectedGraph(10);

        graph.addEdge(0, 2);
        graph.addEdge(1, 0);
        graph.addEdge(1, 8);
        graph.addEdge(2, 7);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 9);
        graph.addEdge(5, 6);
        graph.addEdge(8, 7);

        // Test LCA of two different nodes in the same subgraph
        LCAs = graph.LCAsOf(6, 9);
        assertEquals(1, LCAs.size(), "Test number of LCAs returned on LCA of 6 and 9 in graph 2");
        assertTrue(LCAs.contains(3), "Test that LCA of 6 and 9 produced the correct LCA 3");

        // Test LCA of two different nodes in different subgraphs
        LCAs = graph.LCAsOf(4, 2);
        assertEquals(0, LCAs.size(), "Test number of LCAs returned on LCA of 4 and 2 in graph 2");
    }

}