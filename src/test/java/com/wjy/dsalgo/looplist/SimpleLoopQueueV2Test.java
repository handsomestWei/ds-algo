package com.wjy.dsalgo.looplist;

import com.wjy.dsalgo.loopqueue.SimpleLoopQueueV2;

/**
 * @author weijiayu
 * @date 2022/8/15 15:21
 */
public class SimpleLoopQueueV2Test {

    public static void main(String[] args) {

        SimpleLoopQueueV2<Integer> loopQueue = new SimpleLoopQueueV2<>(3);
        System.out.println(loopQueue.insertLast(1)); // 返回true
        System.out.println(loopQueue.insertLast(2)); // 返回true
        System.out.println(loopQueue.insertFront(3)); // 返回true
        System.out.println(loopQueue.insertFront(4)); // 已经满了，返回false
        System.out.println(loopQueue.getRear()); // 返回2
        System.out.println(loopQueue.isFull()); // 已经满了，返回true
        System.out.println(loopQueue.getFront()); // 返回4
    }
}
