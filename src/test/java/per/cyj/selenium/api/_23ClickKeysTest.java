package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _23ClickKeysTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "模拟键盘的操作")
    public void testClickKeys() throws Exception {
        // 打开sogou首页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL); // 按下Ctrl键
        action.keyDown(Keys.SHIFT); // 按下Shift键
        action.keyDown(Keys.ALT); // 按下Alt键
        action.keyUp(Keys.CONTROL); // 释放Ctrl键
        action.keyUp(Keys.SHIFT); // 释放Shift键
        action.keyUp(Keys.ALT); // 释放Alt键
        // 点击搜索输入框获取焦点
        driver.findElement(By.id("query")).click();
        // 模拟键盘在搜索输入框中输入大写的字符“ABCDEFG”
        action.keyDown(Keys.SHIFT).sendKeys("abcdefg").perform();
        Thread.sleep(1000);
        log.info("用例{}执行成功！", "testClickKeys()");
    }

}
