package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Graph {
    private int[][] adjMatrix;
    private List<String> vertices;
    private int numVertices;

    public Graph(int numVertices, String[] vertices) {
        this.vertices = new ArrayList<>(Arrays.asList(vertices));
        this.numVertices = numVertices;
        this.adjMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void addEdge(String city1, String city2, int weight) {
        int indexCity1 = getVertexIndex(city1);
        int indexCity2 = getVertexIndex(city2);

        adjMatrix[indexCity1][indexCity2] = weight;
    }

    private int getVertexIndex(String city) {
        return vertices.indexOf(city);
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public List<String> getVertices() {
        return vertices;
    }
}