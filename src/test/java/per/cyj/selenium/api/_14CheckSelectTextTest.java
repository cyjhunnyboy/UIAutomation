package per.cyj.selenium.api;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriverAPI常解
 * @since 2019-08-10
 */
@Slf4j
public class _14CheckSelectTextTest extends BaseTest {

    private String baseUrl = "http://192.168.126.128:8080/selenium/html/select.html";

    @Test(description = "检查单选列表的选项文字是否符合期望")
    public void testCheckSelectText() throws Exception {
        driver.navigate().to(baseUrl);
        Thread.sleep(1000);
        // 使用name属性找到页面上name属性为“fruit”的下拉列表元素
        WebElement element = driver.findElement(By.name("fruit"));
        Select dropList = new Select(element);
        Assert.assertFalse(dropList.isMultiple());
        // 声明一个list对象存储下拉列表中所有期望出现的选项文字，并且通过泛型<String>限定list
        // 对象中的存储对象类型是String，Arrays.asList表示将一个数组转换为一个list对象
        List<String> expectOptions = Arrays.asList(new String[]{"桃子", "西瓜", "橘子", "猕猴桃", "山楂", "荔枝", "苹果"});
        // 声明一个新list对象，用于存储从页面上获取的所有选项文字
        List<String> actualOptions = new ArrayList<>();
        // dropList.getOptions方法用于获取页面上下拉列表中的所有选项对象，actualOptions.add方法
        //用于将实际打开页面中的每个选项添加到actualOptions列表中
        for (WebElement option : dropList.getOptions())
            actualOptions.add(option.getText());
        // 断言期望对象和实际对象的数组是否完全一致
        Assert.assertEquals(expectOptions.toArray(), actualOptions.toArray());
        Thread.sleep(1000);
        log.info("执行{}用例成功！", "testCheckSelectText()");
    }

}
