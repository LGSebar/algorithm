package com.sebar.test.linkedlist;

import com.sebar.test.common.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * 双端链表实现LRU算法
 * 增加维护一个本地Cache,做key存在校验
 */
public class DoubleLinkedBuildLRUAlgorithm<T> {
    /**
     * 本地缓存map
     */
    Map<T, Node> localCacheMap = new HashMap<>(64);
    /**
     * 链表大小
     */
    private int length;
    /**
     * 链表头结点
     */
    private Node<T> head;
    /**
     * 链表尾结点
     */
    private Node<T> tail;
    /**
     * 链表的最大承载
     */
    private int capacity;

    private static DoubleLinkedBuildLRUAlgorithm singleton = null;

    public static DoubleLinkedBuildLRUAlgorithm getInstance(int size) {
        if (null == singleton) {
            singleton = new DoubleLinkedBuildLRUAlgorithm(size);
        }
        return singleton;
    }

    private DoubleLinkedBuildLRUAlgorithm(int capacity) {
        this.capacity = capacity;
        length = 0;
    }

    /**
     * 插入数据
     */
    private void setNode(T key, T value) {
        // 先判断本地缓存中是否有当前数据，如果存在，则需要找出当前数据结点
        // 并将当前节点插到头结点位置
        if (localCacheMap.containsKey(key)) {
            // 存在，将当前节点数据找出来，
            Node node = localCacheMap.get(key);
            // 旧值被替换成新值
            node.setValue(value);
            // 从链表中删掉
            removeFromLinkedList(node);
            // 插到头位置去
            setHead(node);
        } else {
            Node node = new Node(key, value, head);
            // 不存在,判断当前容量是否够
            if (length > capacity) {
                // 容量不够，需要删掉尾数据，并将当前数据查到头部去
                T tailKey = tail.getKey();
                removeFromLinkedList(tail);
                localCacheMap.remove(tailKey);
            }
            //
            setHead(node);
            localCacheMap.put(key, node);
        }

    }

    /**
     * 从链表中移除节点
     *
     * @param node
     */
    private void removeFromLinkedList(Node node) {
        // 找到位置以后，将当前节点的前置和后置找出
        Node prevNode = node.getPrev();
        Node nextNode = node.getNext();
        prevNode.setNext(nextNode);
        length--;
    }

    /**
     * 重新设置头结点
     *
     * @param node
     */
    private void setHead(Node node) {
        Node prev = node.getPrev();
        Node next = node.getNext();

        // 将当前结点指定为头结点
        if (head != null) {
            head.setPrev(node);
        }

        // 如果尾是空的，将当前节点值赋给尾结点
        if (tail == null) {
            head.setNext(node);
        }
    }

    /**
     * 获取指定结点信息
     */
    private Node getInfo(T data) {
        return null;
    }


}
