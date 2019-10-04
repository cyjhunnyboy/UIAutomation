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
public class _06GetTitleTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "获取页面的title属性")
    public void testGetTitle() throws Exception {
        driver.navigate().to(baseUrl);
        // 调用driver的getTitle方法获取页面Title属性
        String title = driver.getTitle();
        log.info("访问页面的Title是：{}", title);
        Thread.sleep(1000);
        // 断言页面的Title是否是“搜狗搜索引擎 - 上网从搜狗开始”
        Assert.assertEquals(title, "搜狗搜索引擎 - 上网从搜狗开始");
    }

}
