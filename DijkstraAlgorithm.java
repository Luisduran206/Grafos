
import java.util.Arrays;

public class DijkstraAlgorithm {
	
    public static void dijkstra(int[][] graph, int startNode) {
        int numNodes = graph.length; // obtiene el tamaño total de la matriz
        int[] distance = new int[numNodes]; // crea un arreglo del tamaño de numNodes
        boolean[] visited = new boolean[numNodes]; //se declara un arreglo de booleanos para determinar
        										   // que ya se han visitado

        // Inicialización de las distancias y el conjunto de nodos visitados
        Arrays.fill(distance, Integer.MAX_VALUE); // el arreglo de enteros es llenado con el máximo valor para int
        distance[startNode] = 0; //para el primer valor se inicializa en 0

        for (int i = 0; i < numNodes - 1; i++) {
            int minDistanceNode = minDistance(distance, visited); //llamada al método minDistance que obtiene la distancia  
            													  //hasta los nodos o vértices

            visited[minDistanceNode] = true;

            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph[minDistanceNode][j] != 0 &&
                    distance[minDistanceNode] != Integer.MAX_VALUE &&
                    distance[minDistanceNode] + graph[minDistanceNode][j] < distance[j]) {
                    distance[j] = distance[minDistanceNode] + graph[minDistanceNode][j];
                }
            }
        }

        // Imprimir las distancias mínimas desde el nodo de inicio
        System.out.println("Distancias mínimas desde el nodo " + startNode + ":");
        for (int i = 0; i < numNodes; i++) {
            System.out.println("Nodo " + i + ": " + distance[i]);
        }
    }

    private static int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
    	//Se crea una matriz que inicializa las distancias entre puntos
    	//si hay una distancia en la posición [0][1] de la matriz significa que 
    	//el punto 0 tiene conexión de grado 4 con el punto 1
        int[][] grafo = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(grafo, 0); // Llama a la función dijkstra desde el nodo 0, el cual representa
        					//el nodo desde el cuál se quieren conocer las distancias
    }
}
