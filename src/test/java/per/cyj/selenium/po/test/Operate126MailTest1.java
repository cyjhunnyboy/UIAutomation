package per.cyj.selenium.po.test;

import org.testng.annotations.Test;

import per.cyj.selenium.po.page.LoginPage1;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

/**
 * 操作126邮箱登录测试类
 *
 * @author chenyongjun
 */
public class Operate126MailTest1 {

    private WebDriver driver;
    private String baseUrl = "http://mail.126.com";

    @Test
    public void testLogin() throws InterruptedException {
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 浏览器最大化
        driver.manage().window().maximize();
        // 访问被测试的网址
        driver.navigate().to(baseUrl);
        // 进入登录页 iframe 页面中
        driver.switchTo().frame("x-URS-iframe");
        // 生成一个 LoginPage 对象
        LoginPage1 loginPage = new LoginPage1(driver);
        // 直接使用页面对象的用户名元素对象，输入用户名
        loginPage.userName.sendKeys("cyjhunny");
        // 直接使用页面对象的密码元素对象，输入密码
        loginPage.password.sendKeys("yongene1@3");
        // 直接使用页面对象的登录按钮对象，进行单击操作
        loginPage.loginButton.click();
        // 等待5秒
        Thread.sleep(5000);
        // 断言登录后的页面是否包含“红旗邮件”关键字，来验证是否登录成功
        Assert.assertTrue(driver.getPageSource().contains("红旗邮件"));
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException, IOException {
        // 如果找到Firefox，设定Firefox的路径
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭浏览器
    }
}
