
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class BSTIterator {

    Deque<TreeNode> nodes;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayDeque<>();
        iterateToNextLeftmostNodeFromCurrentRoot(root);
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        TreeNode nextNode = nodes.pop();
        iterateToNextLeftmostNodeFromCurrentRoot(nextNode.right);
        return nextNode.val;
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    private void iterateToNextLeftmostNodeFromCurrentRoot(TreeNode node) {
        while (node != null) {
            nodes.push(node);
            node = node.left;
        }
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left
                = left;
        this.right = right;
    }
}
