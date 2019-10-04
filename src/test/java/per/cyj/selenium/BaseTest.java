package per.cyj.selenium;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

/**
 * @author chenyongjun
 * @apiNote 测试基类
 * @since 2019-07-30
 */
@Slf4j
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    protected void initDriver() {
        try {
            ChromeDriverService service = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File("d:/tools/driver/chromedriver.exe"))
                    .usingAnyFreePort().build();
            service.start();
            driver = new ChromeDriver(service);
            driver.manage().window().maximize();
            log.info("WebDriver初始化成功！-----------{}", driver);
        } catch (Exception e) {
            Assert.fail("WebDriver初始化失败：", e);
        }
    }

    @AfterMethod(alwaysRun = true)
    protected void quitDriver() {
        driver.quit();
        log.info("WebDriver退出成功！---------WebDriver={}", driver);
    }
}
