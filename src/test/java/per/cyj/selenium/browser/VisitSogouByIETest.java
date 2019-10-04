package per.cyj.selenium.browser;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用IE浏览器测试WebDriver的测试类
 * @since 2019-08-04
 */
public class VisitSogouByIETest {

    private WebDriver driver;
    private String baseUrl = "https://www.sogou.com/";

    /**
     * @throws Exception 抛出异常
     */
    @Test(description = "通过IE浏览器来方位sogou首页，在搜索输入框中输入文本内容，并点击“搜索”按钮")
    public void testByIE() throws Exception {
        // 访问sogou首页
        driver.get(baseUrl);
        Thread.sleep(2000);
        WebElement inputElement = (new WebDriverWait(driver, 30)).until((
                ExpectedCondition<WebElement>) driver -> driver.findElement(By.id("query")));
        inputElement.sendKeys("光荣之路自动化测试，飞起来！");
        WebElement buttonElement = (new WebDriverWait(driver, 30)).until((
                ExpectedCondition<WebElement>) driver -> driver.findElement(By.id("stb")));
        buttonElement.click();
        Thread.sleep(3000);
    }

    @BeforeMethod
    public void beforeMethod() {
        // 设定连接IE浏览器驱动程序所在的磁盘位置，并添加未系统属性值
        System.setProperty("webdriver.ie.driver", "D:/Tools/driver/IEDriverServer_x64_2.53.0.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(capabilities);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭打开的浏览器
    }
}
