package April1;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {

        // left root right

        List<Integer> ans = new ArrayList<>();

        if (root == null) {

            return ans;

        }

        List<Integer> left = inorderTraversal(root.left);

        List<Integer> right = inorderTraversal(root.right);

        ans.addAll(left);

        ans.addAll(right);
        ans.add(root.val);

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
