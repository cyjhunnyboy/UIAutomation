package per.cyj.selenium.senior;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _20Html5StorageTest extends BaseTest {

    // 定义测试的localStorage的网址
    String localStorageUrl = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_webstorage_local";
    // 定义测试的sessionStorage的网址
    String sessionStorageUrl = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_webstorage_session";
    private JavascriptExecutor js;

    @Test(description = "操作HTML5的存储对象 能够读取HTML5的localStorage和sessionStorage的内容，并删除存储的内容")
    public void testHtml5LocalStorage() throws Exception {
        driver.navigate().to(localStorageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 声明一个 JavascriptExecutor 对象
        js = (JavascriptExecutor) driver;
        // js对象调用JavaScript语句"return localStorage.lastname;"
        // 存储获取在localStorage中的"lastname"的存储值
        String lastname = (String) js.executeScript("return localStorage.lastname");
        // 断言获取的存储值是否为“Gates”
        Assert.assertEquals(lastname, "Gates");
        // js对象调用JavaScript语句"localStorage.clear()"，清除所有存储在localStorage的变量值
        js.executeScript("localStorage.clear()");
        Thread.sleep(3000);
    }

    @Test(description = "操作HTML5的存储对象 能够读取HTML5的localStorage和sessionStorage的内容，并删除存储的内容")
    public void testHtml5SessionStorage() throws Exception {
        driver.navigate().to(sessionStorageUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 声明一个 JavascriptExecutor 对象
        js = (JavascriptExecutor) driver;
        // js对象调用JavaScript语句"return sessionStorage.lastname;"
        // 存储获取在sessionStorage中的"lastname"的存储值
        String lastname = (String) js.executeScript("return sessionStorage.lastname");
        // 断言获取的存储值是否为“Gates”
        Assert.assertEquals(lastname, "Gates");
        // 清除所有存储在sessionStorage的"lastname"项
        js.executeScript("sessionStorage.removeItem('lastname')");
        // 清除所有存储在sessionStorage的存储值
        js.executeScript("sessionStorage.clear()");
        Thread.sleep(3000);
    }

}
