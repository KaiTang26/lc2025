public class MaxiumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depthLeft = maxDepth(root.left) + 1;
        int depthRight = maxDepth(root.right) + 1;

        return depthLeft > depthRight ? depthLeft : depthRight;

    }

}
