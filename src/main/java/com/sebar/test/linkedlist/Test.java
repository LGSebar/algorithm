package com.sebar.test.linkedlist;

import com.sebar.test.common.Node;

public class Test {
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LinkedListBuildLRUAlgorithm algorithm=new LinkedListBuildLRUAlgorithm();

        algorithm.insertNodeBeginHead(1);
        algorithm.insertNodeBeginHead(2);
        algorithm.insertNodeBeginHead(3);
        algorithm.insertNodeBeginHead(4);

        Node node = algorithm.findNode(3);
    }
}
