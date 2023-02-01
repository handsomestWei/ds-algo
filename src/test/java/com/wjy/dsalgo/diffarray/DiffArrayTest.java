package com.wjy.dsalgo.diffarray;

/**
 * @author weijiayu
 * @date 2022/8/10 11:42
 */
public class DiffArrayTest {

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9, 11};
        DiffArray diffArray = new DiffArray(data);
        // 区间[2,4]都加1，输出[1,3,6,8,10,11]
        diffArray.addByScope(2, 4, 1);
        System.out.println(diffArray.getCurrentElement(2));
        printArray(diffArray.getCurrent());
    }

    private static void printArray(int[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i : data) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
