package top.kou.will.pattern;

/**
 * Created by Administrator on 2017/3/9.
 * 桥接模式：链接两端变化，做出最终决策
 * 示例：车行在路上，车有最小速度，路也有最小速度，不同的车行走在不同的路上，取两者中最较小的最小速度
 */
public class BridgePattern {
    // 公路有限速
    interface Road {
        int maxSpeed();
        int minSpeed();
    }

    // 汽车有限速
    interface Vehicle {
        int maxSpeed();
        int minSpeed();
    }

    // 驾驶员有限速
    interface Driver {
        int maxSpeed();
        int minSpeed();
    }

    // 桥
    static class OnRoad {
        private Road road;
        private Driver driver;
        private Vehicle vehicle;

        public OnRoad(Road road, Driver driver, Vehicle vehicle) {
            this.road = road;
            this.driver = driver;
            this.vehicle = vehicle;
        }

        public void run() {
            int speed = Math.min(driver.minSpeed(), Math.min(road.minSpeed(), vehicle.minSpeed()));
            System.out.println(String.format("Going >> [road[%d-%d], [driver[%d-%d]], vehicle[%d-%d], real[%d]]",
                    road.minSpeed(), road.maxSpeed(), driver.minSpeed(), driver.maxSpeed(), vehicle.minSpeed(), vehicle.maxSpeed(), speed));
        }
    }

    public static void main(String[] args) {
        Road street = new Road() {
            @Override
            public int maxSpeed() {
                return 30;
            }

            @Override
            public int minSpeed() {
                return 5;
            }
        };

        Driver maleDriver = new Driver() {
            @Override
            public int maxSpeed() {
                return 200;
            }

            @Override
            public int minSpeed() {
                return 79;
            }
        };

        Driver femaleDriver = new Driver() {
            @Override
            public int maxSpeed() {
                return 90;
            }

            @Override
            public int minSpeed() {
                return 20;
            }
        };

        Vehicle car = new Vehicle() {
            @Override
            public int maxSpeed() {
                return 200;
            }

            @Override
            public int minSpeed() {
                return 70;
            }
        };

        new OnRoad(street, maleDriver, car).run();
        new OnRoad(street, femaleDriver, car).run();
    }

}
