package per.cyj.selenium.util;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

/**
 * @author chenyongjun
 * @apiNote JavaScript工具类
 * @since 2019-08-10
 */
@UtilityClass
public class JsUtil {

    private JavascriptExecutor js;

    /**
     * 执行JS脚本，返回需要查找的页面元素
     * @param driver 浏览器驱动
     * @param script 脚本
     * @return 页面元素
     */
    @SuppressWarnings("unchecked")
    public List<WebElement> executeScript(WebDriver driver, String script) {
        List<WebElement> list = null;
        // 将driver转换为JavascriptExecutor的对象
        js = (JavascriptExecutor) driver;
        // 调用判断是否需要注入jQuery的方法
        injectJQueryIfNeeded();
        if (jQueryLoaded()) {
            try {
                list = (List<WebElement>) js.executeScript(script);
            } catch (Exception e) {
                Assert.fail("执行script失败：", e);
            }
        }
        return list;
    }

    /**
     * 判断是否需要注入jQuery,若未加载jQuery，则执行injectjQuery注入方法
     */
    private void injectJQueryIfNeeded() {
        if (!jQueryLoaded())
            injectJQuery();
    }

    /**
     * 判断是否已加载jQuery
     * @return boolean
     */
    private boolean jQueryLoaded() {
        Boolean loaded;
        try {
            loaded = (Boolean) js.executeScript("return " + "jQuery() != null");
        } catch (WebDriverException e) {
            loaded = false;
        }
        return loaded;
    }

    /**
     * 通过注入jQuery
     */
    private void injectJQuery() {
        js.executeScript(" var headID = "
                + "document.getElementsByTagName(\"head\")[0];"
                + "var newScript = document.createElement('script');"
                + "newScript.type = 'text/javascript';"
                + "newScript.src = 'https://code.jquery.com/jquery-3.4.1.min.js';"
                + "headID.appendChild(newScript);");
    }
}
