package com.wjy.dsalgo.sum;

/**
 * Kahan求和算法，解决浮点数在大数累加过程中精度丢失问题
 * 
 * @author weijiayu
 * @date 2022/10/13 16:26
 */
public class KahanSum {

    public static float sum(float... dataArr) {
        float[] rs = new float[] {0.0f, 0.0f};
        for (float data : dataArr) {
            rs = sumWithDelta(rs[0], data, rs[1]);
        }
        return rs[0];
    }

    private static float[] sumWithDelta(float sum, float addData, float delta) {
        float[] rs = new float[2];
        // 求和时，指数位要对齐相加中较大的数，相加中较小的数的有效位要右移保证指数位和大数的一致，右移位数超过浮点数位数时，容易发生精度丢失
        // 用减法求丢失的值，后续求和时加回来。delta必为负数，所以用负号转换
        addData = addData + (-delta);
        float tmpSum = sum + addData;
        delta = tmpSum - sum - addData;
        rs[0] = tmpSum;
        rs[1] = delta;
        return rs;
    }
}
