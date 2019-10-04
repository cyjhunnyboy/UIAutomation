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
public class ByCssSelectorIDTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/css.html";

    @Test(description = "css选择器使用ID属性定位元素", groups = {"元素定位方式"})
    public void testID() throws Exception {
        log.info("css选择器使用ID属性定位元素: By.cssSelector('input#div1input')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试的网页中，查找第一个div标签中ID为“div1input”的input页面元素
        // By.id("div1input");
        WebElement id = driver.findElement(By.cssSelector("input#div1input"));
        Assert.assertTrue(id.isDisplayed());
        id.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testID"));
    }
}