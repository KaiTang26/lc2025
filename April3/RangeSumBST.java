package April3;

public class RangeSumBST {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {

        helper(root, low, high);

        return sum;

    }

    private void helper(TreeNode node, int low, int high) {

        if (node == null) {
            return;
        }

        if (node.val >= low && node.val <= high) {
            sum = sum + node.val;
        }

        helper(node.left, low, high);

        helper(node.right, low, high);

    }

}
