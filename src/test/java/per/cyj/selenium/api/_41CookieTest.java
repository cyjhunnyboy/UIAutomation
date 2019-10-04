package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.Cookie;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _41CookieTest extends BaseTest {

    private String url = "http://ww.sogou.com/";

    @Test(description = "能够遍历输出所有Cookie的key和value；能够删除指定的Cookie对象，能够删除所有的Cookie对象")
    public void testCookie() throws Exception {
        // 访问sogou首页
        driver.navigate().to(url);
        Thread.sleep(1000);
        // 得到当前页面下所有的Cookies，并且输出它们的所在域、name、value、有效日期和路径
        Set<Cookie> cookies = driver.manage().getCookies();
        Cookie newCookie = new Cookie("cookieName", "cookieValue");
        log.info("Cookie输出格式为：Domain->name->value->expiry->path");
        for (Cookie cookie : cookies) {
            log.info(String.format("%s->%s->%s->%s->%s", cookie.getDomain(), cookie.getName(),
                    cookie.getValue(), cookie.getExpiry(), cookie.getPath()));
        }
        // 通过Cookie的name属性
        driver.manage().deleteCookieNamed("cookieName");
        // 通过Cookie对象
        driver.manage().deleteCookie(newCookie);
        // 全部删除
        driver.manage().deleteAllCookies();
        Thread.sleep(1000);
    }
}
