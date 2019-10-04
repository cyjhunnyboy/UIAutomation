package per.cyj.selenium.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author chenyongjun
 * @apiNote 计数器测试类
 * @since 2019-07-30
 */
public class CalculatorTest {

    private static Calculator calculator = new Calculator();

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("@BeforClass");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("@AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("测试开始");
    }

    @After
    public void tearDown() {
        System.out.println("测试结束");
    }

    @Test
    public void testAdd() {
        calculator.add(2, 2);
        assertEquals(4, calculator.getResult());
        // fail("Not yet implemented");
    }

    @Test
    public void testSubstract() {
        calculator.substract(4, 2);
        assertEquals(2, calculator.getResult());
    }

    @Ignore
    public void testMultiply() {
        fail("Not yet implemented");
    }

    @Test(timeout = 2000)
    public void testDivide() {
        for (; ; )
            ;
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(4, 0);
    }
}
