package com.sebar.test.common;


/**
 * 链表节点
 */
public class Node<T> {
    /**
     * 链表存放的数据键
     */
    private T key;

    /**
     * 链表存储的值
     */
    private T value;

    /**
     * 链表节点的前置节点
     */
    private Node<T> prev;

    /**
     * 链表节点的后置节点
     */
    private Node<T> next;

    public Node(T key, Node<T> next) {
        this.key = key;
        this.next = next;
    }
    public Node(T key,T value, Node<T> next) {
        this.key = key;
        this.value = key;
        this.next = next;
    }

    public Node(T key, Node<T> prev, Node<T> next) {
        this.key = key;
        this.prev = prev;
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
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

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
