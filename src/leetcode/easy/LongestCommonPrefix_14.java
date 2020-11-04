package leetcode.easy;

/**
 * 查找字符串的公共前缀
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
//        String[] ss = {"flower", "flow", "flight"};
//        String[] ss = {"dog", "racecar", "car"};
        String[] ss = {"car"};
//        String[] ss = {};
        System.out.println(m1(ss));
    }

    /**
     * 暴力解法
     *
     * @param ss
     * @return
     */
    public static String m1(String[] ss) {
        if (ss.length < 1) {
            return "";
        }
        if (ss.length == 1) {
            return ss[0];
        }
        for (int i = 1; i < ss.length; i++) {
            String pre = ss[i - 1];
            String cur = ss[i];
            int length = Math.min(pre.length(), cur.length());
            String common = "";
            for (int j = 0; j < length; j++) {
                if (cur.toCharArray()[j] == pre.toCharArray()[j]) {
                    common += cur.toCharArray()[j];
                } else {
                    break;
                }
            }
            ss[i] = common;
        }
        return ss[ss.length - 1];
    }

}
