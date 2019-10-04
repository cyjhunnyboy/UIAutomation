package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
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
public class _13OperateDropListTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/select.html";

    @Test(description = "操作单选下拉列表")
    public void testOperateDropList() throws Exception {

        driver.navigate().to(baseUrl);
        // 使用name属性找到页面上name属性为“fruit”的下拉列表元素
        Select dropList = new Select(driver.findElement(By.name("fruit")));
        // isMultiple表示此下拉列表是否允许多选，被测试网页是一个单选下拉列表，所以此函数返回结果是false
        Assert.assertFalse(dropList.isMultiple());
        // getFirstSelectedOption().getText()方法表示获取当前被选中的下拉列表选项文本
        // Assert.assertEquals方法断言当前被选中的文本是否是“桃子”
        Assert.assertEquals(dropList.getFirstSelectedOption().getText(), "桃子");
        Thread.sleep(1000);
        // selectByIndex方法表示选中下拉列表第四个选项，即“猕猴桃”选项，0表示第一个选项
        dropList.selectByIndex(3);
        Assert.assertEquals(dropList.getFirstSelectedOption().getText(), "猕猴桃");
        Thread.sleep(1000);
        // selectByValue方法表示使用下拉列表选项的value属性值进行选中操作 “shanzha”是选项山楂value的属性值
        dropList.selectByValue("shanzha");
        Assert.assertEquals(dropList.getFirstSelectedOption().getText(), "山楂");
        Thread.sleep(1000);
        // selectByVisibleText方法表示通过选项的文字进行选中
        dropList.selectByVisibleText("荔枝");
        Assert.assertEquals(dropList.getFirstSelectedOption().getText(), "荔枝");
        Thread.sleep(1000);
        log.info("执行用例{}成功！", "testOperateDropList()");
    }

}
