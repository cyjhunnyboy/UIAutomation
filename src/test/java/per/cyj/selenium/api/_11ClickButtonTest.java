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
public class _11ClickButtonTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/click.html";

    @Test(description = "单击按钮")
    public void testClickButton() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        WebElement click = driver.findElement(By.id("button"));
        Assert.assertTrue(click.isDisplayed());
        /*
        // 单击方法的另一种实现方式
        Actions actions = new Actions(driver);
        actions.click(click).build().perform();
         */
        click.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testClickButton()");
    }

}
