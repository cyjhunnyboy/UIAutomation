package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _25RoverOnElementTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/rover.html";

    @Test(description = "在指定元素上方进行鼠标悬浮")
    public void testRoverOnElement() throws Exception {
        // 访问被测试网页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 查找到页面上的链接对象
        WebElement link1 = driver.findElement(By.xpath("//a[@id='link1']"));
        WebElement link2 = driver.findElement(By.xpath("//a[@id='link2']"));
        // 声明一个Action对象
        Actions action = new Actions(driver);
        // 调用action的moveToElement方法，将鼠标移动到ID属性值为link1的链接上方
        // 此代码被调用后，可以看到页面显示蓝色的长方形
        action.moveToElement(link1).perform();
        Thread.sleep(1000);
        // 调用action的moveToElement方法，将鼠标移动到ID属性值为link2的链接上方 页面显示的蓝色长方形会消失
        action.moveToElement(link2).perform();
        Thread.sleep(1000);
        log.info("在指定元素上方进行鼠标悬浮-----------测试案例执行通过！");
    }
}
