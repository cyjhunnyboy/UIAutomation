package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-04
 */
@Slf4j
public class _03VisitNextURLTest extends BaseTest {

    private String sogou = "https://www.sogou.com/";
    private String baidu = "https://www.baidu.com/";

    @Test(description = "从上次访问网页前进到下一个网页（模拟单击浏览器的前进功能）")
    public void testVisitNextURL() throws Exception {
        driver.navigate().to(sogou); // 先方位sogou首页
        Thread.sleep(1000);
        driver.navigate().to(baidu); // 再跳转访问百度首页
        Thread.sleep(1000);
        driver.navigate().back(); // 返回到上一次访问的sogou首页页面
        Thread.sleep(1000);
        driver.navigate().forward(); // 从sogou首页页面跳转到百度首页
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testVisitNextURL()");
    }

}
