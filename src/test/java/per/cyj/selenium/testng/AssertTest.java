package per.cyj.selenium.testng;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 测试断言类
 * @since 2019-08-04
 */
public class AssertTest extends BaseTest {

    // 设定访问网站的地址
    private String baseUrl = "https://www.sogou.com/";

    @Test
    public void testSearch() {
        // 打开搜狗首页
        driver.get(baseUrl + "/");
        // 定位搜索输入框
        WebElement inputBox = driver.findElement(By.id("query"));
        /*
         * 使用Assert的assertTrue方法断言输入框是否在页面显示
         * isDisplayed方法根据页面元素的显示状态返回判断值，在页面显示则返回true，否则返回false
         */
        Assert.assertTrue(inputBox.isDisplayed());
        // 在搜索输入框中输入“光荣之路自动化测试”
        inputBox.sendKeys("光荣之路自动化测试");
        // 单击“搜索”按钮
        driver.findElement(By.id("stb")).click();
    }

}
