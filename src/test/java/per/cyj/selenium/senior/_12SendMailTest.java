package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _12SendMailTest extends BaseTest {

    private String baseUrl = "http://mail.sina.com/";

    /**
     * 操作富文本框：富文本框的技术实现和普通的文本框定位存在较大的区别，富文本框的常见实现技术用到了Frame标签，
     * 并且在Frame里面实现了一个完整的HTML页面结构，所以使用普通的定位模式无法直接定位到富文本框对象。
     * 目的：能够定位到页面中的富文本框对象，使用JavaScript语句来实现富文本框中的HTML格式内容输入
     *
     * @throws Exception 抛出异常
     */
    @Test(description = "测试新浪邮箱发送邮件")
    public void testSendMail() throws Exception {
        driver.navigate().to(baseUrl); // 访问被测试的网页
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // 使用显示等待，判断页面是否显示账户名输入框元素对象
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("freename")));
        // 获取页面的用户名，密码和提交按钮对象
        WebElement userName = driver.findElement(By.id("freename"));
        WebElement password = driver.findElement(By.id("freepassword"));
        WebElement submitButton = driver.findElement(By.className("loginBtn"));
        // 输入用户名和密码，并单击提交按钮
        userName.sendKeys("cyjhunnyboy@sina.com");
        Thread.sleep(2000);
        password.sendKeys("yongene123");
        Thread.sleep(2000);
        submitButton.click();
        // 显示等待，判断页面是否跳转到邮箱首页，等待写信的网页内容出现在页面上
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@_appid='writer']")));
        // 获取登录成功后页面上的写信按钮，并单击此按钮
        WebElement writeMailButton = driver.findElement(By.xpath("//a[@_appid='writer']"));
        writeMailButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='other']/input")));
        // 找到收件人输入框和邮件主题输入框对象，分别输入测试数据
        WebElement recipients = driver.findElement(By.xpath("//li[@class='other']/input"));
        WebElement subject = driver.findElement(By.xpath("//input[@name='subj']"));
        recipients.sendKeys("cyjhunnyboy@sina.com");
        Thread.sleep(2000);
        subject.sendKeys("发给自己的一封测试邮件");
        Thread.sleep(2000);
        // 切换到富文本框所在的iframe对象中，具体的iframe的ID可以使用FirePath工具获取到
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='iframe']"));
        driver.switchTo().frame(iframe);
        // 声明 JavascriptExecutor 对象来执行 JavaScript 脚本
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // document.getElementByTagName('body')[0]可以获取富文本框的编辑区对象
        // 使用编辑区对象的 innerHTML 属性可以设定任意 HTML 格式的文字内容
        jsExecutor.executeScript("document.getElementsByTagName('body')[0].innerHTML = '<b>邮件要发送的内容</b>'");
        // 从富文本框的 iframe 返回到默认的页面区域
        driver.switchTo().defaultContent();
        // 找到页面上发送邮件的按钮对象，并单击发送
        Thread.sleep(2000);
        WebElement sendMailButton = driver.findElement(By.xpath("//i[contains(@class, 'mailPubText')]"));
        Assert.assertTrue(sendMailButton.isDisplayed());
        sendMailButton.click();
        Thread.sleep(5000);
        // 断言发送成功页面是否包含“您的邮件已发送”几个关键字
        Assert.assertTrue(driver.getPageSource().contains("您的邮件已发送"));
    }

}
