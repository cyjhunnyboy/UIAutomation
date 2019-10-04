package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-04
 */
public class _05DownLoadFileByFirefoxTest {

    // 下载文件的测试网页地址
    private String baseUrl = "http://ftp.mozilla.org/pub/mozilla.org//firefox/releases/33.0b8/win32/zh-CN/";
    private static String downloadFilePath = "E:/selenium/Download Files";
    private FirefoxProfile profile = null;
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // 设定连接firefox浏览器驱动程序所在的磁盘位置，并添加为系统属性值
        System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "设置一个页面对象的属性值")
    public void testDownLoadFileByFirefox() throws Exception {
        driver.navigate().to(baseUrl); // 访问被测试网页
        // 获取包含“Stub”关键字的页面下载链接元素
        WebElement downLoadClick = driver.findElement(By.partialLinkText("Stub"));
        // 单击包含“Stub”关键字的下载链接
        downLoadClick.click();
        Thread.sleep(60000);
    }

    private void firefoxDriverProfile() {
        // 声明一个profile对象
        profile = new FirefoxProfile();
        /*
         * 设定Firefox的browser.download.folderList属性值为2
         * 若果没有进行显示设定，则使用默认值1，表示下载的文件保存在“下载”文件夹 设定为0，则下载文件会保存在用户的桌面上
         * 设定为2，则下载文件会保存在指定的文件夹下
         */
        profile.setPreference("browser.download.folderList", 2);
        // browser.download.manager.showWhenStarting的属性值默认为True
        // 设定为True，则在用户启动下载的时候显示Firefox浏览器的下载窗口，false则不显示
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        // browser.download.dir设置下载文件的保存目录
        profile.setPreference("browser.download.dir", downloadFilePath);
        // browser.helperApps.neverAsk.openFile表示直接打开下载文件，不显示确认框
        // 默认为空字符串，下载代码行设定了多种文件的MIME类型
        profile.setPreference("browser.helperApps.neverAsk.openFile",
                "application/octet-stream, application/exe, text/csv, application/pdf, application/x-msexcel, "
                        + "application/excel, application/x-excel, application/vnd.ms-excel, image/png, image/jpeg, "
                        + "text/html, text/plain, application/msword, application/xml");
        // browser.helperApps.neverAsk.saveToDisk表示下载文件是否直接保存到磁盘
        // 默认为空字符串，下载代码行设定了多种文件的MIME类型
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "application/octet-stream, application/exe, text/csv, application/pdf, application/x-msexcel, "
                        + "application/excel, application/x-excel, application/vnd.ms-excel, image/png, image/jpeg, "
                        + "text/html, text/plain, application/msword, application/xml, text/x-c");
        // browser.helperApps.alwaysAsk.force表示对于未知的MIME类型文件会弹出窗口
        // 让用户处理，默认值为true，设定为false表示不会记录打开未知的MIME类型文件的方式
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        // 下载exe文件弹出警告，默认值是true，设定为false则不会弹出警告弹窗
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        // browser.download.manager.focusWhenStarting设定下载框在下载时会获取焦点
        // 默认值为true，设定为false表示不会获取焦点
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        // browser.download.manager.useWindow设定下载是否显示下载框
        // 默认值为true，设定为false会把下载框隐藏
        profile.setPreference("browser.download.manager.useWindow", false);
        // browser.download.manager.showAlertOnComplete设定下载文件结束后是否显示下载完成提示框
        // 默认值为true，设定为false表示下载完成后不显示下载完成提示框
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        // browser.download.manager.closeWhenDone设定下载文件结束后是否关闭下载框
        // 默认值为true，设定为false表示不关闭下载管理器
        profile.setPreference("browser.download.manager.closeWhenDone", false);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit(); // 关闭浏览器
    }

}
