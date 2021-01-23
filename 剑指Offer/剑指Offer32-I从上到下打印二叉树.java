//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 57 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}

class Solution {
    public int[] levelOrder(TreeNode root) {
        //层次遍历
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //存储遍历数组
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            res.add(t.val);
            //左子树不为空，入队
            if (t.left != null) {
                queue.add(t.left);
            }
            //右子树不为空入队
            if (t.right != null) {
                queue.add(t.right);
            }
        }
        //将ArrayList转换成数组
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
