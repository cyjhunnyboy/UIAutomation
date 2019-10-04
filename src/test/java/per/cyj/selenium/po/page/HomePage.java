package per.cyj.selenium.po.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;

    /*
     * 由于126邮箱页面元素使用的是变化ID，所以在XPath定位表达式中使用contains函数 来模糊定位写信的链接对象
     */
    @FindBy(xpath = "//*[contains(@id, '_mail_component')]/span[text()='写 信']")
    public WebElement writeMailLink;

    /*
     * 使用xpath定位收信人
     */
    @FindBy(xpath = "//*[@class='nui-editableAddr-ipt']")
    public WebElement recipients;

    /**
     * 使用xpath定位邮件主题
     */
    @FindBy(xpath = "//*[contains(@id, '_subjectInput')]")
    public WebElement emailSubject;

    /*
     * 由于126邮箱页面元素使用的是变化ID，所以在XPath定位表达式中使用contains函数 来模糊定位写信的链接对象
     */
    @FindBy(xpath = "//*[@class='nui-toolbar-item']/*[contains(@id, '_mail_button_')]/span[text()='发送']")
    public WebElement sendMailButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * 写信的封装方法
     *
     * @throws InterruptedException
     */
    public void writeMail() throws InterruptedException {
        // 单击登录成功后页面上的“写信”链接
        this.writeMailLink.click();
        /*
         * 等待2秒钟，让页面完成到写信页面的跳转 由于126邮箱使用特殊技术，页面的跳转均让页面的URL保持不变（即登录成功后跳转页面
         * URL在写信、查看邮件等操作后保持不变），所以不会把写邮件当作一个新的PageObject对象
         */
        Thread.sleep(2000);
        // 写邮件页面，填写收件人
        this.recipients.sendKeys("cyjhunny@126.com");
        // 等待2秒
        Thread.sleep(2000);
        // 写邮件页面，填写邮件主题
        this.emailSubject.sendKeys("邮件标题");
        // 等待2秒
        Thread.sleep(2000);
        // 按 TAB 键，把焦点切换到邮件正文编辑框
        pressTabKey();
        // 调用粘贴板函数，在邮件正文编辑框粘贴字符串“邮件正文”
        setAndctrlVClipboardData("邮件正文");
        // 单击发送邮件按钮
        this.sendMailButton.click();
    }

    /**
     * 获取页面源码的封装方法
     *
     * @return String
     */
    public String getPageSource() {
        return this.driver.getPageSource();
    }

    /**
     * 增加了需要覆盖的方法 close
     */
    public void close() {
        this.driver.close();
    }

    /**
     * 设定剪切板并进行字符串粘贴的封装方法
     *
     * @param string
     */
    public static void setAndctrlVClipboardData(String string) {
        // 模拟 Ctrl+V，进行粘贴操作
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
    }

    /**
     * 按 TAB 键的封装方法
     */
    public static void pressTabKey() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }
}
