package me.yangyong;

/**
 * Swap the two variable values without temporary variable
 * <p>
 * 加减 异或 互逆运算
 * 
 * @author yangyong
 * @since 2015-4-30
 */
public class SwapVar {

    public static void swapVarXor() {
        int a = 1, b = 2;

        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println("a:" + a + " b:" + b);
    }

    public static void swapVarSum() {
        int a = 1, b = 2;

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a:" + a + " b:" + b);
    }

    public static void main(String[] args) {
        swapVarSum();
        swapVarXor();
    }
}
