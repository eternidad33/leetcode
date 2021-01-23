//请实现一个函数按照之字形顺序打印二叉树，
// 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
// 第三行再按照从左到右的顺序打印，其他行以此类推。
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
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
// 👍 67 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //层次遍历，双端队列
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //创建每层的数组
            LinkedList<Integer> temp = new LinkedList<>();
            //依次存储队列中的元素
            for (int i = queue.size(); i > 0; i--) {
                TreeNode t = queue.poll();
                //判断奇数层还是偶数层
                if (res.size() % 2 == 0) {
                    temp.addLast(t.val);
                }else {
                    temp.addFirst(t.val);
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
