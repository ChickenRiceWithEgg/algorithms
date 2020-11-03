package learn.sort;

/**
 * 选择排序
 * master
 */
public class Selection {

    public static void main(String[] args) {
        Integer[] a = {4, 2, 7, 9, 3, 5, 7, 9};
        CommonUtil.show(selection(a));
    }

    /**
     * 对数据进行选择排序
     *
     * @param a
     */
    public static Integer[] selection(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            CommonUtil.exchange(a, i, min);
        }
        return a;
    }
}
