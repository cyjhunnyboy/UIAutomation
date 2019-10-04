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
public class ByTagNameTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/linkText.html";

    @Test(description = "使用标签名称定位元素", groups = {"元素定位方式"})
    public void testByTagName() throws Exception {
        log.info("使用标签名称定位元素：driver.findElement(By.tagName('a'))");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 使用标签名称定位元素
        // By.tagName("a")表示查找页面上的链接，因为被测试网页中有多个链接，
        // 所有只有第一个被匹配的链接对象会赋值给link变量
        WebElement link = driver.findElement(By.tagName("a"));
        // List<WebElement> links = driver.findElements(By.tagName("a"));
        Assert.assertTrue(link.isDisplayed());
        link.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testByTagName"));
    }

}
