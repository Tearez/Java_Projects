import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        List<String> list = Solution.binaryTreePaths(root);

        for (String str : list) {
            System.out.println(str);
        }
    }

    static class Solution {
        public static List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            int[] path = new int[1000];

            findPath(root, path, 0, result);

            return result;

        }

        public static void findPath(TreeNode root, int[] path, int pathLen, List<String> list) {
            if (root == null)
                return;

            path[pathLen] = root.val;
            pathLen++;
            if (root.left == null && root.right == null) {
                String str = "";
                for (int i = 0; i < pathLen; i++) {
                    str += path[i];
                    if (i == pathLen-1){
                        break;
                    }
                    str += "->";
                }
                list.add(str);
            } else {
                findPath(root.left, path, pathLen, list);
                findPath(root.right, path, pathLen, list);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
