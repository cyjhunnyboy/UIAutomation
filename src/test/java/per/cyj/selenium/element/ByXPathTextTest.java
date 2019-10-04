package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用XPath定位Web元素的测试类
 * @since 2019-07-30
 */
@Slf4j
public class ByXPathTextTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/xpath.html";

    @Test(description = "使用页面元素的文本来定位元素", groups = {"元素定位方式"})
    public void testXPathText() throws Exception {
        log.info("xpath使用页面元素文本定位元素：By.xpath('//a[text()='百度搜索']/preceding-sibling::input[@name='div2input']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 使用页面元素的文本来定位元素
        WebElement text = driver.findElement(
                By.xpath("//a[text()='百度搜索']/preceding-sibling::input[@name='div2input']"));
        Assert.assertTrue(text.isDisplayed());
        text.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathText"));
    }

}
