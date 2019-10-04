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
public class ByXPathAttributeTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/xpath.html";

    @Test(description = "XPath：使用页面元素的属性值来定位元素", groups = {"元素定位方式"})
    public void testXPathAttribute1() throws Exception {
        log.info("xpath定位元素：By.xpath('img[@alt='div1-img1']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 目的：定位被测试网页中的第一个图片元素
        // 使用img标签的alt属性值
        WebElement img = driver.findElement(By.xpath("//img[@alt='div1-img1']"));
        Assert.assertTrue(img.isDisplayed());
        img.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAttribute1"));
    }

    @Test(description = "XPath：使用页面元素的属性值来定位元素", groups = {"元素定位方式"})
    public void testXPathAttribute2() throws Exception {
        log.info("xpath定位元素：By.xpath('//div[@name='div2']/input[@name='div2input']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 目的：定位第二个div中的第一个input输入框
        // 使用div标签的name属性值，使用input标签的name的属性值
        WebElement input = driver.findElement(By.xpath("//div[@name='div2']/input[@name='div2input']"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAttribute2"));
    }

    @Test(description = "XPath：使用页面元素的属性值来定位元素", groups = {"元素定位方式"})
    public void testXPathAttribute3() throws Exception {
        log.info("xpath定位元素：By.xpath('//div[@id='div1']/a[@href='https://www.qq.com']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 目的：定位第一个div中的第一个链接
        // 使用div标签的id属性值，使用a标签的href的属性值
        WebElement sogou = driver.findElement(By.xpath("//div[@id='div1']/a[@href='https://www.qq.com']"));
        Assert.assertTrue(sogou.isDisplayed());
        sogou.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAttribute3"));
    }

    @Test(description = "XPath：使用页面元素的属性值来定位元素", groups = {"元素定位方式"})
    public void testXPathAttribute4() throws Exception {
        log.info("xpath定位元素：By.xpath('//input[@type='button']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 目的：定位页面的查询按钮
        // 使用type属性值
        WebElement btn = driver.findElement(By.xpath("//input[@type='button']"));
        Assert.assertTrue(btn.isDisplayed());
        Assert.assertEquals(btn.getAttribute("value"), "查询");
        btn.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAttribute4"));
    }

    @Test(description = "XPath：使用模糊的属性值来定位元素", groups = {"元素定位方式"})
    public void testXPathAttribute5() throws Exception {
        log.info("xpath定位元素：By.xpath('//img[starts-with(@alt,'div1')]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 目的：定位第一个div中的图片
        // 查找图片alt属性开始位置包含“div1”关键字的页面元素
        WebElement img = driver.findElement(By.xpath("//img[starts-with(@alt, 'div1')]"));
        Assert.assertTrue(img.isDisplayed());
        img.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAttribute5"));
    }

    @Test(description = "XPath：使用模糊的属性值来定位元素", groups = {"元素定位方式"})
    public void testXPathAttribute6() throws Exception {
        log.info("xpath定位元素: By.xpath('//img[contains(@alt,'v1-im')]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 目的：定位第一个div中的图片
        // 查找图片alt属性包含“g1”关键字的页面元素
        WebElement img = driver.findElement(By.xpath("//img[contains(@alt, 'v1-im')]"));
        Assert.assertTrue(img.isDisplayed());
        img.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAttribute6"));
    }

}
