import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(Solution.averageOfLevels(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        static Map<Integer, Double> numbersByLevels = new HashMap<>();
        static Map<Integer, Integer> occurrencesByLevel = new HashMap<>();
        public static List<Double> averageOfLevels(TreeNode root) {
            findAverage(root, 0);
            for (int key : numbersByLevels.keySet()) {
                double average = numbersByLevels.get(key)/occurrencesByLevel.get(key);
                numbersByLevels.put(key, average);
            }
            return new ArrayList<>(numbersByLevels.values());
        }

        public static void findAverage(TreeNode node, int level) {
            if (node == null) {
                return;
            }

            if (numbersByLevels.containsKey(level)){
                int occurrence = occurrencesByLevel.get(level);
                occurrencesByLevel.put(level, occurrence+1);
                numbersByLevels.put(level, (numbersByLevels.get(level) + node.val));
            } else {

                occurrencesByLevel.put(level, 1);
                numbersByLevels.put(level, (double) node.val);
            }

            findAverage(node.left, level+1);
            findAverage(node.right, level+1);
        }
    }
}
