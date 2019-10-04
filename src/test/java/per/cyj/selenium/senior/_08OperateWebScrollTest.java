package per.cyj.selenium.senior;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-11
 */
public class _08OperateWebScrollTest extends BaseTest {

    private String baseUrl = "http://v.sogou.com/";

    @Test(description = "操作Web页面滚动条 将页面滚动条滑动到页面底部", priority = 1) // 表示测试用例以第一优先级运行
    public void scrollToBottomOfPage() throws Exception {
        driver.navigate().to(baseUrl);
        // 使用JavaScript的srcollTo函数和document.body.scrollHeight参数将页面的滚动条滑动到页面的最下方
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
    }

    @Test(description = "操作Web页面的滚动条 将页面的滚动条滑动到制定元素位置", priority = 2) // 表示测试用例以第二优先级运行
    public void scrollToElementOfPage() throws Exception {
        driver.navigate().to(baseUrl);
        // 进入搜索视频页面，找到ID为main_frame的frame页面
        driver.switchTo().frame("main_frame");
        // 定位frame页面中h2标签元素，且标签文字为“电视剧分类”
        WebElement element = driver.findElement(By.xpath("//h2[text()='电视剧分类']"));
        // 是有JavaScript的scrollIntoView函数将滚动条滑动到页面制定的元素位置
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
        Thread.sleep(3000);
    }

    @Test(description = "操作Web页面的滚动条 以制定像素滑动页面滚动条", priority = 3) // 表示测试用例以第三优先级运行
    public void scrollByCoordinatesOfPage() throws Exception {
        driver.navigate().to(baseUrl);
        // 使用JavaScript的scrollBy函数，使用0和800的横纵坐标参数将页面的滚动条纵向下滑800像素
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(8,800)");
        Thread.sleep(3000);
    }

}
