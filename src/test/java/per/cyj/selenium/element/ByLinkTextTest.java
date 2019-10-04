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
public class ByLinkTextTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/linkText.html";

    @Test(description = "使用链接的全部文字定位元素", groups = {"元素定位方式"})
    public void testByLinkText() throws Exception {
        log.info("使用链接的全部文字定位元素：driver.findElement(By.linkText('sogou搜索'))");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 使用链接的全部文字定位元素
        WebElement linkText = driver.findElement(By.linkText("sogou搜索"));
        Assert.assertTrue(linkText.isDisplayed());
        linkText.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testByLinkText"));
    }

}
