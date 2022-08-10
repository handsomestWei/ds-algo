package com.wjy.dsalgo.diffarray;

/**
 * @author weijiayu
 * @date 2022/8/10 11:42
 */
public class DiffArrayTest {

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9, 11};
        DiffArray diffArray = new DiffArray(data);
        diffArray.addByScope(2, 4, 1);
        System.out.println(diffArray.get(2));

        for (int i : diffArray.getArray()) {
            System.out.println(i);
        }
    }
}
