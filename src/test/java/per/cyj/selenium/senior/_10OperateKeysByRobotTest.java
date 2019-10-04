package per.cyj.selenium.senior;

import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote WebDriver的高级应用实例
 * @since 2019-08-12
 */
public class _10OperateKeysByRobotTest extends BaseTest {

    private String baseUrl = "http://www.sogou.com/";

    @Test(description = "能通过Robot对象操作键盘上的按键完成复制、粘贴、切换焦点和回车等常用操作")
    public void testOperateKeysByRobot() throws Exception {
        driver.navigate().to(baseUrl); // 访问被测试的网页
        String searchString = "光荣之路自动化测试";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // 使用显示等待，判断页面是否显示搜索框
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("query")));
        // 调用封装好的函数setAndctrVClipboardData，将“光荣之路自动化测试”关键字
        // 使用Ctrl+V组合键方式粘贴到搜索框中
        setAndctrVClipboardData(searchString);
        Thread.sleep(2000);
        // 调用封装好的函数pressTabKey，按下Tab键，将焦点从搜索输入框转入到搜索按钮上
        pressTabKey();
        Thread.sleep(2000);
        // 调用封装好的函数pressEnterKey，按Enter键会触发搜索结果的提交
        pressEnterKey();
        Thread.sleep(3000);
    }

    /**
     * 封装的粘贴函数，可以将函数的string参数值放入到剪贴版本中，然后在使用Robot对象的
     * KeyPress和KeyRelease函数模拟Ctr+V组合件完成粘贴操作
     *
     * @param string 输入值
     */
    private void setAndctrVClipboardData(String string) {
        driver.findElement(By.id("query")).click(); // 获取搜索输入框焦点
        // 声明StringSelection对象，并使用函数的string参数完成实例化
        StringSelection stringSelection = new StringSelection(string);
        // 使用ToolKit对象的setContents方法将字符串放到剪贴板中
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        // 声明Robot对象
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // 调用KeyPress方法实现按下Ctrl键
        robot.keyPress(KeyEvent.VK_CONTROL);
        // 调用KeyPress方法实现按下V键
        robot.keyPress(KeyEvent.VK_V);
        // 调用KeyPress方法实现释放Ctrl键
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // 调用KeyPress方法实现释放V键
        robot.keyRelease(KeyEvent.VK_V);
    }

    /**
     * KeyPress和KeyRelease函数完成单击Tab键操作
     */
    private void pressTabKey() {
        // 声明Robot对象
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // 调用KeyPress方法实现按下Tab键
        robot.keyPress(KeyEvent.VK_TAB);
        // 调用KeyPress方法实现释放Tab键
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    /**
     * KeyPress和KeyRelease函数单击回车键操作
     */
    private void pressEnterKey() {
        // 声明Robot对象
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // 调用KeyPress方法实现按下Tab键
        robot.keyPress(KeyEvent.VK_ENTER);
        // 调用KeyPress方法实现释放Tab键
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

}
