package April7;

public class LargestBST {

    int largetBST = 0;

    public int largestBSTSubtree(TreeNode root) {

        helper(root);

        return largetBST;

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return new Result(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Result left = helper(node.left);
        Result right = helper(node.right);

        if (left.isBST && right.isBST && left.max < node.val && right.min > node.val) {

            largetBST = Math.max(largetBST, left.size + right.size + 1);

            return new Result(left.size + right.size + 1, true, Math.max(right.max, node.val),
                    Math.min(left.min, node.val));

        }

        return new Result(0, false, -1, -1);

    }

}

class Result {

    int size;
    boolean isBST;
    int min;
    int max;

    public Result(int size, boolean isBST, int max, int min) {

        this.size = size;
        this.isBST = isBST;
        this.max = max;
        this.min = min;

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