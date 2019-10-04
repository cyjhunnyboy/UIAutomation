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
public class _20IsElementTextPresentTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/text.html";

    @Test(description = "检查页面元素的文本内容是否出现")
    public void testIsElementTextPresent() {
        driver.navigate().to(baseUrl);
        // 使用xpath找到第一个p元素
        WebElement text = driver.findElement(By.xpath("//p[1]"));
        // 获取p元素标签的文本内容
        String contentText = text.getText();
        // 判断页面p标签文字内容是否和“《关荣之路》这个电影真的很棒！”完全匹配
        Assert.assertEquals(contentText, "《光荣之路》这个电影真的很棒！");
        // 判断页面p标签文字内容是否包含“关荣之路”这几个字
        Assert.assertTrue(contentText.contains("光荣之路"));
        // 判断页面p标签文字内容的开始文字是否是“《关荣”
        Assert.assertTrue(contentText.startsWith("《光荣"));
        // 判断页面p标签文字内容的末尾文字是否是“很棒！”
        Assert.assertTrue(contentText.endsWith("很棒！"));
        log.info("执行{}测试用例成功！", "testIsElementTextPresent()");
    }

}
