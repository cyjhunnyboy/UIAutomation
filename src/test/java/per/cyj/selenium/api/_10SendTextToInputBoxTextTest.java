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
public class _10SendTextToInputBoxTextTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/clear.html";

    @Test(description = "在输入框中输入指定内容")
    public void testSendTextToInputBoxText() throws Exception {
        String inputString = "测试工程师指定的输入内容";
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        WebElement input = driver.findElement(By.id("text"));
        Assert.assertTrue(input.isDisplayed());
        // 首先清除文本框中的原有内容，防止原有内容影响测试结果，建议清除掉
        input.clear();
        Thread.sleep(1000);
        // 将自定义变量中的内容输入到文本框中
        input.sendKeys(inputString);
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testSendTextToInputBoxText()");
    }

}
