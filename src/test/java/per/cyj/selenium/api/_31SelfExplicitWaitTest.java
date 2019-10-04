package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _31SelfExplicitWaitTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/wait.html";

    @Test(description = "自定义的显示等待")
    public void testSelfExplicitWait() {
        // 访问被测试的网页
        driver.navigate().to(baseUrl);
        try {
            // 显示等待判断是否可以从页面上获取文字输入框对象，若果可以获取，则继续执行后续的测试逻辑
            WebElement textInputBox = (new WebDriverWait(driver, 10))
                    .until((ExpectedCondition<WebElement>) driver
                            -> driver.findElement(By.xpath("//input[@id='text']")));
            // 断言获取的页面输入框中是否包含“今年夏天西瓜相当甜”这几个关键字
            Assert.assertEquals(textInputBox.getAttribute("value"), "今年夏天西瓜相当甜！");
            // 显示等待判断页面的p标签中是否包含“爱吃”两个关键字，若包含则继续执行后续的测试逻辑
            Boolean containsTextFlag = (new WebDriverWait(driver, 10))
                    .until((ExpectedCondition<Boolean>) driver
                            -> driver.findElement(By.xpath("//p")).getText().contains("爱吃"));
            // 断言显示等待的判断逻辑为True（p标签包含“爱吃”两个关键字）
            Assert.assertTrue(containsTextFlag);
            // 显示等待判断页面的文本输入框内容是否可见，若可见则继续执行后续的测试逻辑
            Boolean inputTextVisibleFlag = (new WebDriverWait(driver, 10))
                    .until((ExpectedCondition<Boolean>) driver
                            -> driver.findElement(By.xpath("//input[@id='text']")).isDisplayed());
            // 断言显示等待的判断逻辑为True（即文本输入框元素在页面上可见）
            Assert.assertTrue(inputTextVisibleFlag);
        } catch (NoSuchElementException e) {
            // 如果显示等待的条件未满足，则使用fail函数将此测试用例设定为执行失败
            // Assert.fail("页面上的输入框元素未找到");
            // e.printStackTrace();
            log.error("页面上的输入框元素未找到", e);
        }
    }

}
