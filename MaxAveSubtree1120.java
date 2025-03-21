public class MaxAveSubtree1120 {
    double maxAve = Double.MIN_VALUE;

    public double maximumAverageSubtree(TreeNode root) {

        helper(root);

        return maxAve;

    }

    private Result helper(TreeNode node) {

        if (node == null) {
            return new Result(0, 0);
        }

        Result leftResult = helper(node.left);
        Result RightResult = helper(node.right);

        double totalSum = leftResult.sum + RightResult.sum + node.val;

        int totalSize = leftResult.size + RightResult.size + 1;

        maxAve = Math.max(maxAve, (float) (totalSum / totalSize));

        return new Result(totalSize, totalSum);

    }

    class Result {
        int size;
        double sum;

        Result(int size, double sum) {
            this.size = size;
            this.sum = sum;

        }
    }

}
