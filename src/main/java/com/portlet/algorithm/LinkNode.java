package com.portlet.algorithm;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 张新征
 * @date: 2018/4/9 上午11:19
 */
@Slf4j
public class LinkNode {
    class Node{
        @Getter
        private int value;
        @Setter
        @Getter
        private Node next;
        public Node(int value){
            this.value = value;
            this.next = null;
        }
        public void printNode(Node head){
            while (head != null){
                System.out.print(head.getValue()+" ");
                head = head.getNext();
            }
        }
    }

    /**
     * create link node
     * @param data
     * @return the link node of the head
     */
    public Node createLinkNode(List<Integer> data){
        if(data.isEmpty()){
            return null;
        }
        Node head = new Node(data.get(0));
        head.setNext(createLinkNode(data.subList(1, data.size())));
        return head;
    }

    public static void main(String[] args){
        LinkNode linkNode = new LinkNode();
        Node head = linkNode.createLinkNode(Arrays.asList(1,2));
        head.printNode(head);
    }
}
