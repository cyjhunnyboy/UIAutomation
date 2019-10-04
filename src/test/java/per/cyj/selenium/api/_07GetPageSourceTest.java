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
public class _07GetPageSourceTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "获取页面的源代码")
    public void testGetPageSource() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 调用driver的getPageSource方法获取页面的源代码
        String pageSource = driver.getPageSource();
        log.info("页面的源代码是：{}", pageSource);
        // 断言页面的源代码中是否包含“购物”两个关键字，以此判断页面内容是否正确
        Assert.assertTrue(pageSource.contains("购物"));
    }

}
