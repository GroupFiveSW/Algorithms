package com.williamfiset.algorithms.graphtheory;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BellmanFordAdjacencyListTest {

    /**
     * Test case that asserts that Bellman-Ford algorithm finds the shortest paths
     * between a given starting node and all other nodes in the graph.
     */
    @Test
    public void bellmanFordTest() {
        int V = 6, start = 0;
        List<BellmanFordAdjacencyList.Edge>[] graph = BellmanFordAdjacencyList.createGraph(V);
        BellmanFordAdjacencyList.addEdge(graph, 0,1,4);
        BellmanFordAdjacencyList.addEdge(graph, 0,2,5);
        BellmanFordAdjacencyList.addEdge(graph, 1,4,8);
        BellmanFordAdjacencyList.addEdge(graph, 2,3,7);
        BellmanFordAdjacencyList.addEdge(graph, 3,5,2);
        BellmanFordAdjacencyList.addEdge(graph, 4,5,20);

        double[] d = BellmanFordAdjacencyList.bellmanFord(graph, V, start);

        double[] expected = new double[]{0.0,4.0,5.0,12.0,12.0,14.0};
        Assert.assertArrayEquals(d, expected, 0);
    }

    /**
     * Test case that asserts that if a node is unreachable then Bellman-Ford should
     * set the distance to that node to Infinity. In the following graph there is no
     * path to node 6, which means that the last elements in the returned array of doubles should
     * be set to infinity.
     */
    @Test
    public void bellmanFordInfinityTest() {
        int V = 7, start = 0;
        List<BellmanFordAdjacencyList.Edge>[] graph = BellmanFordAdjacencyList.createGraph(V);
        BellmanFordAdjacencyList.addEdge(graph, 0,1,4);
        BellmanFordAdjacencyList.addEdge(graph, 0,2,5);
        BellmanFordAdjacencyList.addEdge(graph, 1,4,8);
        BellmanFordAdjacencyList.addEdge(graph, 2,3,7);
        BellmanFordAdjacencyList.addEdge(graph, 3,5,2);
        BellmanFordAdjacencyList.addEdge(graph, 4,5,20);

        double[] d = BellmanFordAdjacencyList.bellmanFord(graph, V, start);

        double[] expected = new double[]{0.0,4.0,5.0,12.0,12.0,14.0, Double.POSITIVE_INFINITY};
        Assert.assertArrayEquals(d, expected, 0);
    }
}
