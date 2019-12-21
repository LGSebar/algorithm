package com.sebar.test.linkedlist;

import com.sebar.test.common.Node;

/**
 * 用单向linkedList实现LRU算法
 * 思路1：维持一个有序的单向链表，越靠近链表尾部的结点是越早访问的，
 * 当有新的数据进行访问的时候，我们从链表头开始顺序遍历单向链表
 * <p>
 * 1.如果数据之前已经被缓存在链表中，则我们遍历得到这个数据的结点的时候，将其从原来的位置进行删除
 * ，然后再插入到链表的头部
 * 2. 如果此数据没有在缓存链表中，如果缓存未满，则将结点添加到链表的头部
 * 如果缓存已满，则链表的尾结点删除，将当前数据添加到链表的头部
 */
public class LinkedListBuildLRUAlgorithm<T> {
    /**
     * 单向链表长度
     */
    private int length;
    /**
     * 单向链表的上一个结点
     */
    private Node<T> head;

    public LinkedListBuildLRUAlgorithm() {
        this.length = 0;
        this.head = null;
    }

    /**
     * 从头部开始数据插入
     */
    public void insertNodeBeginHead(T data) {
        this.length++;
        if(head ==null){
            head=new Node<>(null,null);
        }
        Node<T> headNextNode = head.getNext();
        head.setNext(new Node<>(data, headNextNode));
    }

    /**
     * 删除尾部的结点
     */
    public void deleteTailNode() {
        Node<T> currentNode = head;
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        // 将尾结点置空
        currentNode.setNext(null);
        length--;
    }

    public Node<T> findNode(T data){
        Node<T> currentNode=head;
        while (currentNode.getNext() != null && !data.equals(currentNode.getKey())){
            currentNode=currentNode.getNext();
        }
        // 找到结点后返回
        return currentNode;
    }
}
