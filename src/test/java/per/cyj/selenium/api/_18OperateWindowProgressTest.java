package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.os.WindowsUtils;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-04
 */
@Slf4j
public class _18OperateWindowProgressTest {

    private WebDriver chrome;
    private WebDriver firefox;
    private InternetExplorerDriver ie;

    @BeforeMethod
    public void initDriver() {
        initFirefoxDriver();
        initChromeDriver();
        initIEDrier();
    }

    @Test(description = "杀掉Windows的浏览器进程")
    public void testOperateWindowsProgress() throws Exception {
        log.info("这是一个杀掉Windows的浏览器进程的测试案例！使用WindowsUtils.tryToKillByName(browserName)方法！");
        // 杀掉Windows进程中的Firefox浏览器进程，关闭所有的Firefox浏览器
        WindowsUtils.tryToKillByName("firefox.exe");
        Thread.sleep(1000);
        // 杀掉Windows进程中的Chrome浏览器进程，关闭所有Chrome浏览器
        WindowsUtils.tryToKillByName("chrome.exe");
        Thread.sleep(1000);
        // 杀掉Windows进程中的IE浏览器进程，关闭所有IE浏览器
        WindowsUtils.tryToKillByName("iexplore.exe");
        Thread.sleep(1000);
        log.info("测试用例{}执行成功！", "testOperateWindowsProgress()");
        log.info("杀掉Firefox浏览器进程，firefoxDriver={}", firefox);
        log.info("杀掉Chrome浏览器进程，chromeDriver={}", chrome);
        log.info("杀掉Internet Explorer浏览器进程，iexploreDriver={}", ie);
    }

    @AfterMethod
    public void quitDriver() {
        log.info("测试用例执行结束后，执行该方法！");
    }

    private void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "D:/Tools/driver/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        log.info("WebDriver初始化成功！-----------{}", chrome);
    }

    private void initFirefoxDriver() {
        System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        firefox = new FirefoxDriver();
        firefox.manage().window().maximize();
        log.info("WebDriver初始化成功！-----------{}", firefox);
    }

    private void initIEDrier() {
        System.setProperty("webdriver.ie.driver", "D:/Tools/driver/IEDriverServer_x86_2.53.0.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        ie = new InternetExplorerDriver(capabilities);
        ie.manage().window().maximize();
        log.info("WebDriver初始化成功！-----------{}", ie);
    }
}
