package graph;

import java.util.Scanner;

public class Dijkstra {
    boolean vis[];
    int dis[];

    public Dijkstra(int m) {
        vis = new boolean[m];
        dis = new int[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of vertex and edges");
        int V = sc.nextInt();
        int e = sc.nextInt();
        int a[][] = new int[V][V];
        System.out.println("Enter details for adjacency matrix now: ");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            a[u][v] = w;
            a[v][u] = w;
        }

        Dijkstra dij = new Dijkstra(V);
        dij.dijkstra(a, V, e);
    }

    private void dijkstra(int[][] a, int v, int e) {
        dis[0] = 0;
        for (int i = 1; i < v; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < v; i++) {
            int minVertex = findMinVertex(v);
            vis[minVertex] = true;
            // Explore neighbours
            for (int j = 0; j < v; j++) {
                if (a[minVertex][j] != 0 && !vis[j]) {
                    int newDist = dis[minVertex] + a[minVertex][j];
                    if (newDist < dis[j]) {
                        dis[j] = newDist;
                    }
                }
            }
        }

        for (int i = 0; i < v; i++)
            System.out.println(i + " " + dis[i]);
    }

    private int findMinVertex(int v) {
        int minVertex = -1;
        for (int j = 0; j < v; j++) {
            if (!vis[j] && (minVertex == -1 || dis[j] < dis[minVertex])) {
                minVertex = j;
            }
        }
        return minVertex;
    }
}
