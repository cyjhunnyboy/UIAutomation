package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 这是一个表格定位测试类
 * @since 2019-07-30
 */
@Slf4j
public class TableCellTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/table.html";

    @Test(description = "通过XPath来定位表格中的某个单元格", groups = {"元素定位方式"})
    public void testTableCellByXPath() throws Exception {
        log.info("xpath定位表格中的某个单元格：By.xpath('//*[@id='table']/tbody/tr[2]/td[2]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 通过XPath来定位第二行第二列单元格
        WebElement cell = driver.findElement(By.xpath("//*[@id='table']/tbody/tr[2]/td[2]"));
        Assert.assertTrue(cell.isDisplayed());
        System.out.println(cell.getText());
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testTableCellByXPath"));
    }

    @Test(description = "通过css表达式来定位表格中的某个单元格", groups = {"元素定位方式"})
    public void testTableCellByCss() throws Exception {
        log.info("css定位表格中的某个单元格：By.cssSelector('table#table>tbody>tr:nth-child[2]>td:nth-child[2]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 绝对路径：By.cssSelector("html body table#table tbody tr:nth-child(2) td:nth-child(2)")
        // 绝对路径：By.cssSelector("html>body>table#table>tbody>tr:nth-child(2)>td:nth-child(2)")
        // 相对路径：By.cssSelector("table#table tbody tr:nth-child(2) td:nth-child(2)")
        // 相对路径：By.cssSelector("table#table>tbody>tr:nth-child(2)>td:nth-child(2)")
        WebElement cell = driver.findElement(By.cssSelector("table#table>tbody>tr:nth-child(2)>td:nth-child(2)"));
        Assert.assertTrue(cell.isDisplayed());
        System.out.println(cell.getText());
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testTableCellByCss"));
    }

}
