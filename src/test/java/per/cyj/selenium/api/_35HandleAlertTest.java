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
public class _35HandleAlertTest extends BaseTest {

    private String url = "http://192.168.126.128:8080/selenium/html/alert.html";

    @Test(description = "操作JavaScript的Alert弹窗")
    public void testHandleAlert() throws Exception {
        // 访问被测试网页
        driver.navigate().to(url);
        Thread.sleep(1000);
        // 是有XPath方式定位页面上的单击按钮元素
        WebElement btn = driver.findElement(By.xpath("//input[@id='button']"));
        btn.click(); // 单击按钮
        Thread.sleep(1000);
        try {
            // 使用driver.switchTo().alert()获取一个Alert对象
            Alert alert = driver.switchTo().alert();
            // 短信文字内容是否与预期一致
            Assert.assertEquals(alert.getText(), "这是一个alert弹出框");
            alert.accept();
            Thread.sleep(1000);
        } catch (NoAlertPresentException e) {
            log.error("尝试操作是alert弹窗未找到", e);
        }
    }
}
