package per.cyj.selenium.util;

import org.apache.log4j.Logger;

/**
 * @author ucs_chenyongjun
 * @apiNote 日志工具类
 * @since 2019-08-12
 */
public class Log {

    // 初始化一个Log对象
    private static Logger log = Logger.getLogger(Log.class.getName());

    // 定义一个静态方法，可以打印自定义的某个测试用例开始执行的日志信息
    public static void startTestCase(String testCaseName) {
        log.info("-------------------------------------------------------------");
        log.info("************      " + testCaseName + "测试用例开始执行      ************");
    }

    // 定义一个静态方法，可以打印自定义的某个测试用例结束执行的日志信息
    public static void endTestCase(String testCaseName) {
        log.info("-------------------------------------------------------------");
        log.info("************      " + testCaseName + "测试用例执行结束" + "      ************");
    }

    // 定义一个静态 info 方法，打印自定义的 info 级别日志信息
    public static void info(String message) {
        log.info(message);
    }

    // 定义一个静态 warn 方法，打印自定义的 warn 级别日志信息
    public static void warn(String message) {
        log.warn(message);
    }

    // 定义一个静态 error 方法，打印自定义的 error 级别日志信息
    public static void error(String message) {
        log.error(message);
    }

    // 定义一个静态 fatal 方法，打印自定义的 fatal 级别日志信息
    public static void fatal(String message) {
        log.fatal(message);
    }

    // 定义一个静态 debug 方法，打印自定义的 debug 级别日志信息
    public static void debug(String message) {
        log.debug(message);
    }

}
