package per.cyj.selenium.browser;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用TestNG进行并发兼容性测试的测试类
 * @since 2019-08-04
 */
public class MultipleBrowserSearchTest {

    private WebDriver driver;
    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "访问sogou首页，在搜索输入框中输入文本内容，并点击“搜索”按钮")
    public void testMultipleBrowserSearch() throws Exception {
        // 打开sogou首页
        driver.get(baseUrl);
        Thread.sleep(2000);
        // 查找id为query的搜索输入框
        WebElement query = driver.findElement(By.id("query"));
        // 查找id为stb的搜索按钮
        WebElement btn = driver.findElement(By.id("stb"));
        Assert.assertTrue(query.isDisplayed());
        // 在搜索输入框中输入测试文本
        query.sendKeys("光荣之路自动化测试，飞起来！");
        Assert.assertTrue(btn.isDisplayed());
        // 单击“搜索”按钮
        btn.click();
        Thread.sleep(3000);
        // 断言搜索结果的页面是否包含测试数据中期望的关键词
        Assert.assertTrue(driver.getPageSource().contains("光荣之路自动化测试"));
    }

    @BeforeClass
    @Parameters("browser")
    public void beforeTest(String browser) {
        // 根据传入的参数判断是否使用哪个浏览器进行兼容性测试
        if (browser.equalsIgnoreCase("firefox")) {
            // 设定连接Firefox浏览器驱动程序所在的磁盘位置，并添加未系统属性值
            System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            // 设定连接IE浏览器驱动程序所在的磁盘位置，并添加未系统属性值
            System.setProperty("webdriver.ie.driver", "D:/Tools/driver/IEDriverServer_x64_2.53.0.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(capabilities);
        } else if (browser.equalsIgnoreCase("chrome")) {
            // 设定连接Chrome浏览器驱动程序所在的磁盘位置，并添加未系统属性值
            System.setProperty("webdriver.chrome.driver", "D:/Tools/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterTest() {
        driver.quit(); // 关闭打开的浏览器
    }
}
