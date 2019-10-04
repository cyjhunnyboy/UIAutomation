package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _40HandleIFrameTest extends BaseTest {

    private String url = "http://192.168.126.128:8080/selenium/html/frameset.html";

    @Test(description = "操作IFrame中的页面元素")
    public void testHandleIFrame() throws Exception {
        // 访问被测试网页
        driver.navigate().to(url);
        Thread.sleep(1000);
        // 找到左侧fame页面
        driver.switchTo().frame("leftframe");
        // 找到左侧fame页面中包含“iframe”关键字的页面元素
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        // 进入iframe页面
        driver.switchTo().frame(iframe);
        // 在iframe页面中查找“p”标签页面元素
        WebElement pElement = driver.findElement(By.tagName("p"));
        log.info("左侧frame中iframe中页面元素P的文本内容是----------------{}", pElement.getText());
        // 断言iframe中的文字内容是否和“这是iframe页面上的文字”一致
        Assert.assertEquals(pElement.getText(), "这是iframe页面上的文字");
        // 转让操作区域，进入frameset的页面区域，为进入其他frame页面区域做准备
        driver.switchTo().defaultContent();
        // 找到中间frame页面
        driver.switchTo().frame("middleframe");
        // 找到中间frame中的p标签元素
        WebElement middleFrameText = driver.findElement(By.xpath("//p"));
        log.info("中间frame中页面元素P中的文本内容是-----------------{}", middleFrameText.getText());
        // 断言中间frame中的文字内容是否和“这是中间frame页面上的文字”一致
        Assert.assertEquals(middleFrameText.getText(), "这是中间frame页面上的文字");
    }
}
