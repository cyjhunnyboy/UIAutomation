package per.cyj.selenium.po.test;

import org.testng.annotations.Test;
import per.cyj.selenium.po.page.LoginPage3;
import org.testng.Assert;

/**
 * @author chenyongjun
 * @apiNote 操作126邮箱登录测试类
 * @since 2019-08-12
 */
public class Operate126MailTest3 {

    @Test
    public void testLogin() throws InterruptedException {
        // 生成一个 LoginPage 对象
        LoginPage3 loginPage = new LoginPage3();
        // 继承 LoadableComponent 类后，只要实现了覆盖的 load 方法，
        // 即使在没有定义 get 方法情况下，也可以进行 get 方法的调用
        // get 方法会默认调用页面对象类中的 load 方法
        loginPage.get();
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
