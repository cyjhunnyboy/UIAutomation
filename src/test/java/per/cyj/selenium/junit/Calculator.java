package per.cyj.selenium.junit;

/**
 * @author chenyongjun
 * @apiNote 计数器
 * @since 2019-07-30
 */
public class Calculator {

    private int result = 0;

    public int add(int operandLeft, int operandRight) {
        // 将两个传入参数进行相加操作
        result = operandLeft + operandRight;
        return result;
    }

    public int substract(int operandLeft, int operandRight) {
        // 将两个传入参数进行相减操作
        result = operandLeft - operandRight;
        return result;
    }

    public int multiply(int operandLeft, int operandRight) {
        // 将两个传入参数进行相乘操作
        result = operandLeft * operandRight;
        // for循环：死循环
        for (; ; ) {
        }
    }

    public int divide(int operandLeft, int operandRight) {
        // 除数为零的除法操作
        result = operandLeft / 0;
        return result;
    }

    public int getResult() {
        // 返回计算结果
        return result;
    }
}
