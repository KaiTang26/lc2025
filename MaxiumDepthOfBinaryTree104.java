public class MaxiumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depthLeft = maxDepth(root.left) + 1;
        int depthRight = maxDepth(root.right) + 1;

        return depthLeft > depthRight ? depthLeft : depthRight;

    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        // Using Math.max is more concise than ternary operator
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
