package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import per.cyj.selenium.BaseTest;
import per.cyj.selenium.util.DateUtil;
import per.cyj.selenium.util.FileUtil;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _15CaptureScreenFailTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "在测试中断言失败的步骤进行屏幕截图")
    public void testCaptureScreenFail() throws Exception {
        // 访问“sogou”首页
        driver.navigate().to(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试，飞起来！");
        driver.findElement(By.id("stb")).click();
        Thread.sleep(5000);
        try {
            // 断言页面的代码中是否存在“事在人为”这4个关键字，因为页面中没有这4个字，
            // 所以会触发catch语句的执行，并触发截图操作
            Assert.assertTrue(driver.getPageSource().contains("事在人为"));
        } catch (AssertionError e) {
            System.out.println("catch中的代码被执行了");
            takeTakesScreenshot(driver);
        }
    }

    /**
     * 在测试类中声明截图的方法，截图方法调用了时间类和文件操作类的静态方法，
     * 用来以时间 格式生成目录名称和截图文件名称
     *
     * @param driver 浏览器驱动参数
     */
    public void takeTakesScreenshot(WebDriver driver) {
        try {
            // 生产日期对象
            Date date = new Date();
            // 调用DateUtil类中的方法，生产截图所在的文件夹日期名称
            String picDir = "E:/selenium/other/" + String.valueOf(DateUtil.getYear(date)) + "-"
                    + String.valueOf(DateUtil.getMonth(date)) + "-" + String.valueOf(DateUtil.getDate(date));
            if (!new File(picDir).exists()) {
                FileUtil.createDir(picDir);
            }
            // 调用DateUtil类中的方法，生产截图文件的日期名称
            String filePath = picDir + "\\" + String.valueOf(DateUtil.getHour(date)) + "-"
                    + String.valueOf(DateUtil.getMinute(date)) + "-" + String.valueOf(DateUtil.getSecond(date))
                    + ".jpg";
            // 进行截图，并将文件内容保存在 scrFile 对象中
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // 将截图文件内容写入到磁盘中，生产截图文件
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
