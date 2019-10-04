package per.cyj.selenium.browser;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用Chrome浏览器测试WebDriver的测试类
 * @since 2019-08-04
 */
public class VisitSogouByChromeTest {

    private WebDriver driver;
    private String baseUrl = "https://www.sogou.com/";

    /**
     * @throws Exception 抛出异常
     */
    @Test(description = "通过Chrome浏览器来方位sogou首页，在搜索输入框中输入文本内容，并点击“搜索”按钮")
    public void testByChrome() throws Exception {
        // 访问sogou首页
        driver.get(baseUrl);
        Thread.sleep(5000);
        WebElement query = driver.findElement(By.id("query"));
        WebElement btn = driver.findElement(By.id("stb"));
        Assert.assertTrue(query.isDisplayed());
        query.sendKeys("光荣之路自动化测试，飞起来！");
        Assert.assertTrue(btn.isDisplayed());
        btn.click();
        Thread.sleep(3000);
    }

    @BeforeMethod
    public void beforeMethod() {
        // 设定连接Chrome浏览器驱动程序所在的磁盘位置，并添加未系统属性值
        System.setProperty("webdriver.chrome.driver", "D:/Tools/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭打开的浏览器
    }
}
