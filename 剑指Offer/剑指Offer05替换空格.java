//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 56 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
//        //方法1：用StringBuilder直接遍历（0ms）
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        while (i < s.length()) {
//            char c = s.charAt(i);
//            if (c != ' ') {
//                sb.append(c);
//            }else {
//                sb.append("%20");
//            }
//            i++;
//        }
//        return sb.toString();

        //方法2：创建字符数组存储（0ms）
        int len = s.length();
        char[] result = new char[len * 3];
        int size = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                result[size++] = '%';
                result[size++] = '2';
                result[size++] = '0';
            } else {
                result[size++] = c;
            }
        }
        //记住这个方法new String(result, 0, size);
        String newStr = new String(result, 0, size);
        return newStr;

//        //方法3：直接用s.replace(" ","%20")或s.replaceAll(" ","%20");（0ms）
////        return s.replace(" ","%20");
//        return s.replaceAll(" ","%20");

//        //方法4：先遍历出空格数目（2ms）
//        int len = s.length();
//        int count = 0;
//        for (int i = 0; i < len; i++) {
//            if (s.charAt(i) == ' ') {
//                count++;
//            }
//        }
//
//        char[] ans = new char[len + 2 * count];
//        int j = ans.length - 1;
//        for (int i = len - 1; i >= 0; i--) {
//            if (s.charAt(i) != ' ') {
//                ans[j] = s.charAt(i);
//                j--;
//            } else {
//                ans[j--] = '0';
//                ans[j--] = '2';
//                ans[j--] = '%';
//            }
//        }
//        String result = new String(ans);
//        System.out.println("返回结果："+result);
//        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
