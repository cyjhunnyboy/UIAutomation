package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _32IsElementPresentTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "判断页面元素是否存在")
    public void testIsElementPresent() throws Exception {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 调用isElementPresent方法查找ID为query的页面元素对象
        if (isElementPresent(By.xpath("//input[@id='query']"))) {
            // 若果成功定位到页面元素，则把页面元素存储到searchInputBox变量中
            WebElement searchInputBox = driver.findElement(By.xpath("//input[@id='query']"));
            // 判断页面元素是否处于可用状态
            if (searchInputBox.isEnabled()) {
                searchInputBox.sendKeys("光荣之路自动化测试，飞起来！");
            }
        } else {
            // 如果页面上的搜索输入框未找到，则会将此测试用例设置为失败，并打印失败原因
            log.error("页面上的输入框元素未找到！");
        }
        // 调用isElementPresent方法查找ID为stb的页面元素对象
        if (isElementPresent(By.xpath("//input[@id='stb']"))) {
            // 若果成功定位到页面元素，则把页面元素存储到searchButton变量中
            WebElement searchButton = driver.findElement(By.xpath("//input[@id='stb']"));
            // 判断页面元素是否处于可用状态
            if (searchButton.isEnabled()) {
                Thread.sleep(1000);
                searchButton.click();
            }
        } else {
            // 如果页面上的搜索输入框未找到，则会将此测试用例设置为失败，并打印失败原因
            log.error("页面上的输入框元素未找到！");
        }
    }

    /**
     * 判断页面元素是否存在，存在返回true，否则返回false
     *
     * @param by 定位器
     * @return boolean
     */
    private Boolean isElementPresent(By by) {
        try {
            // 如果传入的参数by能找到页面元素则返回true
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            log.error("找不到该页面元素----------", e);
            // 没有找到页面元素，返回false
            return false;
        }
    }
}
