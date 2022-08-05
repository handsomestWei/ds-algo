package com.wjy.dsalgo.loopqueue;

/**
 * 简单的固定长度循环队列实现https://leetcode.cn/problems/design-circular-queue/
 * 
 * @author weijiayu
 * @date 2022/8/5 9:45
 */
public class SimpleLoopQueue<T> {

    private int capacity;
    private int currentCap;
    private Node<T> head;
    private Node<T> tail;

    public SimpleLoopQueue(int k) {
        // 队列长度初始化
        capacity = k;
    }

    // 队尾插入元素
    public boolean enQueue(T value) {
        if (currentCap >= capacity) {
            // 队列已满，返回插入失败
            return false;
        }
        Node node = new Node();
        node.val = value;
        if (currentCap == 0) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        currentCap++;
        return true;
    }

    // 从队头删除元素，先进先出
    public boolean deQueue() {
        if (currentCap == 0) {
            return false;
        }
        head = head.next;
        currentCap--;
        return true;
    }

    // 返回队头元素
    public T Front() {
        return currentCap == 0 ? null : head.val;
    }

    // 返回队尾元素
    public T Rear() {
        return currentCap == 0 ? null : tail.val;
    }

    // 队列是否为空
    public boolean isEmpty() {
        return currentCap == 0;
    }

    // 队列是否已满
    public boolean isFull() {
        return currentCap == capacity;
    }

    // 队列节点
    private class Node<T> {
        private T val;
        private Node next;
    }

}
