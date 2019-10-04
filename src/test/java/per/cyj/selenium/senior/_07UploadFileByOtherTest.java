package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-10
 */
public class _07UploadFileByOtherTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/uploadfile.html";

    @Test(description = "使用第三方工具AutoIt上传文件")
    public void testUploadFileByOther() throws Exception {
        // 访问被测试网页
        driver.navigate().to(baseUrl);
        // 找到页面上ID为filesubmit的文件上传框
        WebElement fileInputBox = driver.findElement(By.id("file"));
        // 单击文件上传对象，会弹出文件选择框体
        fileInputBox.click();
        // 调用存储在D盘的AutoIt的可执行文件test.exe
        Runtime.getRuntime().exec("d:/test.exe");
        Thread.sleep(10000);
        // 使用显示等待方式，声明一个等待对象
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // 判断页面是否关闭了文件选择框，重新显示上传文件元素
        wait.until(ExpectedConditions.elementToBeClickable(By.id("file")));
        // 找到ID为“filesubmit”的文件提交按钮对象
        WebElement fileSubmitButton = driver.findElement(By.id("filesubmit"));
        // 单击文件提交按钮，完成文件提交操作
        fileSubmitButton.click();
        /*
         * 因为文件上传需要时间，所以此处添加显示等待的判断代码，判断文件上传成功后，
         * 页面是否跳转到了上传成功的页面，通过titleContains函数判断跳转后的页面Title是否符合期望值，如果匹配，
         * 则继续执行后续测试代码
         */
        wait.until(ExpectedConditions.titleContains("文件上传成功"));
    }

}
