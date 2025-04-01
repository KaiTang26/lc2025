package April1;

public class BinaryTreeMaxPathSum {
    int MAX_PATH_SUM = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        MAX_PATH_SUM = Math.max(helper(root), MAX_PATH_SUM);

        return MAX_PATH_SUM;

    }

    private int helper(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = helper(node.left);

        int leftSum = left > 0 ? left : 0;

        int right = helper(node.right);

        int rightSum = right > 0 ? right : 0;

        MAX_PATH_SUM = Math.max(MAX_PATH_SUM, leftSum + rightSum + node.val);

        return Math.max(leftSum + node.val, rightSum + node.val);
    }

}
