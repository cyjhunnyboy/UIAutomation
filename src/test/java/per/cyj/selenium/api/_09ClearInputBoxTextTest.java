package per.cyj.selenium.api;

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
public class _09ClearInputBoxTextTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/clear.html";

    @Test(description = "在输入框清除原有的文字内容")
    public void testClearInputBoxText() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        WebElement input = driver.findElement(By.id("text"));
        Assert.assertTrue(input.isDisplayed());
        // 清除文本框中的默认文字
        input.clear();
        Thread.sleep(1000);
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testClearInputBoxText()");
    }

}
