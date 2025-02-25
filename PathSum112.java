public class PathSum112 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        return traversal(root, 0, targetSum);

    }

    private static boolean traversal(TreeNode node, int sum, int targetSum) {

        if (node == null) {
            return false;
        }

        sum = sum + node.val;

        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }

        return traversal(node.left, sum, targetSum) || traversal(node.right, sum, targetSum);
    }

}

// one version don't need helper function
