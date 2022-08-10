package com.wjy.dsalgo.adjtable;

/**
 * @author weijiayu
 * @date 2022/8/10 14:48
 */
public class AdjTableTest {

    public static void main(String[] args) {
        // 共7个节点
        int n = 7;
        // 边无向
        int[][] edges = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        // 节点4、5访问受限
        int[] restricted = {4, 5};

        AdjTable adjTable = new AdjTable(n, edges, restricted);
        // 只有节点[0,1,2,3]可以从节点0到达，总数是4
        System.out.println(adjTable.getReachVertexMaxNumFromRootCnt());
    }
}
