package per.cyj.selenium.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author chenyongjun
 * @apiNote 测试集合类
 * @since 2019-07-30
 */
@RunWith(Suite.class)
@SuiteClasses({CalculatorTest.class, Calculator2Test.class})
public class AllTests {

}
