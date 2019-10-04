package per.cyj.selenium.po.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import per.cyj.selenium.po.page.HomePage;
import per.cyj.selenium.po.page.LoginPage;

/**
 * 多个 PageObject的自动化测试实例 自动化测试实现的3个步骤：
 * （1）在126邮箱，使用正确的用户名和错误的密码进行登录，登录失败并在页面显示“账号或密码错误”关键字
 * （2）在126邮箱，使用正确的用户密码和正确的密码进行登录，登录成功后跳转邮件箱文件夹列表首页，并且显示出“收件箱”关键字
 * （3）在126邮箱，登录成功后，单击“写信”链接，给cyjhunny@126.com发送一封邮件，邮件发送成功后页面显示“发送成功”关键字
 *
 * @author chenyongjun
 */
public class Operate126MailTest {

    public WebDriver driver;

    /**
     * 测试登录失败的测试用例
     *
     * @throws InterruptedException
     */
    // @Test
    public void testLoginFail() throws InterruptedException {
        // 生成一个 LoginPage 对象
        LoginPage loginPage = new LoginPage(driver);
        // 调用 LoginPage 类中的登录失败方法
        loginPage.LoginFailure("cyjhbnyy", "12334567");
        // 等待3秒
        Thread.sleep(3000);
        // 断言登录失败后的源代码中是否包含了“账号或密码错误”的关键字，调用 LoginPage 类中的 getPageSource 方法
        Assert.assertEquals(loginPage.getError().getText(), "账号或密码错误");
        // 调用 LoginPage 对象中的 close 方法关闭浏览器
        loginPage.close();
    }

    /**
     * 测试登录成功的测试用例
     *
     * @throws InterruptedException
     */
    // @Test
    public void testLoginSuccess() throws InterruptedException {
        // 生成一个 LoginPage 对象
        LoginPage loginPage = new LoginPage(driver);
        /*
         * 调用 LoginPage 类的 login 方法，登录成功后跳转到邮箱首页 login 方法会返回一个 HomePage
         * 对象，以此来实现页面跳转到了邮箱首页 以便实现在 HomePage 对象中进行相关的方法调用
         */
        HomePage homePage = loginPage.login("cyjhunny", "yongene1@3");
        // 等待3秒
        Thread.sleep(3000);
        // 断言登录后的页面是否包含“收件箱”关键字，来验证是否登录成功
        Assert.assertTrue(homePage.getPageSource().contains("收件箱"));
        // 关闭浏览器
        homePage.close();
    }

    /**
     * 测试发送邮件成功的测试用例
     *
     * @throws InterruptedException
     */
    @Test
    public void testWriteEmail() throws InterruptedException {
        // 生成一个 LoginPage 对象实例
        LoginPage loginPage = new LoginPage(driver);
        /*
         * 调用 LoginPage 类的 login 方法，登录成功后跳转到邮箱首页 login 方法会返回一个 HomePage
         * 对象，以此来实现页面跳转到了邮箱首页 以便实现在 HomePage 对象中进行相关的方法调用
         */
        HomePage homePage = loginPage.login("cyjhunny", "yongene1@3");
        // 等待3秒
        Thread.sleep(3000);
        // 调用 HomePage 类中写邮件方法，完成在页面上的发送邮件操作
        homePage.writeMail();
        // 等待3秒，等待邮件发送完成
        Thread.sleep(3000);
        // 断言邮件发送成功后，是否出现“发送成功”关键字，以此验证邮件是否发送成功
        Assert.assertTrue(homePage.getPageSource().contains("发送成功"));
        // 关闭浏览器
        homePage.close();
    }

    @BeforeMethod
    public void beforeMethod() {
        // 如果找到Firefox，设定Firefox的路径
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭浏览器
    }
}
