public class InsertNodeBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = root;

        while (node != null) {

            if (val < node.val) {

                if (node.left == null) {

                    node.left = new TreeNode(val);
                    return root;
                }

                node = node.left;

            } else {

                if (node.right == null) {
                    node.right = new TreeNode(val);
                    return root;
                }

                node = node.right;

            }

        }

        return new TreeNode(val);

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;

    }

}
