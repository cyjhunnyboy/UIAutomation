package per.cyj.selenium.po.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 使用LoadableComponent类 继承 LoadableComponent类可以在页面加载的时候判断是否加载了正确的页面，
 * 只需要重新isLoaded和load两个方法，此方式有助于让页面对象的页面访问操作更加健壮
 *
 * @author chenyongjun
 */
public class LoginPage extends LoadableComponent<LoginPage> {

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

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@class='ferrorhead']")
    public WebElement error;

    public String url = "http://mail.126.com";
    public String title = "网易免费邮";
    public WebDriver driver;

    /**
     * 不带参数的构造函数，生成浏览器对象，初始化 PageFactory 对象
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * 登录操作的封装方法，函数返回一个 HomePage 对象
     *
     * @param rightUserName
     * @param rightPassword
     * @return HomePage
     * @throws InterruptedException
     */
    public HomePage login(String rightUserName, String rightPassword) throws InterruptedException {
        this.load();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        // 页面是否显示了 name 属性为“email”的用户名输入框
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        // 清除用户名输入框中的字符，保证用户名的输入框为空
        this.userName.clear();
        // 输入邮箱用户名
        this.userName.sendKeys(rightUserName);
        // 等待2秒
        Thread.sleep(2000);
        // 输入邮箱密码
        this.password.sendKeys(rightPassword);
        // 等待2秒
        Thread.sleep(2000);
        // 单击登录按钮
        this.loginButton.click();
        // 登录成功后，函数返回一个 HomePage 对象
        return new HomePage(this.driver);
    }

    /**
     * 登录失败的封装方法，函数返回一个 LoginPage 页面对象
     *
     * @param rightUsername
     * @param errorPassword
     * @return LoginPage
     * @throws InterruptedException
     */
    public LoginPage LoginFailure(String rightUsername, String errorPassword) throws InterruptedException {
        load();
        WebDriverWait wait = new WebDriverWait(this.driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        // 清除用户名输入框中的字符，保证用户名的输入框为空
        this.userName.clear();
        // 输入邮箱用户名
        this.userName.sendKeys(rightUsername);
        // 等待2秒
        Thread.sleep(2000);
        // 输入邮箱密码
        this.password.sendKeys(errorPassword);
        // 等待2秒
        Thread.sleep(2000);
        // 单击登录按钮
        this.loginButton.click();
        // 登录失败后，当前测试页面网址不会发生跳转，函数返回一个 LoginPage 对象
        // 保持浏览器依旧停留在登录页面
        return new LoginPage(driver);

    }

    /**
     * 增加需要覆盖的方法
     */
    @Override
    protected void load() {
        this.driver.manage().window().maximize();
        this.driver.navigate().to(this.url);
        this.isLoaded();
        this.driver.switchTo().frame(this.frame);
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

    /**
     * 获取页面源代码的封装方法
     *
     * @return PageSource
     */
    public String getPageSource() {
        return this.driver.getPageSource();
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
     * 返回 error 元素对象
     *
     * @return error
     */
    public WebElement getError() {
        return this.error;
    }

    /**
     * 关闭浏览器的封装方法
     */
    public void close() {
        this.driver.close();
    }
}
