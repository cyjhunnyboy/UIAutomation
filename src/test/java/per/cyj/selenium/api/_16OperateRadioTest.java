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
public class _16OperateRadioTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/radio.html";

    @Test(description = "操作单选框")
    public void testOperateRadio() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 查找属性为“berry”的单选按钮对象
        WebElement radioOption = driver.findElement(By.xpath("//input[@value='berry']"));
        // 如果此单选按钮处于未被选中状态，则调用click方法选中此单选按钮
        if (!radioOption.isSelected()) {
            radioOption.click();
        }
        // 断言属性值为“berry”的单选按钮是否处于选中状态
        Assert.assertTrue(radioOption.isSelected());
        Thread.sleep(1000);
        // 查找name属性值为“fruit”的所有单选按钮对象，并存储到一个list容器中
        List<WebElement> fruits = driver.findElements(By.name("fruit"));
        /*
         * 使用for循环将list容器中的每个单选按钮进行遍历，查找value属性值为“watermelon”的
         * 单选按钮，如果查找到此单选按钮未处于选中状态，则调用click方法进行单击选择
         */
        for (WebElement fruit : fruits) {
            if (fruit.getAttribute("value").equals("watermelon")) {
                if (!fruit.isSelected())
                    fruit.click();
                // 断言单选按钮是否被成功选中
                Assert.assertTrue(fruit.isSelected());
                // 成功选中后，退出for循环
                break;
            }
        }
        Thread.sleep(1000);
        log.info("执行{}用例成功！", "testOperateRadio");
    }
}
