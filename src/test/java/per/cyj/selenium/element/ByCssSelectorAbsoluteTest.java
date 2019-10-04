package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用CSS选择器来定位Web元素的测试类
 * @since 2019-07-30
 */
@Slf4j
public class ByCssSelectorAbsoluteTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/css.html";

    @Test(description = "css选择器使用绝对路径定位元素", groups = {"元素定位方式"})
    public void testAbsolute() throws Exception {
        log.info("使用css选择器绝对路径定位元素:By.cssSelector('html>body>div>input[type='button']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试的网页中，查找第一个div标签中的按钮
        // By.xpath("html/body/div/input[@type='button']")
        WebElement btn = driver.findElement(By.cssSelector("html>body>div>input[type='button']"));
        Assert.assertTrue(btn.isDisplayed());
        Assert.assertEquals(btn.getAttribute("value"), "查询");
        btn.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testAbsolute"));
    }
}
