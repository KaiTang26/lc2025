package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTLevelTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelOrders = new ArrayList<>();

        if (root == null) {
            return levelOrders;
        }

        Queue<TreeNode> treeLevel = new LinkedList<>();

        treeLevel.offer(root); // user offer

        while (!treeLevel.isEmpty()) {
            int size = treeLevel.size();
            List<Integer> nodeVals = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = treeLevel.poll();

                if (node.left != null) {
                    treeLevel.offer(node.left);
                }

                if (node.right != null) {
                    treeLevel.offer(node.right);
                }
                nodeVals.add(node.val);
            }

            levelOrders.add(nodeVals);

        }

        return levelOrders;

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
