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
public class _04FreshCurrentPageTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "刷新当前页面")
    public void testFreshCurrentPage() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        driver.navigate().refresh(); // 刷新当前页面
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testFreshCurrentPage()");
    }

}
