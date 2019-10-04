package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _33IdentifyPopUpWindowByTitleTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/title.html";

    @Test(description = "使用Title属性识别和操作新弹出的浏览器窗口")
    public void testIdentifyPopUpWindowByTitle() throws Exception {
        // 访问被测试的网页
        driver.navigate().to(baseUrl);
        Thread.sleep(1000); // 等待1秒钟
        // 现将当前浏览器窗口的句柄存储到presentWinHandle变量中
        String presentWinHandle = driver.getWindowHandle();
        // 找到页面sogou链接元素，存储在sogouLink变量中
        WebElement sogouLink = driver.findElement(By.xpath("//a[@target='_blank']"));
        // 单击找到的链接
        sogouLink.click();
        Thread.sleep(1000);
        // 获取当前所有打开浏览器窗口的句柄，存储在一个set容器中
        Set<String> allWinHandle = driver.getWindowHandles();
        // 如果容器存储的对象不为空，则遍历allWinHandle中的所有浏览器句柄
        if (!allWinHandle.isEmpty()) {
            String Title = "搜狗搜索引擎 - 上网从搜狗开始";
            for (String winHandle : allWinHandle) {
                log.info("当前浏览器窗口句柄是--------------{}", winHandle);
                try {
                    if (driver.switchTo().window(winHandle).getTitle().equals(Title)) {
                        driver.findElement(By.id("query")).sendKeys("sogou首页的浏览器窗口被找到");
                    }
                } catch (NoSuchWindowException e) {
                    // 如果没有找到浏览器的句柄，则会抛出NoSuchWindowException异常，并打印异常的堆栈信息
                    log.error("没有找到对应的浏览器窗口句柄----------------", e);
                }
            }
            Thread.sleep(1000);
        }
        // 返回最初打开的浏览器页面
        driver.switchTo().window(presentWinHandle);
        // 断言浏览器页面的Title属性值是否是“你喜欢的水果”，以此判断页面切换是否达到预期期望
        Assert.assertEquals(driver.getTitle(), "你喜欢的水果");
        Thread.sleep(1000);
    }
}
