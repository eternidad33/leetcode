//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 136 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        // 把字符串转换成字符数组
        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            // 不是元音字母，右移左指针,左移右指针
            if (!isVowel(str[i])) {
                i++;
                continue;
            }
            if (!isVowel(str[j])) {
                j--;
                continue;
            }

            //其余情况为元音字母的情况
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(str);
    }

    /**
     * 判断是否为元音字母
     *
     * @param c 要判断的字母
     * @return boolean
     */
    public boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
