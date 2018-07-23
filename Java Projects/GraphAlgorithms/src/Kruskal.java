import java.util.List;

public class Kruskal {
    public static int[] kruskal(List<int[]> graph, int graphSize) {
        int[] tree = new int[graphSize];
        boolean[] used = new boolean[graphSize];

        graph.sort((x, y) -> Integer.compare(x[2], y[2]));
        for (int i = 0; i <graphSize; i++) {
            tree[i] = -1;
            used[i] = false;
        }

        for (int[] edge : graph) {
            if (used[edge[0]] && used[edge[1]]) {
                continue;
            }
//
//            if (!used[edge[0]] && !used[edge[1]]) {
//                tree[edge[0]] = edge[1];
//            }
//
//            if (!used[edge[0]] && used[edge[1]]) {
//                tree[edge[0]] = edge[1];
//            }
//
//            if (used[edge[0]] && !used[edge[1]]) {
//                tree[edge[1]] = edge[0];
//            }
//
            if (tree[edge[0]]  == -1){
                tree[edge[0]]  = edge[1];
            }
            else {
                tree[edge[1]] = edge[0];
            }

            used[edge[0]] = true;
            used[edge[1]] = true;
        }


        return tree;
    }
}
