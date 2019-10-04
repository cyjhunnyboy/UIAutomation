package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-05
 */
@Slf4j
public class _08GetCurrentPageUrlTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "获取当前页面的URL地址")
    public void testGetCurrentPageUrl() throws Exception {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 调用driver的getCurrentUrl方法获取当前页面的url地址
        String currentPageUrl = driver.getCurrentUrl();
        // 打印当前页面的url地址
        log.info("获取当前页面的URL地址是：{}", currentPageUrl);
        // 断言当前页面的url地址是否为“https://www.sogou.com/”
        Assert.assertEquals(currentPageUrl, "https://www.sogou.com/");
    }

}
