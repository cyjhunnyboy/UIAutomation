package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _12DoubleClickTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/doubleclick.html";

    @Test(description = "双击某个元素")
    public void testDoubleClick() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 根据id值“inputBOx”找到页面的输入框元素
        WebElement inputBox = driver.findElement(By.id("inputBox"));
        Assert.assertTrue(inputBox.isDisplayed());
        // 声明action对象
        Actions builder = new Actions(driver);
        // 使用doubleClick方法在输入框元素中进行鼠标的双击操作
        builder.doubleClick(inputBox).build().perform();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testDoubleClick()");
        log.info("Selenium使用双击的方法是：new Actions(driver).doubleClick(WebElement).build().perform()");
    }

}
