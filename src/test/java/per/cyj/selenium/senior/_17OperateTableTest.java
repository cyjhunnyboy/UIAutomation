package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import per.cyj.selenium.BaseTest;
import per.cyj.selenium.util.Table;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _17OperateTableTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/table3.html";

    @Test(description = "调用封装的Table类，进行基于表格的各类操作")
    public void testTable() throws Exception {
        driver.navigate().to(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 获取被测试页面中的表格元素，并存储到webTable变量中
        WebElement webTable = driver.findElement(By.id("table"));
        // 使用wetTable进行Table实例化
        Table table = new Table(webTable);
        // 获取表格第三行第列单元格对象
        WebElement cell = table.getCell(3, 2);
        // 断言第三行第二列单元格对象中的文字是否和“第三行第二列”关键字相一致
        Assert.assertEquals(cell.getText(), "第三行第二列");
        // 获取表格中第三行第二列单元格中的输入框对象
        WebElement cellInput = table.getWebElementInCell(3, 2, By.tagName("input"));
        // 在输入框对象中输入关键字“第三行第二列表格被找到”
        cellInput.sendKeys("第三行第二列表格被找到");
        Thread.sleep(3000);
    }

}
