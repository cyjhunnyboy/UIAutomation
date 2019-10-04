package per.cyj.selenium.po.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

/**
 * 使用LoadableComponent类 继承 LoadableComponent类可以在页面加载的时候判断是否加载了正确的页面，
 * 只需要重新isLoaded和load两个方法，此方式有助于让页面对象的页面访问操作更加健壮
 *
 * @author chenyongjun
 */
public class LoginPage3 extends LoadableComponent<LoginPage3> {

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@name='email']")
    public WebElement userName;

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@id='dologin']")
    public WebElement loginButton;

    public String url = "http://mail.126.com";
    public String title = "网易免费邮";
    public WebDriver driver;

    /**
     * 不带参数的构造函数，生成浏览器对象，初始化 PageFactory 对象
     */
    public LoginPage3() {
        // 如果找到Firefox，设定Firefox的路径
        System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        this.driver = new FirefoxDriver();
        PageFactory.initElements(this.driver, this);
    }

    /**
     * 增加需要覆盖的方法
     */
    @Override
    protected void load() {
        this.driver.manage().window().maximize();
        this.driver.navigate().to(this.url);
        this.driver.switchTo().frame("x-URS-iframe");
    }

    /**
     * 关闭浏览器的封装方法
     */
    public void quit() {
        this.driver.quit();
    }

    /**
     * 登录操作的封装方法
     */
    public void login(String user_name, String user_password) {
        this.userName.sendKeys(user_name);
        this.password.sendKeys(user_password);
        this.loginButton.click();
    }

    /**
     * 返回driver的封装方法
     *
     * @return driver
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * 增加了需要覆盖的方法 isLoaded
     */
    @Override
    protected void isLoaded() throws Error {
        // 断言访问后的页面 Title 是否包含 “网易免费邮”这几个关键字
        // 判断浏览器是否加载了正确的网址
        Assert.assertTrue(this.driver.getTitle().contains(this.title));
    }
}
