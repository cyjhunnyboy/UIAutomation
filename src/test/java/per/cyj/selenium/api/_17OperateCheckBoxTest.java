package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _17OperateCheckBoxTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/checkbox.html";

    @Test(description = "操作复选框")
    public void testOperateCheckBox() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 查找value属性值为“orange”的复选框元素
        WebElement orangeCheckbox = driver.findElement(By.xpath("//input[@value='orange']"));
        // 如果此复选框未被选中，则调用click方法单击选中此复选框
        if (!orangeCheckbox.isSelected())
            orangeCheckbox.click();
        // 断言复选框是否被成功选中
        Assert.assertTrue(orangeCheckbox.isSelected());
        Thread.sleep(1000);
        // 如果复选框处于选中状态，再次调用click方法单击取消复选框的选中状态
        if (orangeCheckbox.isDisplayed())
            orangeCheckbox.click();
        // 断言复选框处于非选中状态
        Assert.assertFalse(orangeCheckbox.isSelected());
        Thread.sleep(1000);
        // 查找所有name属性值为“fruit”的所有复选框，并存放在list容器中
        List<WebElement> checkboxs = driver.findElements(By.name("fruit"));
        // 遍历list容器中的所有复选框元素，调用click方法单击所有复选框，让全部复选框处于选中状态
        for (WebElement checkbox : checkboxs)
            checkbox.click();
        Thread.sleep(1000);
        log.info("执行测试用例{}成功!", "testOperateCheckBox()");
    }

}
