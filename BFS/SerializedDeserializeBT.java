package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SerializedDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        String result = "";
        if (root == null) {
            return "";
        }

        Queue<TreeNode> rootQueue = new LinkedList<>();
        rootQueue.offer(root);

        while (!rootQueue.isEmpty()) {
            TreeNode node = rootQueue.poll();

            if (node != null) {
                result = result + node.val + ",";
                rootQueue.offer(node.left);
                rootQueue.offer(node.right);
            } else {
                result = result + "null,";
            }

        }

        return result.substring(0, result.length() - 1);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 1,2,3,null,null,4,5,null,null,null,null,

        if (data == "") {
            return null;
        }

        String[] dataArray = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[index]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        index++;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // for loop left and right node
            for (int i = 0; i < 2; i++) {

                if (index < dataArray.length && !dataArray[index].equals("null")) {
                    TreeNode newNode = new TreeNode(Integer.parseInt(dataArray[index]));
                    if (i == 0) {
                        node.left = newNode;

                    } else {
                        node.right = newNode;

                    }
                    queue.offer(newNode);
                }

                index++;
            }

        }

        return root;

    }

}
