import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.left.left = new TreeNode(5);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

       // TreeNode result = Solution.mergeTrees(t1, t2);


        for (List<String> list1 : printTree(t1)) {
            for (String str : list1) {
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
        public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            TreeNode result = null;

            if (t1 != null && t2 != null) {
                result = new TreeNode(t1.val + t2.val);
                result.left = mergeTrees(t1.left, t2.left);
                result.right = mergeTrees(t1.right, t2.right);
            }
            if (t1 != null && t2 == null) {
                result = new TreeNode(t1.val);
                result.left = mergeTrees(t1.left, null);
                result.right = mergeTrees(t1.right, null);
            }
            if (t1 == null && t2 != null) {
                result = new TreeNode(t2.val);
                result.left = mergeTrees(null, t2.left);
                result.right = mergeTrees(null, t2.right);
            }

            return result;
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
