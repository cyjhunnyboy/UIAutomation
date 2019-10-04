package per.cyj.selenium.element;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import java.util.List;
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
public class TableErgodicTest extends BaseTest {

    private static final String BASE_URL = "http://192.168.126.128:8080/selenium/html/table.html";

    @Test(description = "遍历表格的全部单元格", groups = {"元素定位方式"})
    public void testTableErgodic() throws Exception {
        log.info("遍历表格的全部单元格：By.tagName('tr'); By.tagName('td')");
        driver.get(BASE_URL);
        Thread.sleep(1000);
        WebElement table = driver.findElement(By.id("table"));
        Assert.assertTrue(table.isDisplayed());
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        Assert.assertEquals(5, rows.size());
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.print("\n");
        }
        Thread.sleep(1000);
        log.info("执行用例{}成功！", this.getClass().getDeclaredMethod("testTableErgodic"));
    }

}
