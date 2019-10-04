package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _15OperateMultipleOptionDropListTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/multiple.html";

    @Test(description = "操作多选的选项列表")
    public void testOperateMultipleOptionDropList() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 找到页面的下拉列表元素
        WebElement element = driver.findElement(By.name("fruit"));
        Select dropList = new Select(element);
        // 判断页面的下拉列表是否支持多选，支持多选则isMultiple方法返回True
        Assert.assertTrue(dropList.isMultiple());
        // 使用选择索引选择“猕猴桃”选项
        dropList.selectByIndex(3);
        Thread.sleep(1000);
        // 使用value属性值选择“山楂”选项
        dropList.selectByValue("shanzha");
        Thread.sleep(1000);
        // 使用选项文字选择“荔枝”选项
        dropList.selectByVisibleText("荔枝");
        Thread.sleep(1000);
        // deselectAll方法表示取消所有选项的选中状态
        dropList.deselectAll();
        Thread.sleep(1000);
        // 再次选中3个选项
        dropList.selectByIndex(3);
        dropList.selectByValue("shanzha");
        dropList.selectByVisibleText("荔枝");
        Thread.sleep(1000);
        // deselectByIndex方法表示取消索引为3的选项的选中状态
        dropList.deselectByIndex(3);
        Thread.sleep(1000);
        // deselectByValue方法表示取消value值为“shanzha”的选项的选中状态
        dropList.deselectByValue("shanzha");
        Thread.sleep(1000);
        // deselectByVisibleText方法表示通过选项文字取消“荔枝”选项的选中状态
        dropList.deselectByVisibleText("荔枝");
        Thread.sleep(1000);
        log.info("执行{}测试用例成功！", "testMultipleOptionDropList()");
    }
}
