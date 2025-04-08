package April7;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        String ans = "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node == null) {
                    ans = ans + "null,";
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    ans = ans + node.val + ",";
                }

            }

        }

        ans = ans.substring(0, ans.length() - 1);

        return ans;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data == "") {
            return null;
        }

        String[] vals = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 0;
        index++;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            for (int i = 0; i <= 1; i++) {

                if (index < vals.length) {

                    String s = vals[index];

                    if (!s.equals("null")) {

                        TreeNode newNode = new TreeNode(Integer.parseInt(s));

                        if (i == 0) {
                            node.left = newNode;
                        } else {
                            node.right = newNode;
                        }

                        queue.offer(newNode);

                    }

                }

                index++;

            }

        }

        return root;

    }

}
