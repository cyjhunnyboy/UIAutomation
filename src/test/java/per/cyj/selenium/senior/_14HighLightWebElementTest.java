package per.cyj.selenium.senior;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _14HighLightWebElementTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "高亮显示正在被操作的页面元素")
    public void _testHighLightWebElement() throws Exception {
        // 访问“sogou”首页
        driver.navigate().to(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement searcheInputBox = driver.findElement(By.id("query"));
        WebElement searchButton = driver.findElement(By.id("stb"));
        // 调用高亮显示元素的封装方法，将输入框进行高亮显示
        highLightElement(searcheInputBox);
        // 停顿3秒后查看高亮效果
        Thread.sleep(1000);
        searcheInputBox.sendKeys("光荣之路自动化测试，飞起来！");
        Thread.sleep(1000);
        searchButton.click();
        Thread.sleep(1000);
    }

    /**
     * 封装好的高亮显示元素的函数
     *
     * @param element 页面元素
     */
    public void highLightElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // 使用 JavaScript 语句将传入参数的页面元素对象的背景色和边框颜色分别设定为黄色和红色
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "background: yesslow; border: 2px solid red");
    }

}
