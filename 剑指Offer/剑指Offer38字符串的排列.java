//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 175 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] permutation(String s) {
        //方法1：回溯
        char[] c = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(res, c, 0);
        return res.toArray(new String[res.size()]);
    }

    void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }

    void dfs(List<String> res, char[] c, int x) {
        if (x == c.length - 1) {
            //添加解决方案
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                //重复，剪枝
                continue;
            }
            set.add(c[i]);
            //将c[i]放在第x的位置
            swap(c, i, x);
            dfs(res, c, x + 1);
            swap(c, i, x);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
