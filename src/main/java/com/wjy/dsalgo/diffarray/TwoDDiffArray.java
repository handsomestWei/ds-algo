package com.wjy.dsalgo.diffarray;

/**
 * 二维差分数组。前缀和与差分是一对互逆运算，对差分数组求前缀和可以还原得到原数组。差分可以将在原序列上的区间操作，转化为差分序列上的单点操作。参考https://leetcode.cn/problems/increment-submatrices-by-one/
 * 
 * @author weijiayu
 * @date 2023/1/31 15:59
 */
public class TwoDDiffArray {

    // 原始数组
    private int[][] originData;
    // 差分数组
    private int[][] diffData;
    // 行数
    private int m = 0;
    // 列数
    private int n = 0;

    // 初始化0
    public TwoDDiffArray(int m, int n) {
        this.m = m;
        this.n = n;
        this.originData = new int[this.m][this.n];
        // 差分数组区间+1，d[n+1] = 0 - a[n]
        this.diffData = new int[this.m + 1][this.n + 1];
    }

    // 有初始值
    public TwoDDiffArray(int[][] data) {
        this.m = data.length;
        this.n = data[0].length;
        this.originData = data;
        // 计算二维数组的差分数组，区间+1，d[n+1] = 0 - a[n]
        this.diffData = new int[this.m + 1][this.n + 1];
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                // 每个元素当作一次范围添加
                addByScope(i, j, i, j, originData[i][j]);
            }
        }
    }

    // 范围添加
    public void addByScope(int row1, int col1, int row2, int col2, int val) {
        // 只需更新差分数组矩阵四个角，不用遍历全部原始数组
        this.diffData[row1][col1] += val;
        this.diffData[row2 + 1][col1] -= val;
        this.diffData[row1][col2 + 1] -= val;
        this.diffData[row2 + 1][col2 + 1] += val;
    }

    // 获取当前值
    public int[][] getCurrent() {
        int[][] rs = new int[m][n];
        // 求二维数组前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 边界判断
                if (i == 0 && j == 0) {
                    rs[i][j] = diffData[0][0];
                } else if (i == 0 && j != 0) {
                    rs[i][j] = rs[0][j - 1] + diffData[i][j];
                } else if (i != 0 && j == 0) {
                    rs[i][j] = rs[i - 1][0] + diffData[i][j];
                } else {
                    // 四格范围，左、上、左上角，以及差分
                    rs[i][j] = rs[i - 1][j] + rs[i][j - 1] - rs[i - 1][j - 1] + diffData[i][j];
                }
            }
        }
        return rs;
    }

}
