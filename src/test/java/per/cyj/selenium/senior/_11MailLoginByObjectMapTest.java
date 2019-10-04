package per.cyj.selenium.senior;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import per.cyj.selenium.BaseTest;
import per.cyj.selenium.object.ObjectMap;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
@Slf4j
public class _11MailLoginByObjectMapTest extends BaseTest {

    private ObjectMap objectMap;
    private String baseUrl = "http://mail.sina.com/";

    /**
     * 对象库（UI Map) 目的：能够使用配置文件存储被测试页面上元素的定位方式和定位表达式，
     * 做到定位数据和程序的分离，测试程序写好以后，可以方便不具备编码能力的测试人员进行自定义修改和配置。
     * 此部分内容可以 作为自定义的高级自动化框架的组成部分。
     *
     * @throws Exception 抛出异常
     */
    @Test(description = "通过对象库方式测试新浪邮箱登录")
    public void testMailLoginByObjectMap() throws Exception {
        driver.navigate().to(baseUrl); // 访问被测试的网页
        Thread.sleep(3000);
        try {
            // 声明一个 ObjectMap 对象实例，参数是 objectMap 文件的绝对路径
            objectMap = new ObjectMap("/objectMap.properties");
        } catch (Exception e) {
            log.info("生产ObjectMap对象失败");
        }
        // 调用 objectMap 实例的 getLocator 方法获取元素对象
        WebElement userName = driver.findElement(objectMap.getLocator("SohuMail.HomePage.username"));
        WebElement password = driver.findElement(objectMap.getLocator("SohuMail.HomePage.password"));
        WebElement submitButton = driver.findElement(objectMap.getLocator("SohuMail.HomePage.submitButton"));
        userName.sendKeys("cyjhunnyboy@sina.com");
        Thread.sleep(1000);
        password.sendKeys("yongene123");
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(2000);
        WebElement userId = driver.findElement(objectMap.getLocator("SohuMail.HomePage.userid"));
        // 断言页面上的账号是否和登录的账户一致
        Assert.assertEquals(userId.getText(), "cyjhunnyboy@sina.com");
    }
}
