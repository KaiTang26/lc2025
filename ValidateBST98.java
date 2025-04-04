public class ValidateBST98 {
    public boolean isValidBST1(TreeNode root) {

        return isValidBSTHelper(root).isValidBST;

    }

    private Result isValidBSTHelper(TreeNode node) {

        if (node == null) {
            return new Result(true, -1, -1);
        }

        if (node.left == null && node.right == null) {
            return new Result(true, node.val, node.val);
        }

        Result leftResult = isValidBSTHelper(node.left);
        Result righResult = isValidBSTHelper(node.right);

        if (node.left == null && righResult.isValidBST && node.val < righResult.min) {

            return new Result(true, node.val, righResult.max);

        }

        if (node.right == null && leftResult.isValidBST && node.val > leftResult.max) {

            return new Result(true, leftResult.min, node.val);

        }

        if (leftResult.isValidBST && righResult.isValidBST && node.val > leftResult.max
                && node.val < righResult.min) {

            return new Result(true, leftResult.min, righResult.max);

        } else {

            return new Result(false, -1, -1);
        }

    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long lowerB, long upperB) {
        if (node == null) {
            return true;
        }

        // Current node's value must be between min and max bounds
        if (node.val <= lowerB || node.val >= upperB) {
            return false;
        }

        // Left subtree must have values < node.val and right subtree must have values >
        // node.val
        return isValidBSTHelper(node.left, lowerB, node.val) &&
                isValidBSTHelper(node.right, node.val, upperB);
    }

    public boolean isValidBST(TreeNode root) {

        return helper(root).isValidBST;

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return new Result(true, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        Result leftResult = helper(node.left);
        Result rightResult = helper(node.right);

        if (leftResult.isValidBST && rightResult.isValidBST && leftResult.max < node.val
                && rightResult.min > node.val) {

            return new Result(true, Math.min(node.val, leftResult.min), Math.max(node.val, rightResult.max));
        }

        return new Result(false, -1, -1);

    }

}

class Result {
    boolean isValidBST;
    long min;
    long max;

    Result(boolean isValidBST, long min, long max) {
        this.isValidBST = isValidBST;
        this.min = min;
        this.max = max;
    }

}