import java.util.*;

public class Graph {
    int value;
    private static List<List<Integer>> neighbours;

    public static void BFS() {
        initializeGraph();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);

        List<Boolean> visited = new ArrayList<>();
        neighbours.forEach(x -> visited.add(false));


        while (!queue.isEmpty()) {
            int node = queue.remove();
            System.out.printf("%c ", node + 65);

            neighbours.get(node)
                    .stream()
                    .filter(x -> !visited.get(x))
                    .forEach(x -> {
                        visited.set(x, true);
                        queue.add(x);
                    });
        }
    }

    public static void DFS() {
        initializeGraph();

    }

    private static void initializeGraph() {
        neighbours = new ArrayList<>();

        neighbours.add(new ArrayList<>());
        neighbours.get(0).add(1);
        neighbours.get(0).add(2);

        neighbours.add(new ArrayList<>());
        neighbours.get(1).add(2);
        neighbours.get(1).add(4);

        neighbours.add(new ArrayList<>());
        neighbours.get(2).add(3);

        neighbours.add(new ArrayList<>());
        neighbours.get(3).add(4);

        neighbours.add(new ArrayList<>());
        neighbours.get(4).add(2);
        neighbours.get(4).add(5);

        neighbours.add(new ArrayList<>());
    }

}
