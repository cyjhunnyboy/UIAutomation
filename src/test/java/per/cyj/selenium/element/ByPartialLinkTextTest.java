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
public class ByPartialLinkTextTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/linkText.html";

    @Test(description = "使用部分链接文字定位元素", groups = {"元素定位方式"})
    public void testByPartialLinkText() throws Exception {
        log.info("使用部分链接文字定位元素：driver.findElement(By.partialLinkText('sog'))");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 使用部分链接文字定位元素
        WebElement link = driver.findElement(By.partialLinkText("sog"));
        Assert.assertTrue(link.isDisplayed());
        link.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testByPartialLinkText"));
    }

}
