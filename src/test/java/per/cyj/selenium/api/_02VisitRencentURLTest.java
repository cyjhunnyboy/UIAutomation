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
public class _02VisitRencentURLTest extends BaseTest {

    private String sogou = "https://www.sogou.com/";
    private String baidu = "https://www.baidu.com/";

    @Test(description = "访问上一个访问的网页（模拟单击浏览器的后腿功能）")
    public void testVisitRencentURL() throws Exception {
        driver.navigate().to(sogou); // 先访问sougou首页
        Thread.sleep(1000);
        driver.navigate().to(baidu); // 再跳转访问百度首页
        Thread.sleep(1000);
        driver.navigate().back(); // 返回上一次访问的sogou首页页面
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testVisitRencentURL()");
    }

}
