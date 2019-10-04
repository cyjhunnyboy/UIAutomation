package per.cyj.selenium.po.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 使用PageFactory类 使用PageFactory类给测试类提供待操作的页面元素
 *
 * @author chenyongjun
 */
public class LoginPage1 {

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@name='email']")
    public WebElement userName;

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    // 使用 FindBy 注解，定位需要操作的页面元素，XPath方式定位元素
    @FindBy(xpath = "//*[@id='dologin']")
    public WebElement loginButton;

    /**
     * 带参数的构造函数，生成浏览器对象，初始化 PageFactory 对象
     *
     * @param paramDriver
     */
    public LoginPage1(WebDriver paramDriver) {
        PageFactory.initElements(paramDriver, this);
    }
}
