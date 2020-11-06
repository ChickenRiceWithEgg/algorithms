package leetcode.easy;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StrStr_28 {

    public static void main(String[] args) {
        String haystack = "aaabaa";
        String needle = "baa";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 暴力解法 很垃圾
     * 遍历haystack，根据needle长度生成临时字符串，和needle进行比较，若有则返回下标
     * 时间复杂度是O((hl-nl)nl)
     * 缺陷是：会将haystack上所有长度为nl的子字符串都与needle进行比较，但这不是必要的
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int hl = haystack.length();
        int nl = needle.length();
        if (nl > hl) {
            return -1;
        }
        if (nl == 0) {
            return 0;
        }

        for (int i = 0; i <= hl - nl; i++) {
            String tmp = "";
            for (int j = i; j < i + nl; j++) {
                tmp = tmp + haystack.charAt(j);
            }
            if (tmp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int m1(String haystack, String needle) {
    }

}