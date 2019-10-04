package per.cyj.selenium.senior;

import org.testng.annotations.Test;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _13CompareImags extends BaseTest {

    private String baseUrl = "http://www.sogou.com/";

    @Test(description = "精确比较网页截图图片")
    public void testImageComparison() {
        driver.navigate().to(baseUrl); // 访问被测试的网页
        try {
            // 隐式等待
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // 对Sogou首页进行截屏
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("E:/Selenium/other/sogouHomePage_actural.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 生成两个文件对象，一个是期望的图片，一个是实际测试过程中产生的图片
        File expectedImageFile = new File("E:/selenium/other/sogouHomePage_expected.jpg");
        File acturalImageFile = new File("E:/Selenium/other/sogouHomePage_actural.jpg");
        // 断言调用图片比较的方法是否返回True，若返回True，则一致，否则失败
        Assert.assertTrue(compareImage(expectedImageFile, acturalImageFile), "测试过程中的截图和期望的截图不一致");
    }

    /**
     * 以下方法为两个文件进行像素对比的算法实现，获取文件的像素个数大小，然后使用循环的方式将两张图的所有项目进行一一比对，
     * 如有任何一个像素不同，则退出循环，将matchFlag变量设定为false，并返回matchFlag值
     *
     * @param expectedImageFile 预期值
     * @param acturalImageFile  实际值
     * @return boolean
     */
    private Boolean compareImage(File expectedImageFile, File acturalImageFile) {
        boolean matchFlag = true;
        try {
            // 声明一个 BufferedImage 对象，并读取到内存中
            BufferedImage expectedBufferedImage = ImageIO.read(expectedImageFile);
            // 声明一个 DataBuffer 对象
            DataBuffer expectedDataBuffer = expectedBufferedImage.getData().getDataBuffer();
            // 获取图片大小
            int sizeExpectedImage = expectedDataBuffer.getSize();

            // 声明一个 BufferedImage 对象，并读取到内存中
            BufferedImage acturalBufferedImage = ImageIO.read(acturalImageFile);
            // 声明一个 DataBuffer 对象
            DataBuffer acturalDataBuffer = acturalBufferedImage.getData().getDataBuffer();
            // 获取图片大小
            int sizeActuralImage = acturalDataBuffer.getSize();

            if (sizeActuralImage == sizeExpectedImage) {
                // 循环的方式将两张图的所有项目进行一一比对，如有任何一个像素不同，则退出循环，将matchFlag变量设定为false
                for (int i = 0; i < sizeExpectedImage; i++) {
                    if (expectedDataBuffer.getElem(i) != acturalDataBuffer.getElem(i)) {
                        matchFlag = false;
                        break; // 退出for循环
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回Boolean类型的matchFlag
        return matchFlag;
    }

}
