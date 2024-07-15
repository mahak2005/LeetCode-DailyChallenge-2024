package July2024;

public class CreateBinaryTree {
    class TreeNode {
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] nodes=new TreeNode[100001];
        boolean[] isChild=new boolean[100001];
        for(int[] node:descriptions){
            if(nodes[node[0]] == null){
                nodes[node[0]] = new TreeNode(node[0]);
            }
            if(nodes[node[1]] == null){
                nodes[node[1]] = new TreeNode(node[1]);
            }
            if(node[2] == 1){
                nodes[node[0]].left = nodes[node[1]];
            }else{
                nodes[node[0]].right = nodes[node[1]];
            }
            isChild[node[1]] = true;
        }
        for(int[] node:descriptions){
            if(!isChild[node[0]]){
                return nodes[node[0]];
            }
        }
        return null;
    }
}
