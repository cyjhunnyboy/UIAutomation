package per.cyj.selenium.senior;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-10
 */
@Slf4j
public class _02AjaxDivOptionTest extends BaseTest {

    String baseUrl = "https://www.sogou.com/";

    @Test(description = "在Ajax方式产生的浮动框中，单击选择包含某个关键字的选项")
    public void testJavascriptExecutor() throws Exception {
        // 获取sogou首页上的搜索输入框
        WebElement searchInput = driver.findElement(By.id("query"));
        // 在sogou首页上的搜索输入框进行一次单击操作
        searchInput.click();
        Thread.sleep(2000);
        // 将浮动框中的所有选项存储到suggestionOptions的List容器中
        List<WebElement> suggestionOptions = driver.findElements(By.xpath("//*[@id='vl']/div/ul/li"));
        // 使用for循环遍历容器中所有选项，判断如果某个选项包含“关荣之路自动化测试”这几个关键字，
        // 则对这个选项进行单击操作。单击选项的文字内容会显示在搜索框中，并进行搜索
        if (!suggestionOptions.isEmpty()) {
            for (WebElement element : suggestionOptions) {
                // 打印List中element的文本内容
                log.info("element元素文本信息是：{}", element.getText());
                if (element.getText().contains("光荣之路自动化测试")) {
                    element.click();
                    break;
                }
            }
        }
        // 查找浮动框中的第一个选项，并保存在suggestionOption变量中
        WebElement suggestionOption = driver.findElement(By.xpath("//*[@id='vl']/div[1]/ul/li[1]"));
        // 单击浮动框中第一个选项
        suggestionOption.click();
        Thread.sleep(3000);
    }

}
