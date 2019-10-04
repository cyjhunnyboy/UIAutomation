package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-10
 */
public class _03OperateElementAttributeTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/attribute.html";

    @Test(description = "设置一个页面对象的属性值")
    public void testElementAttribute() throws Exception {
        // 查找被测网页上的文本框元素
        WebElement textInputBox = driver.findElement(By.id("text"));
        Thread.sleep(2000);
        // 调用operateAttribute方法修改文本框的value属性值，修改文文本框中显示的文字
        setAttribute(driver, textInputBox, "value", "文本框中的文字已经被修改了！");
        Thread.sleep(2000);
        // 调用operateAttribute方法修改文本框的size属性值，改变文本框的长度
        setAttribute(driver, textInputBox, "size", "50");
        Thread.sleep(2000);
        // 调用removeAttribute方法删除文本框中的size属性值
        removeAttribute(driver, textInputBox, "size");
        Thread.sleep(2000);
    }

    /**
     * 增加页面元素和修改页面元素的方法
     *
     * @param dirver        浏览器驱动
     * @param element       页面元素
     * @param attributeName 页面元素属性
     * @param value         输入的值
     */
    private void setAttribute(WebDriver dirver, WebElement element, String attributeName, String value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // 调用JavaScript代码修改页面元素的属性值，arguments[0]~[2]分别用后面的element,
        // attributeName和value参数进行替换，并执行
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
                element, attributeName, value);
    }

    /**
     * 删除页面元素的封装方法
     *
     * @param driver        浏览器驱动
     * @param element       页面元素
     * @param attributeName 页面元素属性名称
     */
    private void removeAttribute(WebDriver driver, WebElement element, String attributeName) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // 调用JavaScript代码删除页面元素的属性，arguments[0]~[1]分别用后面的element,
        // attributeName参数进行替换，并执行
        jsExecutor.executeScript("arguments[0].removeAttribute(arguments[1], arguments[2])", element, attributeName);
    }

}
