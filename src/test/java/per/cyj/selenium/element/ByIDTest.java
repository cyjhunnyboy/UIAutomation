package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote web元素定位类
 * @since 2019-07-29
 */
@Slf4j
public class ByIDTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/id.html";

    @Test(description = "使用ID定位元素", groups = {"元素定位方式"})
    public void testById() throws Exception {
        log.info("使用IDd定位元素：driver.findElement(By.id('username'))");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 定位元素：使用ID定位
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submit = driver.findElement(By.id("submit"));
        Assert.assertTrue(userName.isDisplayed());
        userName.sendKeys("abc");
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys("123");
        Assert.assertTrue(submit.isDisplayed());
        submit.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testById"));
    }
}
