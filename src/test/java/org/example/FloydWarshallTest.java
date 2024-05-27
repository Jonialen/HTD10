package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FloydWarshallTest {

    @Test
    public void testFloydWarshall() {
        String[] vertices = {"A", "B", "C", "D"};
        Graph graph = new Graph(4, vertices);

        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 3);
        graph.addEdge("A", "C", 10);
        graph.addEdge("C", "D", 2);
        graph.addEdge("B", "D", 7);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        FloydWarshall.floydWarshall(graph);

        String expectedOutput = "Matriz de distancias más cortas:\n" +
                "0   1   4   6   \n" +
                "INF 0   3   5   \n" +
                "INF INF 0   2   \n" +
                "INF INF INF 0   \n" +
                "El centro del grafo es: A\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
