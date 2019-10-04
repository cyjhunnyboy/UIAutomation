package per.cyj.selenium.testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * @author chenyongjun
 * @apiNote 测试报告中自定义日志
 * @since 2019-07-30
 */
public class TestngReporterTest {

    @Test
    public void openBrower() {
        System.out.println("openBrower方法被调用");
        Reporter.log("调用打开浏览器的方法");
    }

    @Test
    public void signIn() {
        System.out.println("signIn方法被调用");
        Reporter.log("调用登录的方法");
    }

    @Test
    public void logout() {
        System.out.println("logout方法被调用");
        Reporter.log("调用注销方法");
    }
}
