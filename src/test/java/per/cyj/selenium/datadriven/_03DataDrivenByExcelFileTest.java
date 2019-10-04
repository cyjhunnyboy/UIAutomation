package per.cyj.selenium.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import per.cyj.selenium.BaseTest;

/**
 * @author chenyongjun
 * @apiNote 数据驱动测试
 * @since 2019-08-10
 */
public class _03DataDrivenByExcelFileTest extends BaseTest {

    private String baseUrl = "https://www.sogou.com/";

    /**
     * 使用注解 DataProvider，将数据集合命名为“testData”
     *
     * @return object[][]
     */
    @DataProvider(name = "testData")
    public static Object[][] words() throws IOException {
        // 调用类中的静态方法 getTestData，获取 Excel 文件中测试数据
        return getTestData("E:\\selenium", "testData.xlsx", "sheet1");
    }

    /**
     * 使用TesgNG、Apache POI和Excel文件进行数据驱动测试
     * （1）打开sogou首页
     * （2）从Excel文件中读取每行的前两个单元格内容作为进行搜索的两个词汇
     * （3）单击搜索按钮
     * （4）断言搜索结果页面是否包含Excel文件中每行的第三个单元格内容，包含则认为测试执行成功，否则认为测试执行失败
     */
    @Test(dataProvider = "testData", description = "使用TesgNG、Apache POI和Excel文件进行数据驱动测试")
    public void testSearch(String searcheWord1, String searchWord2, String searchResult) {
        // 设置等待时间为10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // 浏览器最大化
        driver.navigate().to(baseUrl); // 访问sogou首页
        // 使用 Excel 文件中每行前两个单元格内容作为搜索词，在两个搜索词中间增加一个空格
        driver.findElement(By.id("query")).sendKeys(searcheWord1 + " " + searchWord2);
        driver.findElement(By.id("stb")).click(); // 单击搜索按钮
        // 使用显示等待方式，确认页面已经加载完成，页面底部的关键字
        // “相关搜索”已经显示在页面上
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>)
                d -> d.findElement(By.xpath("//table[@id='hint_container']/caption")).getText().contains("相关搜索"));
        // 在 Exce l文件每行前两个单元格内容作为搜索词汇的情况下，断言搜索结果页面是否包含Excel文件每行
        // 中的第三个单元格内容的关键字
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
    }

    /**
     * 从Excel文件获取测试数据的静态方法
     *
     * @param filePath  文件路径
     * @param fileName  文件名
     * @param sheetName sheet名
     * @return result
     * @throws IOException 异常
     */
    public static Object[][] getTestData(String filePath, String fileName, String sheetName)
            throws IOException {
        // 根据参数传入的数据文件路径和文件名称，组合出 Excel 数据文件的绝对路径
        // 声明一个File对象
        File file = new File(filePath + "\\" + fileName);
        // 创建 FileInpuStream 对象用于读取 Excel 文件
        FileInputStream inputStream = new FileInputStream(file);
        // 声明 Workbook 对象
        Workbook workbook = null;
        // 获取文件名参数的扩展名，判断是 .xlsx，还是 .xls 文件
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        // 判断文件类型如果是 .xlsx，则使用 XSSFWorkbook 对象进行实例化
        // 判断文件类型如果是 .xls，则使用 SSFWorkbook 对象进行实例化
        if (fileExtensionName.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        // 通过 sheetName 参数，生产 Sheet 对象
        Sheet sheet = workbook.getSheet(sheetName);
        // 获取Excel数据文件 Sheet1 中数据的行数，getLastRowNum 方法获取数据的最后一行行号
        // getFirstRowNum 方法获取数据的第一行行号，相减之后算出数据的行数
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        // 创建名为 records 的 list 对象来存储从 Excel 数据文件读取的数据
        List<Object[]> records = new ArrayList<>();
        // 使用两个 for 循环遍历 Excel 数据文件的所有数据（除了第一行，第一行是数据列名称）
        // 所以 i 从 1 开始，而不是从 0 开始
        for (int i = 1; i < rowCount + 1; i++) {
            // 使用 getRow 方法获取行对象
            Row row = sheet.getRow(i);
            // 声明一个数组，用来存储 Excel 数据文件每行中的 3 个数据，数组的大小用
            // getLastCellNum 方法来进行动态声明，实现测试数据个数和数组大小一致
            String fields[] = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                String cellDataFormat = cell.getCellStyle().getDataFormatString();
                // 调用 getCell 和 getStringCellValue 方法获取 Excel 文件中的单元数据
                if ("yyyy/mm;@".equals(cellDataFormat) || "m/d/yy".equals(cellDataFormat)
                        || "yy/m/d".equals(cellDataFormat) || "mm/dd/yy".equals(cellDataFormat)
                        || "dd-mmm-yy".equals(cellDataFormat) || "yyyy/m/d".equals(cellDataFormat)) {
                    fields[j] = new SimpleDateFormat("YYYY-MM-DD").format(cell.getDateCellValue());
                } else {
                    fields[j] = row.getCell(j).getStringCellValue();
                }
            }
            // 将 fields 的数据对象存储到 records 的 list 中
            records.add(fields);
        }
        // 定义函数返回值，即Object[][]
        // 将存储测试数据的 list 转换为一个 Object 的二维数据
        Object[][] results = new Object[records.size()][];
        // 设置二维数组每行的值，每行是一个Object对象
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }
        return results;
    }
}
