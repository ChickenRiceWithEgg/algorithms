package leetcode.easy;

/**
 * 查找字符串的公共前缀
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
//        String[] ss = {"dog", "racecar", "car"};
//        String[] ss = {"car"};
//        String[] ss = {};
        String[] ss = {"flower", "flow", "flight"};
        Long start1 = System.currentTimeMillis();
        for (int i = 1; i < 100 * 10000; i++) {
            m1(ss);
        }
        System.out.println(System.currentTimeMillis() - start1); //400多毫秒

        Long start2 = System.currentTimeMillis();
        for (int i = 1; i < 100 * 10000; i++) {
            m2(ss);
        }
        System.out.println(System.currentTimeMillis() - start2); //40多毫秒

    }

    /**
     * 暴力解法
     * 时间复杂度很高
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

    /**
     * 漂亮解法   和暴力解法的比较次数差不多，但是快了很多。不太理解 todo
     *
     * @param ss
     * @return
     */
    public static String m2(String[] ss) {

        if (ss.length == 0) {
            return "";
        }
        String common = ss[0];
        for (int i = 1; i < ss.length; i++) {
            int j = 0;
            for (; j < common.length() && j < ss[i].length(); j++) {
                if (common.charAt(j) != ss[i].charAt(j)) {
                    break;
                }
            }
            common = common.substring(0, j);
            if (common.equals("")) {
                return common;
            }
        }
        return common;
    }

}
