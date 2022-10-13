package com.wjy.dsalgo.sum;

/**
 * @author weijiayu
 * @date 2022/10/13 16:37
 */
public class KahanSumTest {

    public static void main(String[] args) {

        int len = 20000000;
        float[] dataArr = new float[len];
        for (int i = 0; i < len; i++) {
            dataArr[i] = 1.0f;
        }

        // 20万个1.0累加
        // 精度丢失
        System.out.println("normalSum=" + normalSum(dataArr));
        // 精度不丢失
        System.out.println("KahanSum=" + KahanSum.sum(dataArr));
    }

    // 普通循环累加
    private static float normalSum(float[] dataArr) {
        float sum = 0.0f;
        for (int i = 0; i < dataArr.length; i++) {
            sum += dataArr[i];
        }
        return sum;
    }
}
