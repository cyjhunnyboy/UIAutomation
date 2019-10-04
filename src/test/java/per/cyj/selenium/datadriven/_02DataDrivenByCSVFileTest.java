package per.cyj.selenium.datadriven;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 数据驱动测试
 * @since 2019-08-10
 */
public class _02DataDrivenByCSVFileTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    /**
     * 使用注解 DataProvider，将数据集合命名为“testData”
     *
     * @return object[][]
     */
    @DataProvider(name = "testData")
    public static Object[][] words() throws IOException {
        // 调用类中的静态方法 getTestData，获取csv文件中测试数据
        return getTestData("E:\\selenium\\testData.csv");
    }

    /**
     * 使用TesgNG和CVS文件进行数据驱动
     * （1）打开sogou首页
     * （2）从CVS文件中读取每行中前两个逗号分隔的中文词作为搜索输入框的搜索关键词，两个关键词中间带有一个空格
     * （3）单击搜索按钮
     * （4）断言搜索结果页面是否包含CVS文件中每行的第三个词汇，包含则认为测试执行成功，否则认为测试执行失败
     */
    @Test(dataProvider = "testData", description = "使用TesgNG和CVS文件进行数据驱动")
    public void testSearche(String searcheWord1, String searchWord2, String searchResult) {
        // 设置等待时间为10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // 浏览器最大化
        driver.navigate().to(baseUrl); // 访问sogou首页
        // 使用 csv 文件中每个数据行的前两个词汇作为搜索词，在两个搜索词中间增加一个空格
        driver.findElement(By.id("query")).sendKeys(searcheWord1 + " " + searchWord2);
        driver.findElement(By.id("stb")).click(); // 单击搜索按钮
        // 使用显示等待方式，确认页面已经加载完成，页面底部的关键字
        // “全部时间”已经显示在页面上
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>)
                driver -> driver.findElement(By.xpath("//a[@class='all-time']")).getText().contains("全部时间"));
        // cvs文件每行前两个词汇作为搜索词汇的情况下，断言搜索结果页面是否包含cvs文件每行
        // 中的最后一个词汇的关键字
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
    }

    /**
     * 读取 CVS 文件的静态方法，使用 CVS 文件的绝对文件路径作为函数参数
     *
     * @param fileName 文件名称
     * @return result
     * @throws IOException 抛出异常
     */
    public static Object[][] getTestData(String fileName) throws IOException {
        List<Object> records = new ArrayList<>();
        String record;
        // 设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "gb2312"));
        // 忽略读取CVS文件的标题行（第一行）
        file.readLine();
        /*
         * 遍历读取文件中除第一行外的所有行内容 并存储到名为records的ArrayList中
         * 每一个records中存储的对象为一个String数组
         */
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        // 关闭文件对象
        file.close();
        // 定义函数返回值，即Object[][]
        // 将存储测试数据的 list 转换为一个 Object 的二维数据
        Object[][] results = new Object[records.size()][];
        // 设置二维数组每行的值，每行是一个Object对象
        for (int i = 0; i < records.size(); i++) {
            results[i] = (Object[]) records.get(i);
        }
        return results;
    }
}
