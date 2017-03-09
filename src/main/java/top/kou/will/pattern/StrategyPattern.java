package top.kou.will.pattern;

import org.apache.ibatis.annotations.Select;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/9.
 * 策略模式：为达到同一个目的，有很多办法可以做到，这就是策略模式
 * 示例：多种方法排序
 */
public class StrategyPattern {
    interface Sortable {
        int[] sort(int[] array);

        default void exchange(int[] array, int posx, int poxy) {
            if (posx < 0 || posx > array.length - 1 || poxy < 0 || poxy > array.length - 1) {
                throw new IndexOutOfBoundsException();
            }
            int temp = array[posx];
            array[posx] = array[poxy];
            array[poxy] = temp;
        }
    }


    /**
     * 选择排序：循环N次，每次选择出最小的数，放在一列数的第i个位置上
     */
    static class Selection implements Sortable {

        @Override
        public int[] sort(int[] array) {
            for (int i = 0; i < array.length - 1; i ++) {
                for (int j = i + 1; j < array.length; j ++) {
                    if (array[i] > array[j]) {
                        exchange(array, i, j);
                    }
                }
            }
            return array;
        }
    }

    /**
     * 插入排序：从第二个数开始，将其做为岗哨，
     * 与其前面一列已经排序好的数从后往前比较，
     * 将比岗哨大的数，统统向后移一位，然后将岗哨插入到之前正确的位置上
     */
    static class Insertion implements Sortable {
        @Override
        public int[] sort(int[] array) {
            for (int i = 1; i < array.length; i ++) {
                int temp = array[i];

                int j = i - 1;
                while (j >=0 && array[j] > temp) {
                    array[j+1] = array[j];
                    j --;
                }

                if (j != i - 1) {
                    array[j==-1 ? 0 : j] = temp;
                }
            }
            return array;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,2,6,7};

        // 选择排序 策略
        int[] arr2 = new Selection().sort(arr.clone());

        // 插入排序 策略
        int[] arr3 = new Insertion().sort(arr.clone());
        System.out.println( Arrays.toString(arr2) + ", " + Arrays.toString(arr3) );
    }
}
