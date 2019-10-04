package per.cyj.selenium.api;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
public class _19CaptureScreenInCunrrentWindowTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "将当前浏览器的窗口截屏")
    public void testCaptureScreenInCurrentWindow() {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        // 调用getScreenshotAs方法把当前浏览器打开的页面进行截屏，保存到一个File对象中
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // 把File对象转换为一个保存在E磁盘下selenium目录中名为test.png的图片文件
            FileUtils.copyFile(scrFile, new File("E:/Selenium/code/SeleniumProj/other/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
