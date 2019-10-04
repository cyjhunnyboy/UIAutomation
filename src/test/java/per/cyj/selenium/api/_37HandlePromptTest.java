package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _37HandlePromptTest extends BaseTest {

    private String url = "http://192.168.126.128:8080/selenium/html/prompt.html";

    @Test(description = "操作JavaScript的Prompt弹窗")
    public void testHandlePrompt() throws Exception {
        // 访问被测试网页
        driver.navigate().to(url);
        Thread.sleep(1000);
        // 是有XPath方式定位页面上的单击按钮元素
        WebElement btn = driver.findElement(By.xpath("//input[@id='button']"));
        btn.click(); // 单击按钮
        Thread.sleep(1000);
        try {
            // 使用driver.switchTo().alert()获取一个Alert对象
            Alert prompt = driver.switchTo().alert();
            log.info("切换到alert弹窗-------------------{}", prompt);
            // 断言文字内容是否与预期一致
            Assert.assertEquals(prompt.getText(), "这是一个prompt弹出框");
            // 在prompt弹窗中输入内容
            prompt.sendKeys("想要改变命运，必须每天学习2小时");
            Thread.sleep(1000);
            // 单击prompt的“确定”按钮
            prompt.accept();
            // 再次点击页面上的input元素的button按钮
            Thread.sleep(1000);
            btn.click();
            Thread.sleep(1000);
            // 在prompt弹窗中输入内容
            prompt.sendKeys("想要改变命运，必须每天学习2小时");
            Thread.sleep(1000);
            // 单击prompt的“取消”按钮
            prompt.dismiss();
        } catch (NoAlertPresentException e) {
            log.error("尝试操作是prompt弹窗未找到", e);
        }
    }
}
