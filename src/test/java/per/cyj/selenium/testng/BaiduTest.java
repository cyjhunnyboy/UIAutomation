package per.cyj.selenium.testng;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 测试百度类
 * @since 2019-08-04
 */
public class BaiduTest extends BaseTest {

    // 设定访问网站的地址
    public String baseUrl = "https://www.baidu.com/";

    @Test
    public void testBaidu() {
        // 打开百度首页
        driver.get(baseUrl + "/");
        // 在百度输入框中输入“光荣之路自动化测试，飞起来！”
        driver.findElement(By.id("kw")).sendKeys("光荣之路自动化测试，飞起来！");
        // 单击“百度一下”按钮
        driver.findElement(By.id("su")).click();

    }

}
