package com.wjy.dsalgo.diffarray;

/**
 * @author weijiayu
 * @date 2023/1/31 17:08
 */
public class TwoDDiffArrayTest {

    public static void main(String[] args) {
        TwoDDiffArray twoDDiffArray = new TwoDDiffArray(3, 3);
        // 区间[1,1,2,2]和[0,0,1,1]都加1，输出[[1,1,0],[1,2,1],[0,1,1]]
        twoDDiffArray.addByScope(1, 1, 2, 2, 1);
        twoDDiffArray.addByScope(0, 0, 1, 1, 1);
        print2DArray(twoDDiffArray.getCurrent());

        System.out.println();

        twoDDiffArray = new TwoDDiffArray(new int[][] {{1, 2, 3}, {0, 0, 0}, {4, 6, 8}});
        // 区间[1,1,2,2]和[0,0,1,1]都加1，输出[[2,3,3],[1,2,1],[4,7,9]]
        twoDDiffArray.addByScope(1, 1, 2, 2, 1);
        twoDDiffArray.addByScope(0, 0, 1, 1, 1);
        print2DArray(twoDDiffArray.getCurrent());
    }

    private static void print2DArray(int[][] data) {
        for (int[] arr : data) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}
