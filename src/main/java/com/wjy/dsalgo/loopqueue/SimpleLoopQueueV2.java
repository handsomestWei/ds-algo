package com.wjy.dsalgo.loopqueue;

/**
 * 简单的循环双端队列实现https://leetcode.cn/problems/design-circular-deque/
 * 
 * @author weijiayu
 * @date 2022/8/15 15:18
 */
public class SimpleLoopQueueV2<T> {

    private int cap = 0;
    private int currentCap = 0;
    private Node<T> head;

    public SimpleLoopQueueV2(int k) {
        cap = k;
        currentCap = 0;
        head = null;
    }

    public boolean insertFront(T value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node();
        node.val = value;
        if (isEmpty()) {
            node.pre = node;
            node.next = node;
            head = node;
        } else {
            Node tail = head.pre;
            // 链接
            tail.next = node;
            node.pre = tail;
            node.next = head;
            head.pre = node;
            // 更新head
            head = node;
        }
        currentCap++;
        return true;
    }

    public boolean insertLast(T value) {
        if (isFull()) {
            return false;
        }
        Node node = new Node();
        node.val = value;
        if (isEmpty()) {
            node.pre = node;
            node.next = node;
            head = node;
        } else {
            Node oldTail = head.pre;
            // 链接
            oldTail.next = node;
            node.pre = oldTail;
            node.next = head;
            // 更新tail
            head.pre = node;
        }
        currentCap++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (currentCap == 1) {
            head = null;
        } else {
            Node headNext = head.next;
            Node tail = head.pre;
            // 跳过旧head
            headNext.pre = tail;
            tail.next = headNext;
            head = headNext;
        }
        currentCap--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (currentCap == 1) {
            head = null;
        } else {
            Node tail = head.pre;
            Node tailPre = tail.pre;
            // 跳过旧tail
            head.pre = tailPre;
            tailPre.next = head;
        }
        currentCap--;
        return true;
    }

    public T getFront() {
        if (isEmpty()) {
            return null;
        } else {
            return head.val;
        }
    }

    public T getRear() {
        if (isEmpty()) {
            return null;
        } else {
            return head.pre.val;
        }
    }

    public boolean isEmpty() {
        return currentCap == 0;
    }

    public boolean isFull() {
        return currentCap >= cap;
    }

    private class Node<T> {
        private T val;
        private Node<T> pre;
        private Node<T> next;
    }
}
