package per.cyj.selenium.testng;

import org.testng.annotations.Test;

/**
 * @author chenyongjun
 * @apiNote 这是一个测试testNG的依赖性测试类
 * @since 2019-08-04
 */
public class DependentTest {

    @Test(dependsOnMethods = {"openBrower"})
    public void signIn() {
        System.out.println("signIn方法被调用");
    }

    @Test
    public void openBrower() {
        System.out.println("openBrower方法被调用");
    }

    @Test(dependsOnMethods = {"signIn"})
    public void Logout() {
        System.out.println("logout方法被调用");
    }
}
