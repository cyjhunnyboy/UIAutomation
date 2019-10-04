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
public class ByXPathAbsoluteTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/xpath.html";

    @Test(description = "xpath使用绝对路径来定位元素", groups = {"元素定位方式"})
    public void testXPathAbsolute() throws Exception {
        log.info("xpath使用绝对路径来定位元素：By.xpath('html/body/div/input[@value='查找']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 使用绝对路径进行定位
        WebElement button = driver.findElement(By.xpath("html/body/div/input[@value='查询']"));
        Assert.assertTrue(button.isDisplayed());
        Assert.assertEquals(button.getAttribute("value"), "查询");
        button.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAbsolute"));
    }

}
