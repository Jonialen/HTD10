package org.example;

class FloydWarshall {
    public static void floydWarshall(Graph graph) {
        int numVertices = graph.getVertices().size();
        int[][] dist = new int[numVertices][numVertices];
        int[][] next = new int[numVertices][numVertices];

        int[][] adjMatrix = graph.getAdjMatrix();
        String[] vertices = graph.getVertices().toArray(new String[0]);

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                dist[i][j] = adjMatrix[i][j];
                next[i][j] = j;
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias más cortas
        System.out.println("Matriz de distancias más cortas:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (dist[i][j] == Integer.MAX_VALUE) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }

        // Calcular el centro del grafo
        int[] eccentricity = new int[numVertices];
        int maxEccentricity = 0;
        int centerVertex = -1;

        for (int i = 0; i < numVertices; i++) {
            int maxDist = Integer.MIN_VALUE;
            for (int j = 0; j < numVertices; j++) {
                if (dist[i][j] > maxDist) {
                    maxDist = dist[i][j];
                }
            }
            eccentricity[i] = maxDist;
            if (maxDist > maxEccentricity) {
                maxEccentricity = maxDist;
                centerVertex = i;
            }
        }

        System.out.println("El centro del grafo es: " + vertices[centerVertex]);
    }
}