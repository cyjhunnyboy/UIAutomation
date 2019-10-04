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
public class ByCssSelectorPseudoTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/css.html";

    @Test(description = "使用伪类定位元素", groups = {"元素定位方式"})
    public void testPseudoFirst() throws Exception {
        log.info("使用伪类定位元素：By.cssSelector('div#div1 :first-child')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找第一个div标签中的第一个input元素
        // By.xpath("//div[@id='div1']/child::input[@id='div1input']")
        WebElement input = driver.findElement(By.cssSelector("div#div1 :first-child"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功", this.getClass().getDeclaredMethod("testPseudoFirst"));
    }

    @Test(description = "使用伪类定位元素", groups = {"元素定位方式"})
    public void testPseudoNth() throws Exception {
        log.info("使用伪类定位元素: By.cssSelector('div#div1 :nth-child(2)')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找第一个div标签中的第二个页面元素，即淘宝网链接页面元素
        // By.xpath("//div[@id='div1']/child::a[text()='淘宝网']")
        WebElement href = driver.findElement(By.cssSelector("div#div1 :nth-child(2)"));
        Assert.assertTrue(href.isDisplayed());
        href.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功", this.getClass().getDeclaredMethod("testPseudoNth"));
    }

    @Test(description = "使用伪类定位元素", groups = {"元素定位方式"})
    public void testPseudoLast() throws Exception {
        log.info("使用伪类定位元素: By.cssSelector('div#div1 :last-child')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找第一个div标签中的最后一个页面元素，即查询页面元素
        WebElement btn = driver.findElement(By.cssSelector("div#div1 :last-child"));
        Assert.assertTrue(btn.isDisplayed());
        btn.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功", this.getClass().getDeclaredMethod("testPseudoLast"));
    }

    @Test(description = "使用伪类定位元素", groups = {"元素定位方式"})
    public void testPseudoFocus() throws Exception {
        log.info("使用伪类定位元素: By.cssSelector('div#div1>input:focus')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找第一个div标签中当前获取焦点的input页面元素
        // By.xpath(//input[@id='div1input'])
        WebElement input = driver.findElement(By.cssSelector("div#div1>input:focus"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功", this.getClass().getDeclaredMethod("testPseudoFocus"));
    }

    @Test(description = "使用伪类定位元素", groups = {"元素定位方式"})
    public void testPseudoEnabled() throws Exception {
        log.info("使用伪类定位元素: By.cssSelector('div#div1>input:enabled')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找第一个div标签中可操作的input页面元素
        // By.xpath(//input[@id='div1input'])
        WebElement input = driver.findElement(By.cssSelector("div#div1>input:enabled"));
        Assert.assertTrue(input.isDisplayed());
        input.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功", this.getClass().getDeclaredMethod("testPseudoEnabled"));
    }

    @Test(description = "使用伪类定位元素", groups = {"元素定位方式"})
    public void testPseudoChecked() throws Exception {
        log.info("使用伪类定位元素: By.cssSelector('input:checked')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 在被测试网页中，查找被勾选状态的checkbox页面元素
        // By.xpath(//input[@type='checkbox'])
        WebElement checkbox = driver.findElement(By.cssSelector("input:checked"));
        Assert.assertTrue(checkbox.isDisplayed());
        checkbox.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功", this.getClass().getDeclaredMethod("testPseudoChecked"));
    }
}
