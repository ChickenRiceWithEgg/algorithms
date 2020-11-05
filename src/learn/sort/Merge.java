package learn.sort;

/**
 * 归并排序
 */
public class Merge {

    public static void main(String[] args) {
        Integer[] a = {1, 4, 5, 4, 3, 2, 5, 7, 8, 0, 6, 4, 8, 3, 6, 8, 9, 0, 6, 5, 4, 2, 8, 6, 2, 6, 3, 7, 1, 9};
//        sortIteration(a);
        sortRecursion(a);
        CommonUtil.show(a);
    }

    /**
     * 递归
     */
    public static void sortRecursion(Integer[] a) {
        sortRecursion(a, 0, a.length - 1);
    }


    public static void sortRecursion(Integer[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        int mid = low + (high - low) / 2;
        sortRecursion(a, low, mid);
        sortRecursion(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 迭代
     */
    public static void sortIteration(Integer[] a) {
        int n = a.length;
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int low = 0; low < n - sz; low += sz + sz) {
                merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, n - 1));
            }
        }
    }

    /**
     * 将a[low...mid],a[mid+1...high]合并到一起
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(Integer[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;

        int[] aux = new int[a.length];
        for (int k = 0; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if ((aux[j] < aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }
}
