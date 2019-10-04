package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用CSS选择器来定位Web元素的测试类
 * @since 2019-07-30
 */
@Slf4j
public class ByCssSelectorDaughterTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/css.html";

    @Test(description = "使用页面元素进行子页面元素的查找", groups = {"元素定位方式"})
    public void testByCSS10() throws Exception {
        log.info("使用页面元素进行子页面元素的查找：By.cssSelector('div#div1>input#div1input')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找第一个div标签中的的id为“div1input”的input页面元素
        // By.xpath("//div[@id='div1']/input[@id='div1input']");
        WebElement input = driver.findElement(By.cssSelector("div#div1>input#div1input"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testByCSS10"));
    }
}