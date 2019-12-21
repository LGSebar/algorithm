package com.sebar.common;


/**
 * 链表节点
 */
public class Node<T> {
    /**
     * 链表存放的数据
     */
    private T data;
    /**
     * 链表节点的前置节点
     */
    private Node<T> prev;

    /**
     * 链表节点的后置节点
     */
    private Node<T> next;

    public Node(T data, Node<T> prev) {
        this.data = data;
        this.prev = prev;
    }

    public Node(T data, Node<T> prev, Node<T> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getPrev() {
        return prev;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
