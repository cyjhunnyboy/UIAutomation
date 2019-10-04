package per.cyj.selenium.senior;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _19Html5CanvasTest extends BaseTest {

    private String baseUrl = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_canvas_line";

    @Test(description = "在HTML5的画布元素上进行绘画操作")
    public void testHtml5Canvas() {
        driver.navigate().to(baseUrl);
        // 声明一个 File 对象，用于保存屏幕截屏内容
        File captureScreenFile = null;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 声明一个 JavascriptExecutor 对象
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
         * 调用 JavaScriptExecutor 执行 JavaScript 语句，在画布上画一个红色矩形的图案
         * getElementById('myCanvas') 语句获取页面上的画布元素 var cxt = c.getContext('2d');
         * 设置画布为2d cxt.fillStyle = '#FF0000'; 设定填充色为#FF0000
         * cxt.fillRect(0,0,150,150); 在画布上绘制矩形
         */
        js.executeScript("var c = document.getElementById('myCanvas');" + "var cxt = c.getContext('2d');"
                + "cxt.fillStyle = '#FF0000';" + "cxt.fillRect(0,0,150,150);");
        // 绘制红色矩形后，进行屏幕截屏，并保存为 E:\\selenium 的 HTML5Canvas.jpg 文件
        captureScreenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(captureScreenFile, new File("E:/selenium/HTML5Canvas.jpg"));
            Thread.sleep(8000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
