package per.cyj.selenium.testng;

import org.testng.annotations.Test;

/**
 * @author chenyongjun
 * @apiNote 这是一个特定顺序执行测试用例的测试类
 * @since 2019-08-04
 */
public class SequenceTest {

    @Test(priority = 3)
    public void test3() {
        System.out.println("test3方法被调用");
    }

    @Test(priority = 4, enabled = false)
    public void test4() {
        System.out.println("test4方法被调用");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("test1方法被调用");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("tset2方法被调用");
    }
}
