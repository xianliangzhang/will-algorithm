package top.kou.will.algorithm;

/**
 * Created by Administrator on 2017/3/1.
 * 查找算法
 */
public class SearchAlgorithm {

    /**
     * 二分法查找：
     */
    public static int binarySearch(int[] data, int target) {
        int low = 0;
        int high = data.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data[mid] > target) {
                high = mid - 1;
            }
            else if (data[mid] < target) {
                low = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = new int[]{
                1,3,5,6,7,8,9,22,34
        };
        System.out.println(binarySearch(data, 3));
    }
}
