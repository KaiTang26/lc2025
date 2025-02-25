import java.util.ArrayList;
import java.util.List;

public class BinaryTreeIn94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<>();

        traversal(orders, root);

        return orders;

    }

    private void traversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        traversal(list, node.left);
        list.add(node.val);
        traversal(list, node.right);
    }

}
