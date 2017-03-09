package top.kou.will.algorithm;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/1.
 * 排序算法
 */
public class SortAlgorithm {

    /**
     * 选择排序：
     *   1、首先，找到数组中最小的那个元素
     *   2、其次，将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
     *   3、再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。
     */
    static class Selection {
        public static Integer[] sort(Integer[] data) {
            for (int i = 0; i < data.length - 2; i ++) {
                for (int j = i + 1; j < data.length - 1; j ++) {
                    if (data[i] > data[j]) {
                        int temp = data[i];
                        data[i] = data[j];
                        data[j] = temp;
                    }
                }
            }
            return data;
        }
    }

    /**
     * 冒泡排序
     * 1、对一组数中相邻的两个数比较，较大的数放后，这样每次比较，可以将未排过序的最大数放到最后，所谓冒泡
     * 2、每次只能将一个数排到正确的位置上，所以一共需要排序N-1次，最后一次只有一个数无需要排序
     * 3、每次只需要对前x个未经排序的数排序而非所有
     */
    public static Integer[] bubbleSort(Integer[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    /**
     * 插入排序
     * 1、从数组的第2位开始依次做岗哨
     * 2、岗哨位与其之前的有序数组依次比较，找到目标位置
     * 3、将目标位置之后（岗哨位之前）的数据统一后移一位
     */
    static class Insertion {
        public static Integer[] sort(Integer[] data) {
            for (int i = 1; i < data.length; i++) {
                int temp = data[i];

                int j = i - 1;
                while (j >= 0 && data[j] > temp) {
                    data[j + 1] = data[j];
                    j --;
                }

                if (j < 0) {
                    data[0] = temp;
                } else if (j > 0 && j != i -1) {
                    data[j] = temp;
                }
            }
            return data;
        }
    }

    public static void main(String[] args) throws Exception {
        Integer[] x = {3, 16, 2, 3, 6, 36, 25};
        Integer[] data = new Integer[10000];
        for (int i = 0; i < 10000; i ++) {
            data[i] = (int) (Math.random() * Integer.MAX_VALUE);
        }

        long start = System.currentTimeMillis();
        Insertion.sort(x);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(Arrays.deepToString(Selection.sort(x)));
    }
}
