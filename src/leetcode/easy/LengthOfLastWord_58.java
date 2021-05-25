package leetcode.easy;

/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 */
public class LengthOfLastWord_58 {

    /**
     * 使用了split
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        int length = s1.length;
        if (length == 0) {
            return 0;
        }
        String last = s1[length - 1];
        return last.length();
    }

    /**
     * 没用split
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' == s.charAt(i)) {
                if (count == 0) {
                    continue;
                }
                break;
            }
            count++;
        }
        return count;
    }

    /**
     * 消除了continue和break
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (' ' != s.charAt(i - 1)) {
                count++;
            } else if (count != 0) {
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "hello world ";
        System.out.println(lengthOfLastWord(s));
    }

}
