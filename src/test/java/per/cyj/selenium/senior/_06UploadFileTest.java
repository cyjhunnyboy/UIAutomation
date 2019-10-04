package per.cyj.selenium.senior;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-11
 */
@Slf4j
public class _06UploadFileTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/uploadfile.html";
    private String uploadFile = "D:/Tomcat/tomcat-8/webapps/selenium/html/upload.txt";

    @Test(description = "使用sendKeys方法上传一个文件附件")
    public void testUploadFile() {
        // 访问被测试网页
        driver.navigate().to(baseUrl);
        // 找到页面上ID为filesubmit的文件上传框
        WebElement fileInputBox = driver.findElement(By.id("file"));
        log.info("上传文件输入框元素是：{}", fileInputBox.getTagName());
        // 在文件上传框的路径框里输入要上传的文件路径
        fileInputBox.sendKeys(uploadFile);
        // 使用显示等待方式，声明一个等待对象
        WebDriverWait wait = new WebDriverWait(driver, 5);
        // 显示等待判断页面上的提交按钮是否处于可点击状态
        wait.until(ExpectedConditions.elementToBeClickable(By.id("filesubmit")));
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
