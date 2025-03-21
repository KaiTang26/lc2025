import javax.print.DocFlavor.READER;

public class LCA {

    TreeNode LCA = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);

        return LCA;

    }

    private Result helper(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return new Result(false, false);
        }

        Result leftResult = helper(node.left, p, q);
        Result rigResult = helper(node.right, p, q);

        boolean findP = leftResult.findP || rigResult.findP;
        boolean findQ = leftResult.findQ || rigResult.findQ;

        if (findP && findQ) {
            if (LCA == null) {
                LCA = node;
            }

            return new Result(true, true);
        }

        if (node == p && findQ) {
            LCA = node;
            return new Result(true, true);
        }

        if (node == q && findP) {
            LCA = node;
            return new Result(true, true);
        }

        if (node == p || findP) {
            return new Result(true, false);
        }

        if (node == q || findQ) {
            return new Result(false, true);
        }

        return new Result(false, false);

    }

    class Result {
        boolean findP;
        boolean findQ;

        Result(boolean findP, boolean findQ) {
            this.findP = findP;
            this.findQ = findQ;

        }
    }

}
