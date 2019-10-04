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
public class _38HandleFrameTest extends BaseTest {

    private String url = "http://192.168.126.128:8080/selenium/html/frameset.html";

    @Test(description = "操作Frame中的页面元素")
    public void testHandleFrame() throws Exception {
        // 访问被测试网页
        driver.navigate().to(url);
        Thread.sleep(1000);
        // 找到左侧fame页面
        driver.switchTo().frame("leftframe");
        // 找到左侧fame中的p标签元素
        WebElement lefFrameText = driver.findElement(By.tagName("p"));
        log.info("左侧frame中文字内容是---------------{}", lefFrameText.getText());
        // 断言左侧frame中的文字内容是否和“这是左侧frame页面上的文字”一致
        Assert.assertEquals(lefFrameText.getText(), "这是左侧frame页面上的文字");
        // 从左侧frame中返回到frameset页面，若不调用此方法，无法从左侧frame页面中进入其他frame页面
        driver.switchTo().defaultContent();
        // 找到中间frame页面
        driver.switchTo().frame("middleframe");
        // 找到中间frame中的p标签元素
        WebElement middleFrameText = driver.findElement(By.xpath("//p"));
        log.info("中间rame中文字内容是---------------{}", middleFrameText.getText());
        // 断言中间frame中的文字内容是否和“这是中间frame页面上的文字”一致
        Assert.assertEquals(middleFrameText.getText(), "这是中间frame页面上的文字");
        // 从中间frame页返回frameset页面
        driver.switchTo().defaultContent();
        // 找到右侧frame页面
        driver.switchTo().frame("rightframe");
        // 找到右侧frame中的p标签元素
        WebElement rightFrameText = driver.findElement(By.xpath("//p[contains(text(),'右侧')]"));
        log.info("右侧frame中文字内容是---------------{}", rightFrameText.getText());
        // 断言右侧frame页面中的文字内容是否和“这是右侧frame页面上的文字”一致
        Assert.assertEquals(rightFrameText.getText(), "这是右侧frame页面上的文字");
        // 从右侧frame页返回frameset页面
        driver.switchTo().defaultContent();
        // 通过索引号来找到中间frame页面
        driver.switchTo().frame(1);
        // 找到中间frame页中p标签元素
        WebElement middleText = driver.findElement(By.cssSelector("p"));
        // 断言中间frame中的文字内容是否和“这是中间frame页面上的文字”一致
        Assert.assertEquals(middleText.getText(), "这是中间frame页面上的文字");
    }
}
