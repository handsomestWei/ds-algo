package com.wjy.dsalgo.looplist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 单向环链表
 */
public class SimpleLoopList<T> {

    // 环的头结点
    private LoopNode<T> head;
    // 环的长度
    private int size;
    // 辅助哈希表
    private HashMap<T, LinkedList<LoopNode>> ringNodeMap = new HashMap<>();

    public SimpleLoopList(List<T> data) {
        this.size = data.size();
        buildRing(data);
    }

    // 环查找
    public boolean isLoopContainList(List<T> data) {
        if (data == null || data.isEmpty() || data.size() > size) {
            return false;
        }
        return isMatchList(true, data.size(), data);
    }

    // 环查找
    public boolean isLoopEqualList(List<T> data) {
        if (data == null || data.isEmpty() || data.size() != size) {
            return false;
        }
        return isMatchList(true, size, data);
    }

    // 非环查找
    public boolean isContainList(List<T> data) {
        if (data == null || data.isEmpty() || data.size() > size) {
            return false;
        }
        return isMatchList(false, data.size(), data);
    }

    // 非环查找
    public boolean isEqualList(List<T> data) {
        if (data == null || data.isEmpty() || data.size() != size) {
            return false;
        }
        return isMatchList(false, data.size(), data);
    }

    // 构建环
    private void buildRing(List<T> data) {
        LoopNode tmp = null;
        for (int i = 0; i < data.size(); i++) {
            T val = data.get(i);
            LoopNode ringNode = new LoopNode(val, i);
            if (i == 0) {
                head = ringNode;
                tmp = head;
            } else {
                // 指向下一个节点
                tmp.setNextNode(ringNode);
                tmp = ringNode;
            }
            // 构造辅助哈希表方便直接查找，不用从头遍历
            LinkedList<LoopNode> ringNodeList = ringNodeMap.get(val);
            if (ringNodeList == null) {
                ringNodeList = new LinkedList<>();
                ringNodeMap.put(val, ringNodeList);
            }
            ringNodeList.add(ringNode);
        }
        // 尾指针指向头指针，形成环
        tmp.setNextNode(head);
    }

    // 是否匹配
    private boolean isMatchList(boolean isLoop, int searchSize, List<T> data) {
        T startVal = data.get(0);
        // 从首元素开始查找，先匹配所有可能出现的位置
        LinkedList<LoopNode> ringNodeList = ringNodeMap.get(startVal);
        if (ringNodeList == null) {
            return false;
        }

        for (LoopNode ringNode : ringNodeList) {
            if (!isLoop && ringNode.getIndex() + data.size() > this.size) {
                // 非环查找，若从起始节点开始遍历已超过长度
                return false;
            }
            boolean bingoFlg = true;
            // 从指定起点开始遍历环
            for (int i = 0; i < searchSize; i++) {
                if (!ringNode.getVal().equals(data.get(i))) {
                    bingoFlg = false;
                    break;
                }
                ringNode = ringNode.getNextNode();
            }
            if (bingoFlg) {
                return true;
            }
        }
        return false;
    }
}
