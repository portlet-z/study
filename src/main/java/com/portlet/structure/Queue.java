package com.portlet.structure;

/**
 * @author: 张新征
 * @date: 2018/4/17 上午9:44
 */
public interface Queue<E> {

    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
