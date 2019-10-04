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
public class _27GetWebElementAttributeTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "查看页面元素的属性")
    public void getWebElementAttribute() throws Exception {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        String inputString = "测试工程师指定的输入内容";
        // 使用ID定位方式找到页面搜索内容输入框
        WebElement input = driver.findElement(By.id("query"));
        // 将指定变量中的内容输入到文本框中
        input.sendKeys(inputString);
        Thread.sleep(1000);
        // 调用getAttribute方法，获取页面搜索框的value属性值（即搜索输入框的文字内容）
        String inputText = input.getAttribute("value");
        log.info("搜索输入框文本内容是-----------{}", inputText);
        Assert.assertEquals(inputText, "测试工程师指定的输入内容");
        Thread.sleep(1000);
        log.info("测试工程师指定的输入内容----------测试案例执行成功！");
    }

}
