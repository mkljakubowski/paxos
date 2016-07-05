package hackerrank.graph;

import java.util.Scanner;

class Graph {

    int[] edges;

    Graph(int[] e) {
        edges = e;
    }

    private void move(int cell, int move, int[] dist) {
        if (cell < 100 && dist[cell] > move) {
            dist[cell] = move + 1;
            if (edges[cell] > -1) {
                move(edges[cell], move, dist);
            } else {
                move(cell + 1, move + 1, dist);
                move(cell + 2, move + 1, dist);
                move(cell + 3, move + 1, dist);
                move(cell + 4, move + 1, dist);
                move(cell + 5, move + 1, dist);
                move(cell + 6, move + 1, dist);
            }
        }
    }

    int solve() {
        int[] dist = new int[100];
        for (int i = 0; i < 100; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        move(0, 0, dist);
        int result = dist[99];
        if (result > 100) {
            return -1;
        } else {
            return dist[99];
        }
    }
}

public class SnakesAndLadders {

    private static Scanner in = new Scanner(System.in);

    static Graph readGraph() {
        int laddersCount = Integer.parseInt(in.nextLine());
        int[] edges = new int[100];
        for (int i = 0; i < 100; i++) {
            edges[i] = -1;
        }
        for (int i = 0; i < laddersCount; i++) {
            String[] numsStr = in.nextLine().split(" ");
            int from = Integer.parseInt(numsStr[0]);
            int to = Integer.parseInt(numsStr[1]);
            edges[from - 1] = to - 1;
        }
        int snakesCount = Integer.parseInt(in.nextLine());
        for (int i = 0; i < snakesCount; i++) {
            String[] numsStr = in.nextLine().split(" ");
            int from = Integer.parseInt(numsStr[0]);
            int to = Integer.parseInt(numsStr[1]);
            edges[from - 1] = to - 1;
        }
        return new Graph(edges);
    }

    public static void main(String[] args) {
        int cases = Integer.parseInt(in.nextLine());
        for (int i = 0; i < cases; i++) {
            Graph graph = readGraph();
            System.out.println(graph.solve());
        }
    }
}
