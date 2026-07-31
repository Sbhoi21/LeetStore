/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList();
        Traverse(root,"", list);
        return list;
    }

    void Traverse(TreeNode root, String str, List<String> list) {

        if (root.left == null && root.right == null) {
            list.add(str + root.val);
        }
        if (root.left != null) {
            Traverse(root.left, str + root.val + "->", list);
        }
        if (root.right != null) {
            Traverse(root.right, str + root.val + "->", list);
        }
    }
}