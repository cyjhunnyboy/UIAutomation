package per.cyj.selenium.util;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author chenyongjun
 * @apiNote 封装操作表格的公用类 能够使用自己编写操作表格的公用类，并基于公用类进行表格的各类操作
 * @since 2019-08-13
 */
public class Table {

    /**
     * 声明一个WebElement对象，用于存储页面的表格元素对象
     */
    private WebElement table;

    /**
     * 为构造函数传入页面表格对象参数
     *
     * @param table table元素
     */
    public Table(WebElement table) {
        this.table = table;
    }

    /**
     * 获取表格元素的行数，查找表格元素有几个tr元素 有几个tr元素， 就可以知道表格有几行，tr数量和表格行数相一致
     *
     * @return size of table rows
     */
    public int getRowCount() {
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        return tableRows.size();
    }

    /**
     * 获取表格元素的列数，使用get(0)从容器中取出表格第一行的元素，查找有几个“td” td数量和列数一致
     *
     * @return size of table column
     */
    public int getColumnCount() {
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));
        return tableRows.get(0).findElements(By.tagName("td")).size();
    }

    /**
     * 获取表格中某行某列的单元对象
     *
     * @param rowNo 行数
     * @param colNo 列数
     * @return cell 单元格
     * @throws NoSuchElementException 元素找不到异常
     */
    public WebElement getCell(int rowNo, int colNo) throws NoSuchElementException {
        try {
            List<WebElement> tableRows = table.findElements(By.tagName("tr"));
            System.out.println("行总数：" + tableRows.size());
            System.out.println("行号：" + rowNo);
            WebElement currentRow = tableRows.get(rowNo - 1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            System.out.println("列总数：" + tableCols.size());
            WebElement cell = tableCols.get(colNo - 1);
            System.out.println("列号：" + colNo);
            return cell;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("没有找到相关的元素");
        }
    }

    /**
     * 获取单元格中的元素对象
     *
     * @param rowNo 行数
     * @param colNo 列数
     * @param by    定位方式
     * @return WebElement元素
     * @throws NoSuchElementException 元素找不到异常
     */
    public WebElement getWebElementInCell(int rowNo, int colNo, By by) throws NoSuchElementException {
        try {
            List<WebElement> tableRows = table.findElements(By.tagName("tr"));
            // 找到表格中的某一行，因为行号是从0开始
            // 例如要找第三行，则需要进行3-1的减法来获取第三行的行号，即2
            WebElement currentRow = tableRows.get(rowNo - 1);
            List<WebElement> tableCols = currentRow.findElements(By.tagName("td"));
            // 找到表格中的某一列，因为列号也是从0开始，所以要找到第三列，需要进行3-1的减法运算来
            // 获取第三列的列号，即2
            WebElement cell = tableCols.get(colNo - 1);
            return cell.findElement(by);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("没有找到相关的元素");
        }
    }

    /**
     * 获取页面表格对象的方法
     *
     * @return table
     */
    public WebElement getTable() {
        return table;
    }

    /**
     * 将页面表格元素赋值给Table类中的table成员变量的方法
     *
     * @param table 表格元素对象
     */
    public void setTable(WebElement table) {
        this.table = table;
    }
}
