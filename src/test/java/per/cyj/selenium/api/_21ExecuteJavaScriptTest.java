package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _21ExecuteJavaScriptTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "执行JavaScript脚本")
    public void testExecuteJavaScript() throws Exception {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 声明一个JavaScript执行器对象
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 调用执行器对象的executeScript方法执行JavaScript脚本return document.title
        // return document.title是JavaScript脚本代码，表示返回当前浏览器窗口的title值
        String title = (String) js.executeScript("return document.title");
        // 断言JavaScript代码实际获得的浏览器Title值是否符合期望文字
        Assert.assertEquals(title, "搜狗搜索引擎 - 上网从搜狗开始");
        Thread.sleep(1000);
        log.info("执行测试用例{}成功！", "testExecuteJavaScript()");
    }

}
