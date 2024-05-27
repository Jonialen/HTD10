package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/guategrafo.txt"));
            int numVertices = scanner.nextInt();
            String[] vertices = new String[numVertices];

            for (int i = 0; i < numVertices; i++) {
                vertices[i] = scanner.next();
            }

            Graph graph = new Graph(numVertices, vertices);

            while (scanner.hasNextLine()) {
                String city1 = scanner.next();
                String city2 = scanner.next();
                int weight = scanner.nextInt();

                graph.addEdge(city1, city2, weight);
            }

            scanner.close();

            FloydWarshall.floydWarshall(graph);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado.");
        }
    }
}