package April3;

public class InorderSuccessorInBST {

    TreeNode target = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        helper(root, p);

        return target;

    }

    private void helper(TreeNode node, TreeNode p) {

        if (node == null) {
            return;
        }

        if ((target == null || target.val > node.val) && node.val > p.val) {
            target = node;
        }

        if (node.val > p.val) {
            helper(node.left, p);
        } else {
            helper(node.right, p);
        }

    }

}
