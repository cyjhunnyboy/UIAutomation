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
public class _28GetWebElementCssValueTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "获取页面元素的css属性值")
    public void getWebElementCssValue() throws Exception {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 使用ID定位方式查找页面的搜索输入框
        WebElement input = driver.findElement(By.id("query"));
        // 调用getCssValue方法，获取搜索输入框的宽度
        String inputWidth = input.getCssValue("width");
        // 断言页面的搜索输入框宽度是否是535px
        Assert.assertEquals(inputWidth, "499px");
        log.info("获取页面元素的css属性值--------------案例执行测试通过！");
    }

}
