package per.cyj.selenium.senior;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-10
 */
@Slf4j
public class _01JavascriptExecutorTest extends BaseTest {

    String baseUrl = "https://www.sogou.com/";

    @Test(description = "使用JavaScriptExecutor单击元素")
    public void testJavascriptExecutor() throws Exception {
        // 查找sogou首页的搜索输入框
        WebElement searchInputBox = driver.findElement(By.id("query"));
        // 查找sogou首页的搜索按钮
        WebElement searchButton = driver.findElement(By.id("stb"));
        // 在sogou首页的搜索输入框中，输入关键字“使用JavaScript语句进行页面元素的单击”
        searchInputBox.sendKeys("使用JavaScript语句进行页面元素的单击");
        // 调用封装好的JavaScriptClick方法单击sogou首页的搜索按钮
        JavaScriptClick(searchButton);
        Thread.sleep(3000);
    }

    /**
     * 定义JavaScriptClick方法（通过JavaScript语句进行页面元素的单击操作）
     *
     * @param element 页面元素
     */
    private void JavaScriptClick(WebElement element) {
        try {
            // 判断element元素是否处于可点击状态，以及是否显示在页面上
            if (element.isEnabled() && element.isDisplayed()) {
                log.info("使用JavaScript进行页面元素的单击");
                // 执行JavaScript语句的arguments[0].click（）
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            } else {
                log.info("页面上的{}元素无法进行单击操作", element);
            }
            // 当出现异常的时候，catch语句被执行，打印相关的异常信息和出错的堆栈信息
        } catch (StaleElementReferenceException e) {
            log.info("页面的元素没有附加在网页中: {}", e);
        } catch (NoSuchElementException e) {
            log.info("在页面中没有找到要操作的页面元素: {}", e);
        } catch (Exception e) {
            log.info("无法完成单击操作: {}", e);
        }
    }

}
