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
public class _22DragPageElementTest extends BaseTest {

    private String baseUrl = "http://jqueryui.com/resources/demos/draggable/scroll.html";

    @Test(description = "拖曳页面元素")
    public void testDragPageElement() throws Exception {
        // 访问被测试网页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 找到页面上第一个能被拖曳的方框页面对象
        WebElement draggable = driver.findElement(By.id("draggable"));
        // 向下拖动50个像素，共拖动5次
        for (int i = 0; i < 5; i++) {
            // 50表示元素的纵坐标向下移动50个像素，0表示元素的横坐标不变
            new Actions(driver).dragAndDropBy(draggable, 0, 50).build().perform();
        }
        // 向右拖动50个像素，共拖动5次
        for (int i = 0; i < 5; i++) {
            // 50表示元素的横坐标向右移动50个像素，0表示元素的纵坐标不变
            new Actions(driver).dragAndDropBy(draggable, 50, 0).build().perform();
        }
        Thread.sleep(1000);
        // 找到页面上第二个能被拖曳的方框页面对象
        WebElement draggable2 = driver.findElement(By.id("draggable2"));
        // 向下拖动30个像素，向右拖动30个像素，共拖动5次
        for (int i = 0; i < 5; i++) {
            // 30表示元素的纵坐标向下移动30个像素，0表示元素的横坐标不变
            new Actions(driver).dragAndDropBy(draggable2, 0, 30).build().perform();
            // 30表示元素的横坐标向右移动30个像素，0表示元素的纵坐标不变
            new Actions(driver).dragAndDropBy(draggable2, 30, 0).build().perform();
        }
        Thread.sleep(1000);
        log.info("执行测试用例{}成功！", "testDragPageElement()");
        log.info("拖拽页面元素的方法：{}", "new Actions(driver).dragAndDropBy(WebElement, x, y).build().perform()");
    }
}
