package April2;

public class LowestCommonAncestor {

    TreeNode LCA = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q);

        return LCA;
    }

    private Result helper(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return new Result(false, false);
        }

        Result left = helper(node.left, p, q);
        Result right = helper(node.right, p, q);

        boolean findP = left.findP || right.findP || node == p;
        boolean findQ = left.findQ || right.findQ || node == q;

        if (findP && findQ && LCA == null) {

            LCA = node;

        }

        return new Result(findP, findQ);

    }

}

class Result {

    boolean findP;
    boolean findQ;

    public Result(boolean findP, boolean findQ) {
        this.findP = findP;
        this.findQ = findQ;

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