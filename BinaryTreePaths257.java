import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }

        List<String> leftPaths = binaryTreePaths(root.left);

        List<String> rightPaths = binaryTreePaths(root.right);

        for (String path : leftPaths) {

            String newPath = root.val + "->" + path;
            paths.add(newPath);
        }

        for (String path : rightPaths) {

            String newPath = root.val + "->" + path;
            paths.add(newPath);
        }

        return paths;

    }

}
