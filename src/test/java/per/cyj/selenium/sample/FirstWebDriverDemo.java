package per.cyj.selenium.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author chenyongjun
 * @apiNote 第一个WebDriver程序
 * @since 2019-07-30
 */
public class FirstWebDriverDemo {

    public static void main(String[] args) throws Exception {
        WebDriver driver;
        String baseUrl;
        // 若无法打开Firefox浏览器时，可设定Firefox浏览器的安装路径
        System.setProperty("webdriver.chrome.driver", "D:/Tools/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://www.sogou.com/";
        // 打开搜狗首页
        driver.get(baseUrl + "/");
        // 在搜索输入框中输入“光荣之路自动化测试”
        driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
        // 单击“搜索”按钮
        driver.findElement(By.id("stb")).click();
        System.out.print("测试成功！");
        Thread.sleep(2000);
        // 关闭浏览器
        driver.close();
    }
}
