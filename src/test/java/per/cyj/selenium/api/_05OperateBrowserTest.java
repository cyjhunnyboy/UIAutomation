package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-04
 */
@Slf4j
public class _05OperateBrowserTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "操作浏览器窗口")
    public void testOperateBrowser() throws Exception {
        Thread.sleep(1000);
        // 声明一个Point对象，两个150表示浏览器的位置相对于屏幕的左上角(0,0)的横坐标距离和纵坐标距离
        Point point = new Point(150, 150);
        // 声明Dimension对象，两个500表示浏览器窗口的长度和宽度
        Dimension dimension = new Dimension(500, 500);
        // setPosition方法表示设定浏览器在屏幕上的位置为piont对象的坐标（150,150），在某些版本浏览器下此方法失效
        driver.manage().window().setPosition(point);
        Thread.sleep(1000);
        // setSize方法表示设定浏览器窗口的大小为长为500个单位和宽为500个单位
        driver.manage().window().setSize(dimension);
        Thread.sleep(1000);
        // getPosition方法表示获取浏览器在屏幕上的位置，在某些浏览器版本下此方法失效
        log.info("浏览器在屏幕上的位置是：{}", driver.manage().window().getPosition());
        // getSize方法表示获取当前浏览器窗口的大小
        log.info("浏览器窗口的大小是：{}", driver.manage().window().getSize());
        Thread.sleep(1000);
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // maximize方法表示将浏览器最大化
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testOperateBrowser()");
    }

}
