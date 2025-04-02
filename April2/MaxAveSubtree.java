package April2;

public class MaxAveSubtree {

    double MAX_AVE = Integer.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {

        helper(root);

        return MAX_AVE;

    }

    private RESULT helper(TreeNode node) {

        if (node == null) {
            return new RESULT(0, 0);
        }

        RESULT left = helper(node.left);

        RESULT right = helper(node.right);

        double sum = left.sum + right.sum + node.val;
        double size = left.size + right.size + 1;

        MAX_AVE = Math.max(MAX_AVE, sum / size);

        return new RESULT(size, sum);

    }

}

class RESULT {

    double sum;
    double size;

    protected RESULT(double size, double sum) {

        this.size = size;
        this.sum = sum;

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
