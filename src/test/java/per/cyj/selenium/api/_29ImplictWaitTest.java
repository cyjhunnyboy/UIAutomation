package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _29ImplictWaitTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @Test(description = "隐式等待")
    public void testImplictWait() {
        // 访问sogou首页
        driver.navigate().to(baseUrl);
        // 使用implictWait方法设定查找页面元素的等待时间，调用findElement方法时没有
        // 立刻找到定位元素会等待设定的等待时长
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            // 查找sogou首页的输入框对象
            WebElement input = driver.findElement(By.id("query"));
            // 查找sogou首页的搜索按钮
            WebElement searchButton = driver.findElement(By.id("stb"));
            // 在输入框中输入“输入框元素被成功找到了”几个关键字
            input.sendKeys("输入框元素被成功找到了");
            // 单击“搜索”按钮
            searchButton.click();
        } catch (NoSuchElementException e) {// 如果没有找到元素，则捕获程序抛出的NoSuchElementException异常
            // 使用fail方法在找不到元素的时候，让测试用例执行失败
            // Assert.fail("没有找到搜索的输入框");
            // 打印错误的堆栈信息
            // e.printStackTrace();
            log.error("没有找到搜索的输入框-----------------", e);
        }
    }

}
