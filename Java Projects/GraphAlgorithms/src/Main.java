import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    final static int GRAPH_SIZE = 8;
    public static void main(String[] args) {
//        Arrays.stream(Dijkstra.dijkstra(getGraph(), 0))
//                .forEach(x -> System.out.printf("%d ", x));
        Arrays.stream(Kruskal.kruskal(getGraphKruskal(), 8))
                .forEach(x->System.out.printf("%d ", x));
    }

    private static int[][] getGraph() {
        int[][] graph = new int[GRAPH_SIZE][GRAPH_SIZE];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = 0;
            }
        }

        graph[0][1] = 4;
        graph[0][2] = 4;

        graph[1][0] = 4;
        graph[1][2] = 2;
        graph[1][3] = 5;
        graph[1][6] = 6;

        graph[2][0] = 4;
        //graph[2][1] = 1;
        graph[2][1] = 2;
        graph[2][6] = 3;

        graph[3][1] = 6;
        graph[3][5] = 1;
        graph[3][7] = 9;

        graph[4][7] = 4;

        graph[5][3] = 1;
        graph[5][6] = 6;
        graph[5][7] = 5;

        graph[6][1] = 5;
        graph[6][2] = 3;
        graph[6][5] = 6;

        graph[7][3] = 9;
        graph[7][4] = 4;
        graph[7][5] = 5;

        return graph;
    }

    private static List<int[]> getGraphKruskal(){
        List<int[]> graph = new ArrayList<>();

        graph.add(new int[]{0,2,2});
        graph.add(new int[]{0,3,3});
        graph.add(new int[]{0,4,2});
        graph.add(new int[]{1,2,7});
        graph.add(new int[]{1,6,7});
        graph.add(new int[]{2,4,6});
        graph.add(new int[]{2,5,7});
        graph.add(new int[]{3,5,6});
        graph.add(new int[]{3,7,2});
        graph.add(new int[]{5,7,1});
        graph.add(new int[]{5,7,2});
        graph.add(new int[]{6,7,2});

        return graph;
    }
}
