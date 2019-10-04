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
public class _01VisitURLTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "访问某网页地址")
    public void testVisitURL() throws Exception {
        // 访问sougou首页
        driver.navigate().to(baseUrl); // driver.get(baseUrl);
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testVisitURL()");
    }

}
