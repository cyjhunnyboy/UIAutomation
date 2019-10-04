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
public class ByClassNameTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/class.html";

    @Test(description = "使用Class名称定位元素", groups = {"元素定位方式"})
    public void testByClassName() throws Exception {
        log.info("使用className定位元素: driver.findElement(By.className('spread')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 使用Class名称定位元素
        // By.className("spread")表示使用class属性的名称来查找页面元素
        WebElement input = driver.findElement(By.className("spread"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("关荣之路自动化测试教程，让你飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testByClassName"));
    }
}
