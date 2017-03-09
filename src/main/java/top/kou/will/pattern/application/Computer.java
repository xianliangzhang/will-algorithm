package top.kou.will.pattern.application;

import com.sun.deploy.util.StringUtils;
import org.springframework.util.NumberUtils;

/**
 * Created by Administrator on 2017/3/9.
 * 综合运用各种模式实现 加减乘除 运算
 */
public class Computer {
    /**
     * 策略模式实现各类计算器
     */
    interface Computable {
        double compute(double x, double y);
    }

    static class PlusComputer implements Computable {
        @Override
        public double compute(double x, double y) {
            return x + y;
        }
    }

    static class SubtractionComputer implements Computable {
        @Override
        public double compute(double x, double y) {
            return x - y;
        }
    }

    static class MultiplicationComputer implements Computable {
        @Override
        public double compute(double x, double y) {
            return x * y;
        }
    }

    static class DivisionComputer implements Computable {
        @Override
        public double compute(double x, double y) {
            return x / y;
        }
    }


    interface Task {
        String task();
        default boolean isFinished() {
            return task().matches("[+-]?\\d*.?\\d*");
        }
    }


}
