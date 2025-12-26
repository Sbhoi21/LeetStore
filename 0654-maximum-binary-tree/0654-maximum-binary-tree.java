class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        for (int num : nums) {
            TreeNode curr = new TreeNode(num);

            // smaller elements become left child
            while (!stack.isEmpty() && stack.peek().val < num) {
                curr.left = stack.pop();
            }

            // current becomes right child of stack top
            if (!stack.isEmpty()) {
                stack.peek().right = curr;
            }

            stack.push(curr);
        }

        // bottom of stack is root
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        return root;
    }
}
