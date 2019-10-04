package per.cyj.selenium.testng;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

/**
 * @author chenyongjun
 * @apiNote 第一个使用TestNG测试WebDriver的测试类
 * @since 2019-07-30
 */
public class TestNGWebDriverTest {

    public WebDriver driver;
    // 设定访问网站的地址
    public String baseUrl = "https://www.sogou.com/";

    @Test(description = "测试搜狗搜索查询")
    public void testSearch() {
        // 打开搜狗首页
        driver.get(baseUrl + "/");
        // 在搜索输入框中输入“光荣之路自动化测试，飞起来！”
        driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试，飞起来！");
        // 单击“搜索”按钮
        driver.findElement(By.id("stb")).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        // 若无法打开Firefox浏览器时，可设定Firefox浏览器的安装路径
        System.setProperty("webdriver.chrome.driver", "D:/Tools/driver/chromedriver.exe");
        // 打开Firefox浏览器
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("测试方法testSearch开始运行之前被执行");
    }

    @AfterMethod
    public void afterMethod() {
        // 关闭打开的浏览器
        driver.quit();
        System.out.println("测试方法testSearch运行结束后执行");
    }

}
