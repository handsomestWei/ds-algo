package com.wjy.dsalgo.code;

/**
 * @author weijiayu
 * @date 2023/2/23 16:47
 */
public class GrayCodeTest {

    public static void main(String[] args) {
        // 从0开始，输出[0,1,3,2]，对应二进制表示[00,01,11,10]
        System.out.println(GrayCode.getSeriesCode(0, 2));
        // 从3开始，输出[3,2,0,1]，对应二进制表示[11,10,00,01]
        System.out.println(GrayCode.getSeriesCode(3, 2));
    }
}
