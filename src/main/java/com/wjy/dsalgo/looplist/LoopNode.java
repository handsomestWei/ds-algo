package com.wjy.dsalgo.looplist;

/**
 * 环节点，单向
 */
public class LoopNode<T> {

    // 节点元素
    private T val;
    // 节点索引位置
    private int index;
    // 下一个节点
    private LoopNode nextNode;

    public LoopNode(T val, int index) {
        this.val = val;
        this.index = index;
    }

    public T getVal() {
        return val;
    }

    public int getIndex() {
        return index;
    }

    public void setNextNode(LoopNode nextNode) {
        this.nextNode = nextNode;
    }

    public LoopNode getNextNode() {
        return nextNode;
    }
}
