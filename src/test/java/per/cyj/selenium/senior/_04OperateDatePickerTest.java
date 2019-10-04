package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-11
 */
public class _04OperateDatePickerTest extends BaseTest {

    private String baseUrl = "http://jqueryui.com/resources/demos/datepicker/other-months.html";

    @Test(description = "在日期选择器上进行日期选择")
    public void testElementAttribute() throws Exception {
        // 访问被测试网页
        driver.navigate().to(baseUrl);
        // 查找日期输入框，直接输入日期，就可以变相模拟在日期控件上进行选择了
        WebElement dateInputBox = driver.findElement(By.id("datepicker"));
        dateInputBox.sendKeys("08/29/2017");
        Thread.sleep(5000);
    }

}
