package per.cyj.selenium.browser;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用Safari浏览器测试WebDriver的测试类
 * @since 2019-08-04
 */
public class VisitSogouBySafariTest {

    private WebDriver driver;
    private String baseUrl = "https://www.sogou.com/";

    /**
     * @throws Exception 抛出异常
     */
    @Test(description = "通过Safari浏览器来方位sogou首页，在搜索输入框中输入文本内容，并点击“搜索”按钮")
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
        Thread.sleep(5000);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SafariDriver();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭打开的浏览器
    }
}
