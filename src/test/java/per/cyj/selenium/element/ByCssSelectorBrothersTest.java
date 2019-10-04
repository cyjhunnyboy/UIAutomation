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
public class ByCssSelectorBrothersTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/css.html";

    @Test(description = "查找同级兄弟页面元素", groups = {"元素定位方式"})
    public void testBrothers1() throws Exception {
        log.info("查找同级兄弟页面元素：By.cssSelector('div#div1>input+a+a')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找id属性值为div1的div页面元素下，查找input页面元素后面的a同级链接元素
        // By.xpath("//div[@id='div1']/input/following-sibling::a[contains(@href,'sogou')]")
        WebElement href = driver.findElement(By.cssSelector("div#div1>input+a+a"));
        Assert.assertTrue(href.isDisplayed());
        href.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testBrothers1"));
    }

    @Test(description = "查找同级兄弟页面元素", groups = {"元素定位方式"})
    public void testBrothers2() throws Exception {
        log.info("查找同级兄弟页面元素：By.cssSelector('div#div1>input+*+a)");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找id属性值为div1的div页面元素下，查找input页面元素和某种类型页面元素后面的a同级链接元素
        // By.xpath("//div[@id='div1']/input/following-sibling::a[contains(@href,'sogou')]")
        WebElement href = driver.findElement(By.cssSelector("div#div1>input+*+a"));
        Assert.assertTrue(href.isDisplayed());
        href.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testBrothers2"));
    }
}
