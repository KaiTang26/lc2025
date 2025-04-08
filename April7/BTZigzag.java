package April7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTZigzag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (isReverse) {

                    level.add(0, node.val);

                } else {

                    level.add(node.val);

                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

            ans.add(level);

            isReverse = !isReverse;

        }

        return ans;

    }

}
