package per.cyj.selenium.browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用Firefox浏览器测试WebDriver的测试类
 * @since 2019-08-04
 */
public class VisitSogouByFirefoxTest {

    private WebDriver driver;
    private String baseUrl = "https://www.sogou.com/";

    /**
     * @throws Exception 抛出异常
     */
    @Test(description = "通过Firefox浏览器来方位sogou首页，在搜索输入框中输入文本内容，并点击“搜索”按钮")
    public void testByFirefox() throws Exception {
        // 访问sogou首页
        driver.get(baseUrl);
        Thread.sleep(5000);
        WebElement input = driver.findElement(By.id("query"));
        WebElement btn = driver.findElement(By.id("stb"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Assert.assertTrue(btn.isDisplayed());
        btn.click();
        Thread.sleep(3000);
    }

    @BeforeMethod
    public void beforeMethod() {
        // 设定连接Firefox浏览器驱动程序所在的磁盘位置，并添加未系统属性值
        System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭打开的浏览器
    }
}
