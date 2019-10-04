package per.cyj.selenium.po.test;

import org.testng.annotations.Test;
import per.cyj.selenium.po.page.LoginPage2;
import org.testng.Assert;

/**
 * 操作126邮箱登录测试类
 *
 * @author chenyongjun
 */
public class Operate126MailTest2 {

    @Test
    public void testLogin() throws InterruptedException {
        // 生成一个 LoginPage 对象
        LoginPage2 loginPage = new LoginPage2();
        // 调用登录页面对象的 load 方法访问被测试网址
        loginPage.load();
        // 调用登录页面对象的 login 方法完成登录操作
        loginPage.login("cyjhunny", "yongene1@3");
        // 等待 5 秒
        Thread.sleep(5000);
        // 调用登录页面对象的 getBooleanOfWaitForContains 方法显示等待确认页面是否加载完成，预期的关键字是否出现
        Assert.assertTrue(loginPage.getDriver().getPageSource().contains("红旗邮件"));
        // 调用登录页面对象的 quit 方法关闭浏览器
        loginPage.quit();
    }
}
