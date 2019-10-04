package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _30ExplicitWaitTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/wait.html";

    @Test(description = "常用的显示等待")
    public void testExplicitWait() {
        // 访问被测试的网页
        driver.navigate().to(baseUrl);
        // 声明一个WebDriverWait对象，设定触发条件的最长等待时间为3秒
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // 调用ExpectedConditions的titleContains方法判断页面上的title是否包含“水果”两个关键字
        wait.until(ExpectedConditions.titleContains("水果"));
        log.info("网页的标题出现了“水果的关键字”");
        // 获得页面下拉列表中的“桃子”选项对象
        WebElement select = driver.findElement(By.xpath("//option[@id='peach']"));
        // 调用ExpectedConditions的elementToBeSelected方法，判断“桃子”对象是否处于选中状态
        wait.until(ExpectedConditions.elementToBeSelected(select));
        log.info("下拉列表的选项“桃子”目前处于选中状态");
        // 获得type属性值为“checkbox”的input复选框页面元素
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        // 调用ExpectedConditions的elementToBeClickable方法，判断页面的复选框对象是否可见并可被单击
        wait.until(ExpectedConditions.elementToBeClickable(checkbox));
        log.info("页面复选框处于显示和可被单击状态");
        checkbox.click();
        // 调用ExpectedConditions的presenceOfElementLocated方法，判断p标签对象是否在页面中
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p")));
        log.info("页面的p标签元素已显示");
        WebElement p = driver.findElement(By.xpath("//p"));
        // 调用ExpectedConditions的textToBePresentInElement方法，判断p标签对象中是否包含“爱吃的水果”这几个字
        wait.until(ExpectedConditions.textToBePresentInElement(p, "爱吃的水果"));
        log.info("页面的p标签元素包含文本“爱吃的水果”");
    }

}
