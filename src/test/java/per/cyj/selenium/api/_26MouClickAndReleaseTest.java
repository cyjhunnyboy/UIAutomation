package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _26MouClickAndReleaseTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/mouseclick.html";

    @Test(description = "在指定元素上进行鼠标单击左键和释放的操作")
    public void testMouseClickAndRelease() throws Exception {
        // 访问被测试网页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 查找页面上的div对象
        WebElement div = driver.findElement(By.xpath("//div[@id='div1']"));
        // 声明一个Action对象
        Actions action = new Actions(driver);
        // 调用Action对象的clickAndHold方法，在ID属性值为div1的页面元素上方单击鼠标左键并且不释放。
        // 此代码被调用后，可以看到页面上打印出来“鼠标左键被按下”
        action.clickAndHold(div).perform();
        Thread.sleep(1000);
        // 调用Action对象的release方法，在ID属性值为div1的页面元素上方释放鼠标左键，此代码被调用后，
        // 可以看到页面打印出来“已经被按下的鼠标左键被释放抬起”，还会显示“单击动作发生”，因为clickAndHold和
        // release方法连起来使用会被认为执行一次click方法
        action.release(div).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(1000);
        log.info("在指定元素上进行鼠标单击左键和释放的操作----------测试案例执行通过！");
    }
}
