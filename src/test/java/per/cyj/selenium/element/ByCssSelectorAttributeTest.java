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
public class ByCssSelectorAttributeTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/css.html";

    @Test(description = "css选择器使用alt属性值定位img标签", groups = {"元素定位方式"})
    public void testOtherAttribute1() throws Exception {
        log.info("css选择器使用alt属性值定位img标签: By.cssSelector('img[alt='div1-img1']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找div标签中的第一张图片
        // By.xpath("//img[@alt='div1-img1']");
        WebElement click = driver.findElement(By.cssSelector("img[alt='div1-img1']"));
        Assert.assertTrue(click.isDisplayed());
        click.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testOtherAttribute1"));
    }

    @Test(description = "css选择器使用name属性值定位img标签", groups = {"元素定位方式"})
    public void testOtherAttribute2() throws Exception {
        log.info("css选择器使用name属性值定位img标签: By.cssSelector('input[name='div2input']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找div标签中name为“div2input”的input页面元素
        // By.xpath("//input[@name='div2input']");
        WebElement input = driver.findElement(By.cssSelector("input[name='div2input']"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testOtherAttribute2"));
    }

    @Test(description = "css选择器使用id和class属性值定位input标签", groups = {"元素定位方式"})
    public void testOtherAttribute3() throws Exception {
        log.info("css选择器使用id和class属性值定位input标签: By.cssSelector('input[id='div1input'][class='spread']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找div标签中的第一个input元素
        // By.xpath("//input[@id='div1input'][@class='spread']");
        WebElement click = driver.findElement(By.cssSelector("input[id='div1input'][class='spread']"));
        Assert.assertTrue(click.isDisplayed());
        click.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testOtherAttribute3"));
    }

    @Test(description = "css选择器使用href属性值的一部分关键字定位a标签", groups = {"元素定位方式"})
    public void testOtherAttribute4() throws Exception {
        log.info("css选择器使用href属性值的一部分关键字定位a标签: By.cssSelector('a[href^='https//www.tao']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找淘宝网的链接
        // 表示匹配链接地址开头包含“https://www.tao”关键字的链接
        // By.xpath("//a[starts-with(@href,'https://www.tao')]");
        WebElement href = driver.findElement(By.cssSelector("a[href^='https://www.tao']"));
        Assert.assertTrue(href.isDisplayed());
        href.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testOtherAttribute4"));
    }

    @Test(description = "css选择器使用href属性值的一部分关键字定位a标签", groups = {"元素定位方式"})
    public void testOtherAttribute5() throws Exception {
        log.info("css选择器使用href属性值的一部分关键字定位a标签: By.cssSelector('a[href$='qq.com']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找腾讯新闻网的链接
        // 表示匹配链接地址末尾包含“qq.com”关键字的链接
        // By.xpath("//a[contains(@href,'qq.com')]");
        WebElement href = driver.findElement(By.cssSelector("a[href$='qq.com']"));
        Assert.assertTrue(href.isDisplayed());
        href.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testOtherAttribute5"));
    }

    @Test(description = "css选择器使用href属性值的一部分关键字定位a标签", groups = {"元素定位方式"})
    public void testOtherAttribute6() throws Exception {
        log.info("css选择器使用href属性值的一部分关键字定位a标签: By.cssSelect('a[href*='sogou']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 被测试网页中，查找搜狗网的链接
        // 表示匹配链接地址包含“sogou”关键字的链接
        // By.xpath("//a[contains(@href,'sogou')]");
        WebElement href = driver.findElement(By.cssSelector("a[href*='sogou']"));
        Assert.assertTrue(href.isDisplayed());
        href.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testOtherAttribute6"));
    }

}
