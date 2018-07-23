public class Dijkstra {

    public static int[] dijkstra(int[][] graph,int x) {
        int[] result = new int[graph.length];
        boolean[] used = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            result[i] = Integer.MAX_VALUE;
            used[i] = false;
        }
        result[x] = 0;

        for (int n = 0; n < graph.length; n++) {
            int shortestPath = Integer.MAX_VALUE;
            int shortestPathNode = -1;
            for (int i = 0; i < graph.length; i++) {
                if (!used[i] && result[i] < shortestPath) {
                    shortestPath = result[i];
                    shortestPathNode = i;
                }
            }

            used[shortestPathNode] = true;
            for (int i = 0; i < graph.length; i++) {
                if (!used[i] && graph[shortestPathNode][i] != -1) {
                    int newDistance = shortestPath + graph[shortestPathNode][i];
                    if (result[i] > newDistance) {
                        result[i] = newDistance;
                    }
                }
            }
        }

        return result;
    }


}
