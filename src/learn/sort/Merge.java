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
     * 递归  由顶向下
     */
    public static void sortRecursion(Integer[] a) {
        sortRecursion(a, 0, a.length - 1);
    }


    public static void sortRecursion(Integer[] a, int low, int high) {
        if (high <= low) {
            return;
        }

        //当low=0，high=1时，结果 low=1，mid=0
        // 下面两个sortRecursion的low和mid、mid+1和high都相等，
        // 那么根据上面的判断将会直接return，
        // 这样就会进行第一次的merge(a,0,0,1）
        int mid = low + (high - low) / 2;
        sortRecursion(a, low, mid);
        sortRecursion(a, mid + 1, high);
        merge(a, low, mid, high);  //当low=0，mid=0，high=1时，上面两个sortRecursion会直接return，那么这里会进行第一次merge，结果是将两个数字进行有序
    }

    /**
     * 迭代  由底向上
     */
    public static void sortIteration(Integer[] a) {
        int n = a.length;
        for (int sz = 1; sz < n; sz = sz + sz) {  //sz是子数组大小 sz=1表示子数组大小为1，即两个单独的数字之间进行递归
            for (int low = 0; low < n - sz; low += sz + sz) { //从左到右，不断让相邻两个sz大小的子数组进行递归
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

        //aux作为辅助数组，复制了原数组，用来遍历，这样原数组就能原地进行修改了
        int[] aux = new int[a.length];
        for (int k = 0; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            //当递归到sz=1时，会出现 3->2 或者 4->1，使得两个数字有序
            if (i > mid) {
                a[k] = aux[j++]; //1
            } else if (j > high) {
                a[k] = aux[i++]; //2
            } else if ((aux[j] < aux[i])) {
                a[k] = aux[j++];  //3
            } else {
                a[k] = aux[i++];  //4
            }
        }

    }
}
