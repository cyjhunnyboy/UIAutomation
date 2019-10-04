package per.cyj.selenium.po.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 使用PageFactory类 使用PageFactory类给测试类提供待操作的页面元素
 *
 * @author chenyongjun
 */
public class LoginPage2 {

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@name='email']")
    public WebElement userName;

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@id='dologin']")
    public WebElement loginButton;

    // 使用 FindBy 注解，定位需要操作的页面元素
    @FindBy(tagName = "iframe")
    public WebElement frame;

    public WebDriver driver;
    public String url = "http://mail.126.com";

    /**
     * 不带参数的构造函数，生成浏览器对象，初始化 PageFactory 对象
     */
    public LoginPage2() {
        // 如果找到Firefox，设定Firefox的路径
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * 访问被测网址的封装方法
     */
    public void load() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.switchTo().frame(this.frame);
    }

    /**
     * 关闭浏览器的封装方法
     */
    public void quit() {
        driver.quit();
    }

    /**
     * 登录操作的封装方法
     */
    public void login(String user_name, String user_password) {
        userName.sendKeys(user_name);
        password.sendKeys(user_password);
        loginButton.click();
    }

    /**
     * 返回driver的封装方法
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }
}
