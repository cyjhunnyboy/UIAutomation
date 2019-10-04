package per.cyj.selenium.api;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _39HandleFrameByPageSourceTest extends BaseTest {

    private String url = "http://192.168.126.128:8080/selenium/html/frameset.html";

    @Test(description = "使用Frame页面的HTML源码定位制定的Frame页面并进行操作")
    public void testHandleFrameByPageSource() throws Exception {
        String expected = "这是中间frame页面上的文字"; // 期望值
        String keyWords = "中间frame"; // 关键字
        driver.navigate().to(url); // 访问被测试网页
        Thread.sleep(1000); // 等待1秒钟
        // 找到页面上所有frame对象，并存储在名为frames的List容器中
        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        // 使用for循环变量frames容器中的所有frame页面，查找包含“中间frame”的frame页面
        log.info("预期结果是-----------------------{}", expected);
        for (WebElement frame : frames) {
            // 进入frame页面
            driver.switchTo().frame(frame);
            // 判断每个frame页面的HTML源码中是否包含“中间frame”几个关键字
            if (driver.getPageSource().contains(keyWords)) {
                // 如果包含关键字，则查找页面上的p标签页面对象
                WebElement frameText = driver.findElement(By.tagName("p"));
                log.info("实际结果是-----------------------{}", frameText.getText());
                // 断言页面上的p标签文字是否和期望值“expected”一致
                Assert.assertEquals(frameText.getText(), expected);
                break; // 找到制定的frame退出for循环
            } else {
                // 如果没有找到制定的frame，调用此代码，返回到frameset页面中，实现
                // 下次for循环中继续调用driver.switchTo().frame()方法，若果没有执行此行代码，则for循环会报错
                driver.switchTo().defaultContent();
            }
        }
        driver.switchTo().defaultContent();
    }
}
