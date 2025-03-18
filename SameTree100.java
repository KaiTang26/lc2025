public class SameTree100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // If both nodes are null, trees are identical at this point
        if (p == null || q == null) {
            return p == q;
        }

        // Check current node values and recursively check left and right subtrees
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

}
