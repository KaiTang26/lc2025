import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        if (root.left == null && root.right == null) {
            ans.add(String.valueOf(root.val));
            return ans;
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);

        for (String s : right) {
            ans.add(String.valueOf(root.val) + "->" + s);
        }

        for (String s : left) {
            ans.add(String.valueOf(root.val) + "->" + s);
        }

        return ans;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}