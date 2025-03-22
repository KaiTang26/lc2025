public class InorderSuccessorBST285 {

    TreeNode successor;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        helper(root, p);

        return successor;

    }

    private void helper(TreeNode node, TreeNode p) {

        if (node == null) {
            return;
        }

        if ((successor == null || successor.val > node.val) && node.val > p.val) {
            successor = node;
        }

        if (p.val >= node.val) {
            helper(node.right, p);
        } else {

            helper(node.left, p);
        }

    }

}
