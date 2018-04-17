package com.portlet.structure;

/**
 * @author: 张新征
 * @date: 2018/4/16 下午5:32
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
