import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToDoubleLinkedList {

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Result result = helper(root);

        result.large.right = result.small;
        result.small.left = result.large;

        return result.small;

    }

    private Result helper(Node node) {

        if (node == null) {
            return null;
        }

        Result newResult = new Result(null, null);

        Result lResult = helper(node.left);

        Result RResult = helper(node.right);

        if (lResult == null) {

            newResult.small = node;

        } else {

            lResult.large.right = node;
            node.left = lResult.large;
            newResult.small = lResult.small;
        }

        if (RResult == null) {
            newResult.large = node;
        } else {
            RResult.small.left = node;
            node.right = RResult.small;
            newResult.large = RResult.large;

        }

        return newResult;

    }

}

class Result {
    Node small;
    Node large;

    Result(Node sNode, Node lNode) {
        this.small = sNode;
        this.large = lNode;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};