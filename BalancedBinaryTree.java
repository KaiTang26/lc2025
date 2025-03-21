public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return helper(root).isBalanced;

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return new Result(true, 0);
        }

        Result leftResult = helper(node.left);
        Result rigResult = helper(node.right);

        if (leftResult.isBalanced && rigResult.isBalanced && Math.abs(leftResult.height - rigResult.height) <= 1) {

            return new Result(true, Math.max(rigResult.height, leftResult.height) + 1);

        }

        return new Result(false, -1);

    }

    class Result {
        boolean isBalanced;
        int height;

        Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;

        }
    }

}
