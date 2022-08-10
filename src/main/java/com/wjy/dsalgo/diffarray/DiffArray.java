package com.wjy.dsalgo.diffarray;

/**
 * 差分数组。适用于多改少查的场景：区间频繁修改且区间范围较大，支持按索引查询
 * 
 * @author weijiayu
 * @date 2022/8/10 11:09
 */
public class DiffArray {

    // 原始数组
    private int[] data;
    // 差分数组
    private int[] diffData;

    public DiffArray(int[] data) {
        this.data = data;
        this.diffData = new int[data.length];
        this.diffData[0] = 0;
        for (int i = 1; i < data.length; i++) {
            this.diffData[i] = data[i] - data[i - 1];
        }
    }

    // 范围添加
    public void addByScope(int from, int to, int val) {
        // 只需更新差分数组头尾，不用遍历全部原始数组
        this.diffData[from] += val;
        this.diffData[to + 1] -= val;
    }

    // 随机读
    public int get(int index) {
        // 按索引随机读取时，需要遍历差分数组。因此适用多改少查的场景
        int val = data[0];
        for (int i = 0; i <= index; i++) {
            val += diffData[i];
        }
        return val;
    }

    // 获取当前数组
    public int[] getArray() {
        int[] rs = new int[data.length];
        rs[0] = data[0];
        for (int i = 1; i < data.length; i++) {
            rs[i] = rs[i - 1] + diffData[i];
        }
        return rs;
    }
}
