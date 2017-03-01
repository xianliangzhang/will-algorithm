package top.kou.will.algorithm;

/**
 * Created by Administrator on 2017/3/1.
 *
 * 求两个数的最大公约数
 */
public class MaxCommonDivisor {


    /**
     *  计算两个非负整数p 和q 的最大公约数：
     *  若 q 是0，则最大公约数为p。
     *  否则，将 p 除以 q 得到余数 r，p 和 q 的最大公约数即为 q 和 r 的最大公约数。
     */
    public static int execute(int p, int q) {
        int max = p > q ? p : q;
        int min = max == p ? q : p;

        if (min == 0) {
            return max;
        }

        int remainder = max % min;
        return execute(min, remainder);
    }

    /**
     * 世界上最愚蠢的办法，但还是可以解决问题
     *
     * 思路：从2开始递增到两个数中较小的那个，
     *      只要都能除尽就是公约数，由此可以求出最大公约数
     */
    public static int executeByPig(int p, int q) {
        int max = p > q ? p : q;
        int min = max == p ? q : p;

        for (int i = min; i > 1; i --) {
            if (min % i == 0 && max % i == 0) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(MaxCommonDivisor.executeByPig(10, 2));
    }
}
