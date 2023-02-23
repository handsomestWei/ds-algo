package com.wjy.dsalgo.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷码，又叫循环二进制码或反射二进制码，常用于通信领域的模拟－数字转换和位置－数字转换中。在数字电路中，格雷码每次的变换只会有一个二进制位的跳变，极大地减少了亚稳态的产生，保证电路的稳定性，受到了广泛的应用。参考https://leetcode.cn/problems/gray-code/和https://leetcode.cn/problems/circular-permutation-in-binary-representation/
 * 
 * @author weijiayu
 * @date 2023/2/23 16:33
 */
public class GrayCode {

    // 从指定start值开始，返回(0,1,2,,...,2^n-1)的排列，相邻的数只有一位二进制位不同
    public static List<Integer> getSeriesCode(int start, int powerN) {
        int maxVal = (int)Math.pow(2, powerN);
        List<Integer> rs = new ArrayList<>(maxVal);
        // 递增遍历，利用格雷码特性，相邻两数的格雷码二进制只有一位不同
        for (int i = 0; i < maxVal; i++) {
            // 求格雷码
            int grayCode = getCodeV2(i);
            // 对start做异或，保证格雷码顺序以start值为起点
            // 相当于从0开始编码回环一次：例[0, 1, 3, 2] + [0, 1, 3, 2] => 从3开始，跳过[0, 1]取后面的[3, 2, 0, 1]
            rs.add(start ^ grayCode);
        }

        return rs;
    }

    // 指定最大有效位宽，不用遍历全部32bit整数
    public static int getCodeV1(int val, int bitWidth) {
        int newVal = 0;
        // 最高位不变
        for (int i = 0; i < bitWidth; i++) {
            // 使用&与运算求指定位的值
            // 第i位值
            int currentBitVal = val & (1 << i);
            // 第i+1位值
            int nextBitVal = val & (1 << (i + 1));
            // 求第i位新值，按格雷码转换公式求异或。第i+1位值高1位需要右移
            int newBitVal = currentBitVal ^ (nextBitVal >> 1);
            // 对指定位赋新值
            newVal += newBitVal;
        }
        return newVal;
    }

    public static int getCodeV2(int val) {
        // 由于每位都是错位异或赋新值，可以优化为对原数右移一位再做整体异或运算
        return val ^ (val >> 1);
    }
}
