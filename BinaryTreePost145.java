import java.util.ArrayList;
import java.util.List;

public class BinaryTreePost145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> orders = new ArrayList<>();

        traversal(orders, root);
        return orders;

    }

    private void traversal(List<Integer> list, TreeNode node) {

        if (node == null) {
            return;
        }

        traversal(list, node.left);
        traversal(list, node.right);
        list.add(node.val);
    }

}
