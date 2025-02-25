import java.util.List;

public class Main {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(8);

        TreeNode root4 = new TreeNode(11);
        TreeNode root5 = new TreeNode(7);
        TreeNode root6 = new TreeNode(2);

        TreeNode root7 = new TreeNode(13);
        TreeNode root8 = new TreeNode(4);
        TreeNode root9 = new TreeNode(1);

        root.left = root2;
        root.right = root3;

        root2.left = root4;
        root4.left = root5;
        root4.right = root6;

        root3.left = root7;
        root3.right = root8;
        root8.right = root9;

        boolean meetTarget = PathSum112.hasPathSum(root, 22);

        System.out.print(meetTarget);

    }

}
