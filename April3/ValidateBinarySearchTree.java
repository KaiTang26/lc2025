package April3;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {

        return helper(root).isValidBST;

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result left = helper(node.left);
        Result right = helper(node.right);

        if (left.isValidBST && right.isValidBST && left.max < node.val && right.min > node.val) {
            return new Result(true, Math.min(left.min, node.val), Math.max(right.max, node.val));
        }

        return new Result(false, -1, -1);

    }

}

class Result {
    boolean isValidBST;
    long min;
    long max;

    public Result(boolean isValidBST, long min, long max) {
        this.isValidBST = isValidBST;
        this.min = min;
        this.max = max;

    }

}
