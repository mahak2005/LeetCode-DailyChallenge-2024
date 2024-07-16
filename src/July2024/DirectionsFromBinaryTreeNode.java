package July2024;

public class DirectionsFromBinaryTreeNode {
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root==null){
            return null;
        }
        StringBuilder res=new StringBuilder();
        StringBuilder rootToStart=new StringBuilder();
        StringBuilder rootToDest=new StringBuilder();
        findPath(root, startValue,rootToStart);

        findPath(root, destValue,rootToDest);
        int i=0;
        while(i<rootToStart.length() && i< rootToDest.length()
                && rootToStart.charAt(i)==rootToDest.charAt(i)){
            i++;
        }
        for(int j=i;j<rootToStart.length();j++){
            res.append("U");
        }
        res.append(rootToDest.substring(i));
        return res.toString();
    }

    private boolean findPath(TreeNode root, int nodeValue, StringBuilder path){
        if(root==null){
            return false;
        }
        if(root.val==nodeValue){
            return true;
        }
        path.append("L");
        if(findPath(root.left, nodeValue, path)){
            return true;
        }
        path.deleteCharAt(path.length()-1);

        path.append("R");
        if(findPath(root.right, nodeValue, path)){
            return true;
        }
        path.deleteCharAt(path.length()-1);
        return false;
    }
}
