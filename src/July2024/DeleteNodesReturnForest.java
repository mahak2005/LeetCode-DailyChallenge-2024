package July2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesReturnForest {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        root = dfs(root, set, res);
        if (root != null)
            res.add(root);
        return res;
    }
    private TreeNode dfs(TreeNode root, HashSet<Integer> to_delete, List<TreeNode> res) {
        if (root == null)
            return root;
        root.left = dfs(root.left, to_delete, res);
        root.right = dfs(root.right, to_delete, res);
        if (!to_delete.contains(root.val)) {
            return root;
        }
        if (root.left != null) {
            res.add(root.left);
        }
        if (root.right != null) {
            res.add(root.right);
        }
        return null;
    }
}

