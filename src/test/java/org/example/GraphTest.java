package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GraphTest {

    @Test
    public void testAddEdge() {
        String[] vertices = { "A", "B", "C" };
        Graph graph = new Graph(3, vertices);

        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);

        int[][] adjMatrix = graph.getAdjMatrix();
        assertEquals(5, adjMatrix[0][1]);
        assertEquals(10, adjMatrix[1][2]);
        assertEquals(Integer.MAX_VALUE, adjMatrix[0][2]); // No hay borde entre A y C
    }

    @Test
    public void testGetVertexIndex() {
        String[] vertices = { "A", "B", "C" };
        Graph graph = new Graph(3, vertices);

        assertEquals(0, graph.getVertices().indexOf("A"));
        assertEquals(1, graph.getVertices().indexOf("B"));
        assertEquals(2, graph.getVertices().indexOf("C"));
    }
}
