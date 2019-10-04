package per.cyj.selenium.senior;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _18Html5VedioPlayerTest extends BaseTest {

    private String baseUrl = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_video_simple";

    @Test(description = "控制HTML5语言实现的视频播放器")
    public void testVideoPlayer() throws InterruptedException, IOException {
        driver.navigate().to(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 定义页面截图文件对象，用于后面的屏幕截图存储
        File captureScreenFile = null;
        // 打印HTML5视频播放器页面的源代码，供读者学习
        System.out.println(driver.getPageSource());
        // 获取页面中的video标签
        WebElement videoPlayer = driver.findElement(By.tagName("video"));
        // 声明一个JavascriptExecutor对象
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        // 调用JavascriptExecutor对象执行JavaScript语句，通过播发器内部的
        // currentSrc属性获取视频文件的网络存储地址
        String videoSrc = (String) javascriptExecutor.executeScript("return arguments[0].currentSrc", videoPlayer);
        // 输出视频文件的网络存储地址
        System.out.println(videoSrc);
        // 断言视频网络地址是否符合期望
        Assert.assertEquals("http://www.w3school.com.cn/i/movie.ogg", videoSrc);
        // 使用JavascriptExecutor对象执行JavaScript语句，通过播放器内部的
        // duration属性获取视频文件的播放时长
        Double videoDuration = (Double) javascriptExecutor.executeScript("return arguments[0].duration", videoPlayer);
        // 输出视频的播放时长
        System.out.println(videoDuration.intValue());
        // 等待5秒让视频完成加载
        Thread.sleep(5000);
        // 使用JavascriptExecutor对象执行JavaScript语句，通过播放器内部的
        // play函数来播放影片
        javascriptExecutor.executeScript("return arguments[0].play()", videoPlayer);
        Thread.sleep(2000);
        // 播放2秒后，使用JavascriptExecutor对象执行JavaScript语句，通过播放器的
        // 内部的pause函数暂停播放影片
        javascriptExecutor.executeScript("return arguments[0].pause()", videoPlayer);
        // 暂停3秒验证暂停操作是否生效
        Thread.sleep(3000);
        // 将暂停视频播放后的页面进行截屏，并保存为E:\selenium盘上的videoPlay_pause.jpg文件
        captureScreenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(captureScreenFile, new File("E:/selenium/videoPlay_pause.jpg"));
    }

}
