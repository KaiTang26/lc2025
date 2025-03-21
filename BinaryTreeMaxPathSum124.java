public class BinaryTreeMaxPathSum124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        sumHelper(root);

        return maxSum;

    }

    private int sumHelper(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(sumHelper(node.left), 0);
        int rightSum = Math.max(sumHelper(node.right), 0);

        maxSum = Math.max(maxSum, leftSum + rightSum + node.val);

        return Math.max(leftSum + node.val, rightSum + node.val);
    }

}
