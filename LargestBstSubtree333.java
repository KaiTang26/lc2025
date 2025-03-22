public class LargestBstSubtree333 {

    int largestBSTSubtreeNodes = 0;

    public int largestBSTSubtree(TreeNode root) {

        helper(root);

        return largestBSTSubtreeNodes;

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Result left = helper(node.left);
        Result right = helper(node.right);

        if (left.isValidBST && right.isValidBST && node.val >= left.max && node.val <= right.min) {

            int size = left.size + right.size + 1;
            int max = Math.max(node.val, right.max);
            int min = Math.min(node.val, left.min);

            if (size > largestBSTSubtreeNodes) {
                largestBSTSubtreeNodes = size;
            }

            return new Result(true, max, min, size);
        } else {
            return new Result(false, -1, -1, -1);
        }

    }

}

class Result {
    boolean isValidBST;
    int max;
    int min;
    int size;

    Result(boolean isValidBST, int max, int min, int size) {
        this.isValidBST = isValidBST;
        this.max = max;
        this.min = min;
        this.size = size;

    }
}
