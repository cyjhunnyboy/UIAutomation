package per.cyj.selenium.datadriven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 数据驱动测试
 * @since 2019-08-10
 */
public class _04DataDrivenByMysqlDatabaseTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    /**
     * 使用注解 DataProvider，将数据集合命名为“testData”
     *
     * @return object[][]
     */
    @DataProvider(name = "testData")
    public static Object[][] words() {
        // 调用类中的静态方法 getTestData，获取 MySQL 数据库中的测试数据
        return getTestData("testdata");
    }

    /**
     * 使用 MySQL 数据库实现数据驱动测试
     * （1）打开sogou首页
     * （2）从数据库测试数据表中读取每行数据的前两列数据作为进行搜索的两个词汇
     * （3）单击搜索按钮
     * （4）断言搜索结果页面是否包含数据库测试数据表中每行数据的第三列数据内容，包含则认为测试执行成功，否则认为测试执行失败
     */
    @Test(dataProvider = "testData", description = "使用 MySQL 数据库实现数据驱动测试 ")
    public void testSearch(String searcheWord1, String searchWord2, String searchResult) {
        // 设置等待时间为10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // 浏览器最大化
        driver.navigate().to(baseUrl); // 访问sogou首页
        // 使用数据库测试数据表中每个数据行的前两列数据作为搜索词，在两个搜索词中间增加一个空格
        driver.findElement(By.id("query")).sendKeys(searcheWord1 + " " + searchWord2);
        driver.findElement(By.id("stb")).click(); // 单击搜索按钮
        // 使用显示等待方式，确认页面已经加载完成，页面底部的关键字
        // “相关搜索”已经显示在页面上
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>)
                d -> d.findElement(By.xpath("//table[@id='hint_container']/caption")).getText().contains("相关搜索"));
        // 在数据库数据表中每行前两列数据作为搜索词汇的情况下，断言搜索结果页面是否包含每个数据行第三列数据
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
    }


    /**
     * 从数据库中数据表获取测试数据的静态方法
     *
     * @param tableName 表名
     * @return object[][]
     */
    public static Object[][] getTestData(String tableName) {
        // 声明 MySQL 数据库的驱动
        String mySqlDriver = "com.mysql.jdbc.Driver";
        // 声明本地数据库的 IP 地址和数据库名称
        String url = "jdbc:mysql://192.168.126.128:3306/selenium";
        // 声明数据库的用户名。为简化数据库权限设定等操作，本地使用数据库的 root 用户进行操作
        // 在正式对外的生产数据库中，建议使用非 root 的用户账户进行自动化测试的相关操作
        String user = "root";
        // 声明数据库 root 用户名的登录密码，这和 MySQL 数据库安装时设定的 root 用户密码要保持一致
        String password = "root";
        // 声明存储测试数据的 list 对象
        List<Object[]> records = new ArrayList<>();
        try {
            // 设定驱动
            Class.forName(mySqlDriver);
            // 声明连接数据库的链接对象，使用数据库服务地址、用户名和密码作为参数
            Connection connection = DriverManager.getConnection(url, user, password);
            // 如果数据库链接可用，打印数据库连接成功的信息
            if (!connection.isClosed())
                System.out.println("连接数据库成功！");
            // 创建 statement 对象
            Statement statement = connection.createStatement();
            // 使用函数参数拼接要执行的 SQL 语句，此语句用来获取数据表的所有数据行
            String sql = "select * from " + tableName;
            // 声明 ResultSet 对象，存储执行 SQL 语句后返回的数据结果集
            ResultSet resultSet = statement.executeQuery(sql);
            // 声明一个 ResultSetMetaData 对象
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            // 调用 ResultSetMetaData 对象的 getColumnCount 方法获取数据行的列数
            int cols = resultSetMetaData.getColumnCount();
            // 使用 next 方法遍历数据结果集中的所有数据行
            while (resultSet.next()) {
                // 声明一个字符型数据，数组大小使用数据行的列个数进行声明
                String fields[] = new String[cols];
                int col = 0;
                // 遍历所有数据行中的所有列数据，并存储在字符数据中
                for (int colIndex = 1; colIndex < cols + 1; colIndex++) {
                    fields[col] = resultSet.getString(colIndex);
                    col++;
                }
                // 将每一行的数据存储到字符数据后，存储到 records 中
                records.add(fields);
                // 输出数据行中的前三列内容，用于验证数据库内容是否正确取出
                System.out.println(resultSet.getString(1) + "  "
                        + resultSet.getString(2) + "  " + resultSet.getString(3));
            }
            // 关闭数据库连接
            resultSet.close();
        } catch (ClassNotFoundException e) {
            System.out.println("未能找到 MySQL 的驱动类");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 定义函数返回值，即 Object[][]
        // 将存储测试数据的 list 转换为一个 Object[][] 的二维数据
        Object[][] results = new Object[records.size()][];
        // 设置二维数据每行的值，每行是一个 Object 对象
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }

}
