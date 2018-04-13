package com.portlet.algorithm;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

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

    public Node deleteValue(Node head, int value){
        if(null == head){
            return null;
        }
        while (head != null && head.getValue() == value){
            head = head.getNext();
        }
        Node prev = head;
        while (prev.getNext() != null){
            if(prev.getNext().getValue() == value){
                prev.setNext(prev.getNext().getNext());
            }else {
                prev = prev.getNext();
            }
        }
        return head;
    }

    public Node reverseNode(Node head){
        Node newHead = null;
        Node curHead = head;
        while (curHead != null){
            Node next = curHead.getNext();
            curHead.setNext(newHead);
            newHead = curHead;
            curHead = next;
        }
        return newHead;
    }

    public static void main(String[] args){
        LinkNode linkNode = new LinkNode();
        Node head = linkNode.createLinkNode(Arrays.asList(1,2,3,4));
        head.printNode(head);
        System.out.println();
        Node reverse = linkNode.reverseNode(head);
        reverse.printNode(reverse);
        System.out.println();
        Node delete = linkNode.deleteValue(head, 2);
        delete.printNode(delete);
    }

    @Test
    public void test(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        System.out.println(cycleLinkNode(node1));
    }

    public boolean cycleLinkNode(Node head){
        if(null == head || null == head.getNext()){
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (true){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if(fast == null || fast.getNext() == null){
                return false;
            }else if(fast == slow || fast.getNext() == slow){
                return true;
            }
        }
    }
}
