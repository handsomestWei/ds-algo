package com.wjy.dsalgo.adjtable;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 无向图转换为邻接表。当一个图为稀疏图时，使用邻接矩阵浪费大量存储空间，而图的邻接表结合顺序存储+链式存储，大大减少了不必要浪费。https://leetcode.cn/problems/reachable-nodes-with-restrictions/
 * 
 * @author weijiayu
 * @date 2022/8/10 11:54
 */
public class AdjTable {

    // 无向图的邻接表
    private List<Integer>[] adjList;
    // 在不访问受限节点的前提下，从节点0到达的最多节点数目
    private int reachVertexMaxNumFromRootCnt;

    // 节点数n，边数组edges，访问受限节点restricted
    public AdjTable(int n, int[][] edges, int[] restricted) {
        adjList = buildAdjTable(n, edges, restricted);
        reachVertexMaxNumFromRootCnt = cntReachVertexMaxNumFromRoot(n, adjList, restricted);
    }

    public int getReachVertexMaxNumFromRootCnt() {
        return reachVertexMaxNumFromRootCnt;
    }

    private List<Integer>[] buildAdjTable(int n, int[][] edges, int[] restricted) {
        // 初始化邻接表
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }
        // 邻接表建无向图
        for (int[] edge : edges) {
            // 因为无向，所以添加两次
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        // 已访问节点标记
        boolean[] visitedArray = new boolean[n];
        if (restricted != null) {
            for (int restrictedNum : restricted) {
                // 将受阻的节点提前标记为已访问
                visitedArray[restrictedNum] = true;
            }
        }
        return adjList;
    }

    // 在不访问受限节点的前提下，计算从节点0到达的最多节点数目。
    private int cntReachVertexMaxNumFromRoot(int n, List<Integer>[] adjList, int[] restricted) {
        // 已访问节点标记
        boolean[] visitedArray = new boolean[n];
        if (restricted != null) {
            for (int restrictedNum : restricted) {
                // 将受阻的节点提前标记为已访问
                visitedArray[restrictedNum] = true;
            }
        }

        // 遍历邻接表
        Deque<Integer> visitQue = new LinkedList<>();
        visitQue.addLast(0);
        visitedArray[0] = true;
        int cnt = 1;
        while (!visitQue.isEmpty()) {
            Integer node = visitQue.pollFirst();
            // BFS广度优先
            for (int adjNode : adjList[node]) {
                if (visitedArray[adjNode] != true) {
                    // 当前节点的所有未被访问的邻接点入队
                    visitQue.addLast(adjNode);
                    cnt++;
                    visitedArray[adjNode] = true;
                }
            }
        }
        return cnt;
    }

}
