package per.cyj.selenium.testng;

import org.testng.annotations.Test;

/**
 * @author chenyongjun
 * @apiNote 这是一个测试用例分组的测试类
 * @since 2019-08-04
 */
public class GroupingTest {

    @Test(groups = {"人"})
    public void student() {
        System.out.println("学生方法被调用");
    }

    @Test(groups = {"人"})
    public void teacher() {
        System.out.println("老师方法被调用");
    }

    @Test(groups = {"动物"})
    public void cat() {
        System.out.println("猫方法被调用");
    }

    @Test(groups = {"动物"})
    public void dog() {
        System.out.println("狗方法被调用");
    }

    @Test(groups = {"人", "动物"})
    public void feeder() {
        System.out.println("饲养员方法被调用");
    }
}
