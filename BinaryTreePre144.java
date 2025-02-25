import java.util.ArrayList;
import java.util.List;

public class BinaryTreePre144 {

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> orders = new ArrayList<>();

        traversal(orders, root);

        return orders;

    }

    private static void traversal(List<Integer> list, TreeNode node) {

        if (node == null) {
            return;
        }
        list.add(node.val);
        traversal(list, node.left);
        traversal(list, node.right);
    }

}
