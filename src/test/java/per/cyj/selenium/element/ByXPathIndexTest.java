package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;
import java.util.List;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用XPath定位Web元素的测试类
 * @since 2019-07-30
 */
@Slf4j
public class ByXPathIndexTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/xpath.html";

    @Test(description = "xpath使用索引号来定位页面元素", groups = {"元素定位方式"})
    public void testXPathIndex() throws Exception {
        log.info("xpath使用索引号定位元素：By.xpath('//input[2]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 使用索引号进行定位
        WebElement input = driver.findElement(By.xpath("//input[2]"));
        Assert.assertTrue(input.isDisplayed());
        input.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathIndex"));
    }

    @Test(description = "xpath使用索引号来定位多个页面元素", groups = {"元素定位方式"})
    public void testXPathIndexs() throws Exception {
        log.info("xpath使用索引号定位元素：By.xpath('//input[1]')");
        driver.get(BASE_URL);
        Thread.sleep(2000);
        // 使用索引号定位多个元素
        List<WebElement> inputs = driver.findElements(By.xpath("//input[1]"));
        for (WebElement input : inputs) {
            if (input.isDisplayed()) {
                input.clear();
                input.sendKeys("Selenium自动化测试");
                Thread.sleep(1000);
            }
        }
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathIndexs"));
    }

}
