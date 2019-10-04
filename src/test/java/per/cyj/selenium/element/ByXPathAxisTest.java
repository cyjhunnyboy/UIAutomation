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
public class ByXPathAxisTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/xpath.html";

    @Test(description = "使用XPath的轴（Axis）进行元素定位", groups = {"元素定位方式"})
    public void testXPathAxis1() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//img[@alt='div2-img2']/parent::a')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // parent关键字：选取当前节点的父节点
        // 查找到alt属性值为div2-img2的图片，并基于图片的位置查找上一级的a页面元素
        WebElement parent = driver.findElement(By.xpath("//img[@alt='div2-img2']/parent::a"));
        Assert.assertTrue(parent.isDisplayed());
        parent.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis1"));
    }

    @Test(description = "使用XPath的轴（Axis）进行元素定位", groups = {"元素定位方式"})
    public void testXPathAxis2() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//div[@id='div1']/child::a/img[contains(@alt,'g1')]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // child关键字：选取当前节点的所有子元素
        // 查找id属性值为div1的div页面元素，并基于div的位置查找下层节点a的子节点img页面元素
        // By.xpath("//a[contains(@href,'sogou')]/child::img")
        WebElement child = driver.findElement(By.xpath("//div[@id='div1']/child::a/img[contains(@alt,'g1')]"));
        Assert.assertTrue(child.isDisplayed());
        child.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis2"));
    }

    @Test(description = "使用XPath的轴（Axis）进行元素定位", groups = {"元素定位方式"})
    public void testXPathAxis3() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//img[@alt='div2-img2']/ancestor::body/div/child::input[@name='div1input']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // ancestor关键字：选取当前节点的所有先辈（父、祖父等）
        // 查找alt属性值为div2-img2的图片，并基于图片位置找到它祖先body，并通过body往下查找name为div1input的input元素
        WebElement ancestor = driver
                .findElement(By.xpath("//img[@alt='div2-img2']/ancestor::body/div/child::input[@name='div1input']"));
        Assert.assertTrue(ancestor.isDisplayed());
        ancestor.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis3"));
    }

    @Test(description = "使用XPath的轴（Axis）进行元素定位", groups = {"元素定位方式"})
    public void testXPathAxis4() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//div[@name='div2']/descendant::img[starts-with(@alt,'div2')]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // descendant关键字：选取当前节点的所有后代元素（子、孙等）
        // 查找name属性值为div2的div页面元素，并基于div的位置找到它后辈节点img页面元素
        WebElement descendant = driver
                .findElement(By.xpath("//div[@name='div2']/descendant::img[starts-with(@alt,'div2')]"));
        Assert.assertTrue(descendant.isDisplayed());
        descendant.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis4"));
    }

    @Test(description = "使用XPath的轴（Axis）进行元素定位", groups = {"元素定位方式"})
    public void testXPathAxis5() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//div[@id='div1']//following::img[@alt='div2-img2']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // following关键字：选取文档中当前节点的结束标签之后的所有节点
        // 查找ID属性值为div1的div页面元素，并基于div位置找到它后面节点中的img页面元素
        /*
         * WebElement following =
         * driver.findElement(By.xpath("//div[@id='div1']//descendant::" +
         * "img[@alt='div2-img2']")); //img2非当前div1的后辈子节点，因此此语句会报错
         */
        WebElement following = driver.findElement(By.xpath("//div[@id='div1']//following::img[@alt='div2-img2']"));
        Assert.assertTrue(following.isDisplayed());
        following.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis5"));
    }

    @Test(description = "使用XPath的轴（Axis）进行元素定位", groups = {"元素定位方式"})
    public void testXPathAxis6() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//a[contains(@href,'qq')]/following-sibling::input[@value='查询']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // following-sibling关键字：选取当前节点之后的所有同级节点
        // 查找到链接地址为http://www.qq.com/的链接页面元素，并基于链接的位置找到它后续节点中的button页面元素
        WebElement folSib = driver
                .findElement(By.xpath("//a[contains(@href,'qq')]/following-sibling::input[@value='查询']"));
        Assert.assertTrue(folSib.isDisplayed());
        folSib.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis6"));
    }

    @Test(description = "使用XPath的轴（Axis）进行元素定位" , groups = {"元素定位方式"})
    public void testXPathAxis7() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//img[@alt='div1-img1']/preceding::input[@name='div1input']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // preceding关键字：选取文档中当前节点的开始标签之前的所有节点
        // 查找alt属性值为div1-img1的图片页面元素，并基于图片的位置找到它前面节点中的input页面元素
        WebElement preceding = driver
                .findElement(By.xpath("//img[@alt='div1-img1']/preceding::input[@name='div1input']"));
        Assert.assertTrue(preceding.isDisplayed());
        preceding.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis7"));
    }

    @Test(description = "使用XPath的轴（Axis）进行元素定位", groups = {"元素定位方式"})
    public void testXPathAxis8() throws Exception {
        log.info("xpath(Axis)定位元素：By.xpath('//a[contains(@href,'baidu')]/preceding-sibling::input[@name='div2input']')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // preceding-sibling关键字：选取当前节点之前的所有同级节点，同一个parent下该节点之前的节点，即“哥哥”节点（是同父的哥哥节点）
        // 查找链接地址为https://www.baidu.com的链接页面元素，并基于链接的位置找到它前面同级节点的input页面元素
        WebElement preSib = driver
                .findElement(By.xpath("//a[contains(@href,'baidu')]/preceding-sibling::input[@name='div2input']"));
        Assert.assertTrue(preSib.isDisplayed());
        preSib.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testXPathAxis8"));
    }

}
