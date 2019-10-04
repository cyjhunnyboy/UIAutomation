package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;
import per.cyj.selenium.util.JsUtil;

/**
 * @author chenyongjun
 * @apiNote 这是一个使用JQuery来进行定位Web元素的测试类
 * @since 2019-07-30
 */
@Slf4j
public class ByExecuteJQueryTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/jquery.html";

    @Test(description = "查找搜狗首页页面中所有链接元素", groups = {"元素定位方式"})
    public void testJQuery1() throws Exception{
        log.info("查找搜狗首页页面中所有链接元素: JsUtil.executeScript(driver, 'return jQuery.find('a')')");
        driver.get(BASE_URL);
        // 在JavascriptExecutor对象的executeScript函数中执行JavaScript语句，return jQuery.find('a')
        // 表示调用jQuery的find方法查找页面中所有a标签的页面元素，返回的结果存储到一个list对象中
        List<WebElement> elements = JsUtil.executeScript(driver, "return jQuery.find('a')");
        // 断言list对象elements里面包含的链接对象是否与预期结果一致，若一致则断言成功，
        // 测试用例执行成功，否则失败，测试用例执行失败
        Assert.assertEquals(elements.size(), 29);
        // 遍历list对象，输入所有链接的文本
        for (WebElement element : elements) {
            System.out.println(element.getText() + ", ");
        }
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testJQuery1"));
    }
}
