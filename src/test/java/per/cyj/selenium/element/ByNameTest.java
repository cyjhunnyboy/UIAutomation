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
 * @since 2019-07-30
 */
@Slf4j
public class ByNameTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/name.html";

    @Test(description = "使用name定位元素", groups = {"元素定位方式"})
    public void testByName() throws Exception {
        log.info("使用name定位页面元素：driver.findElement(By.name('username'))");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 定位元素：使用name定位
        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submit = driver.findElement(By.name("submit"));
        Assert.assertTrue(userName.isDisplayed());
        userName.sendKeys("abc");
        Assert.assertTrue(password.isDisplayed());
        password.sendKeys("123");
        Assert.assertTrue(submit.isDisplayed());
        submit.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testByName"));
    }

}
