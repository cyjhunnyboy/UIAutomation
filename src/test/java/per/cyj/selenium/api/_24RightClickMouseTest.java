package per.cyj.selenium.api;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
public class _24RightClickMouseTest extends BaseTest {

    public String baseUrl = "https://www.sogou.com/";

    @Test(description = "模拟鼠标右键事件")
    public void testRightClickMouse() throws Exception {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 查找ID为query的输入框页面元素
        WebElement element = driver.findElement(By.id("query"));
        // 声明一个Action对象
        Actions action = new Actions(driver);
        // 调用Action对象的contextClick方法，在id为query的搜索输入框上方单击鼠标右键
        action.contextClick(element).perform();
        Thread.sleep(1000);
    }

}
