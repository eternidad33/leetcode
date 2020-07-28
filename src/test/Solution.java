package test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vigilr
 * @since 2020-07-28
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        //递归方法
//        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        //广度优先搜索
        if (root == null) {
            return 0;
        } else {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int ans = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.remove();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    size--;
                }
                ans++;
            }
            return ans;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}