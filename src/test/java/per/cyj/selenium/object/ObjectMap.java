package per.cyj.selenium.object;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;

/**
 * @author chenyongjun
 * @apiNote 对象库（UI Map) 目的：能够使用配置文件存储被测试页面上元素的定位方式和定位表达式，
 * 做到定位数据和程序的分离，测试程序写好以后，可以方便不具备编码能力的测试人员进行自定义修改和配置。
 * 此部分内容可以作为自定义的高级自动化框架的组成部分。
 * @since 2019-08-10
 */
public class ObjectMap {

    Properties properties;

    public ObjectMap(String propFile) {
        properties = new Properties();
        try {
            InputStream fileInputStream = getClass().getResourceAsStream(propFile);
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("读取对象文件错误");
            e.printStackTrace();
        }
    }

    public By getLocator(String elementName) throws Exception {
        // 根据变量 elementName，从属性配置文件中读取对应的配置对象
        String locator = properties.getProperty(elementName);
        // 将配置对象中的定位类型存储到locatorType变量，将定位表达式的值存储locatorValue变量中
        String locatorType = locator.split(":")[0];
        String locatorValue = locator.split(":")[1];
        // 输出locatorType变量值和locatorValue变量值，验证是否赋值正确
        System.out.println("获取的定位类型：" + locatorType + "\t获取的定位表达式：" + locatorValue);
        // 根据locatorType的变量值内容判断返回何种定位方式的By对象
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "classname":
            case "class":
                return By.className(locatorValue);
            case "tagname":
            case "tag":
                return By.tagName(locatorValue);
            case "linktext":
            case "link":
                return By.linkText(locatorValue);
            case "partiallinktext":
                return By.partialLinkText(locatorValue);
            case "cssselector":
            case "css":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            default:
                throw new Exception("输入的 locatorType 未在程序中被定义：" + locatorType);
        }
    }
}
