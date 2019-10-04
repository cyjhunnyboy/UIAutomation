package per.cyj.selenium.senior;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import per.cyj.selenium.BaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import per.cyj.selenium.util.Log;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _16Log4jTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @BeforeClass
    public void beforeClass() {
        // 读取 log4j 配置文件 log4j.xml 的配置信息
        DOMConfigurator.configure("src/test/resources/config/log4j.xml");
    }

    @Test(description = "使用Log4j在测试过程中打印执行日志")
    public void testLog4j() throws Exception {
        // 向日志文件中打印testLog4j测试用例开始执行的日志信息
        Log.startTestCase("testLog4j");
        // 访问“sogou”首页
        driver.navigate().to(baseUrl);
        Log.info("打开 sogou 首页");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 在搜索框中输入“光荣之路自动化测试，飞起来”
        driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试，飞起来！");
        // 打印输入搜索关键字“光荣之路自动化测试，飞起来”的日志信息
        Log.info("输入搜索关键字“光荣之路自动化测试，飞起来！”");
        // 单击搜索按钮
        driver.findElement(By.id("stb")).click();
        // 打印单击搜索按钮的日志信息
        Log.info("单击搜索按钮");
        Thread.sleep(2000);
        // 向日志文件中打印testLog4j测试用例执行结束的日志信息
        Log.endTestCase("testLog4j");
    }

}
