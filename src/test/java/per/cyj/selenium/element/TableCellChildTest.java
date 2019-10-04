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
public class TableCellChildTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/table.html";

    @Test(description = "定位表格中的子元素", groups = {"元素定位方式"})
    public void testTableCellChild1() throws Exception {
        log.info("定位表格中的子元素：By.xpath('//td[contains(text(),'化妆')]/input[1]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 定位表格中第三行的第一个“面霜”复选框
        WebElement faceCream = driver.findElement(By.xpath("//td[contains(text(),'化妆')]/input[1]"));
        Assert.assertTrue(faceCream.isDisplayed());
        faceCream.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testTableCellChild1"));
    }

    @Test(description = "定位表格中的子元素", groups = {"元素定位方式"})
    public void testTableCellChild2() throws Exception {
        log.info("定位表格中的子元素：By.xpath('//td[contains(text(),'食物')]/descendant::input[2]')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        // 定位表格中第四行的第二个“蔬菜”复选框
        WebElement vegetables = driver.findElement(By.xpath("//td[contains(text(),'食物')]/descendant::input[2]"));
        Assert.assertTrue(vegetables.isDisplayed());
        vegetables.click();
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testTableCellChild2"));
    }

}
