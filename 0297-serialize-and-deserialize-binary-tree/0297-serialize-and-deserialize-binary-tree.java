/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private int index;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        index = 0;
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(String[] nodes) {

        if (nodes[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[index]));
        index++;

        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);

        return root;
    }
}