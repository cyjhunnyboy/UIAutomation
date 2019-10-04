package per.cyj.selenium.datadriven;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 数据驱动测试
 * @since 2019-08-10
 */
public class _01DataProviderTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    @DataProvider(name = "searchWords")
    public static Object[][] words() {
        return new Object[][]{
                {"蝙蝠侠", "主演", "迈克尔"},
                {"超人", "导演", "唐纳"},
                {"生化危机", "编剧", "安德森"}
        };
    }

    /**
     * 使用TesgNG进行数据驱动：
     * （1）打开sogou首页
     * （2）在搜索输入框输入两个搜索关键词
     * （3）单击搜索按钮
     * （4）验证搜索结果页面是否包含搜索两个关键词，包含则认为测试执行成功，否则认为测试执行失败
     *
     * @throws InterruptedException 抛出异常
     */
    @Test(dataProvider = "searchWords", description = " 使用TesgNG进行数据驱动")
    public void testSearch(String searcheWord1, String searchWord2, String searchResult)
            throws InterruptedException {
        // 设置等待时间为10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(baseUrl); // 访问sogou首页
        // 在搜索输入框中输入搜索关键词
        driver.findElement(By.id("query")).sendKeys(searcheWord1 + " " + searchWord2);
        driver.findElement(By.id("stb")).click();
        // 单击搜索按钮按钮，等待3秒中显示搜索结果
        Thread.sleep(3000);
        // 判断搜索结果的页面是否包含测试数据中期望的关键词
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
    }
}
