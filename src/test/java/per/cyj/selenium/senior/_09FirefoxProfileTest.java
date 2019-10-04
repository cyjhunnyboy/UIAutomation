package per.cyj.selenium.senior;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-10
 */
public class _09FirefoxProfileTest {

    private WebDriver driver;
    private String baseUrl = "http://www.sogou.com/";

    @BeforeMethod
    public void beforeMethod() {
        // 设定连接firefox浏览器驱动程序所在的磁盘位置，并添加为系统属性值
        System.setProperty("webdriver.gecko.driver", "D:/Tools/driver/geckodriver.exe");
    }

    @Test(description = "启动带用户配置信息的Firefox浏览器窗口")
    public void testFirefoxProfile() throws Exception {
        // 声明ProfilesIni对象
        ProfilesIni allProfiles = new ProfilesIni();
        // 调用allProfile对象的getProfile方法获得名为“WebDriver”的用户配置文件
        FirefoxProfile profile = allProfiles.getProfile("WebDriver");
        // 调用allProfile对象的setPreference方法，设定浏览器启动时显示的首页为sogou
        profile.setPreference("browser.startup.homepage", baseUrl);
        // 指定Profil对象作为参数，实例化FirefoxDriver对象
        // 实现使用指定Profile配置文件启动Firefox浏览器窗口
        driver = new FirefoxDriver(profile);
        // 找到页面上的搜索输入框
        WebElement inputBox = driver.findElement(By.id("query"));
        // 输入“WebDriver”关键词
        inputBox.sendKeys("WebDriver");
        // 单击搜索按钮
        driver.findElement(By.id("stb")).click();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭浏览器
    }
}
