package per.cyj.selenium.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author chenyongjun
 * @apiNote 第一个Junit4测试WebDriver
 * @since 2019-07-30
 */
public class Junit4WebDriverTest {

    private WebDriver driver;
    // 设定要访问网站的地址
    private String baseUrl = "https://www.sogou.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:/Tools/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * 在搜狗首页搜索框中输入内容并点击“搜索”按钮
     *
     * @throws Exception 抛出异常
     */
    @Test
    public void test() throws Exception {
        // 打开搜狗首页
        driver.get(baseUrl);
        Thread.sleep(2000);
        // 在搜索输入框中输入“光荣之路自动化测试，飞起来！”
        driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试，飞起来！");
        // 单击“搜索”按钮
        driver.findElement(By.id("stb")).click();
        Thread.sleep(3000);
    }

    @After
    public void tearDown() {
        driver.quit(); // 关闭打开的浏览器
    }
}
