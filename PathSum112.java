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

     public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        // If it's a leaf node, check if the remaining sum equals the node value
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        
        // Subtract current node's value and recurse on children
        return hasPathSum2(root.left, targetSum - root.val) || 
               hasPathSum2(root.right, targetSum - root.val);
    }

}

// one version don't need helper function
