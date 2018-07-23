import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(0);
        tree.right = new TreeNode(2);

        tree = Solution.trimBST(tree, 1, 2);

        for (List<String> list : printTree(tree)) {
            for (String str : list) {
                System.out.print(str);
            }
            System.out.println();
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

    static class Solution {
        static TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return null;
            }
            if (root.val > R) {
                return trimBST(root.left, L, R);
            }
            if (root.val < L) {
                return trimBST(root.right, L, R);
            }
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);

            return root;
        }
    }

    static class Params {
        Params(TreeNode n, int ii, int ll, int rr) {
            root = n;
            i = ii;
            l = ll;
            r = rr;
        }

        TreeNode root;
        int i, l, r;
    }

    public static List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res)
            Arrays.fill(arr, " ");
        List<List<String>> ans = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res)
            ans.add(Arrays.asList(arr));
        return ans;
    }

    public static int getHeight(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            Queue<TreeNode> temp = new LinkedList();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
            }
            queue = temp;
        }
        return height;
    }

    public static void fill(String[][] res, TreeNode root, int i, int l, int r) {
        Queue<Params> queue = new LinkedList();
        queue.add(new Params(root, 0, 0, res[0].length));
        while (!queue.isEmpty()) {
            Params p = queue.remove();
            res[p.i][(p.l + p.r) / 2] = "" + p.root.val;
            if (p.root.left != null)
                queue.add(new Params(p.root.left, p.i + 1, p.l, (p.l + p.r) / 2));
            if (p.root.right != null)
                queue.add(new Params(p.root.right, p.i + 1, (p.l + p.r + 1) / 2, p.r));
        }
    }
}
