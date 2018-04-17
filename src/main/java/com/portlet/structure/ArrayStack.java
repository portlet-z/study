package com.portlet.structure;

/**
 * @author: 张新征
 * @date: 2018/4/16 下午5:15
 */
public class ArrayStack<E> implements Stack<E>{

    private Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayStack(){
        array = new Array<>();
    }

    /**
     * 向栈中添加一个元素
     * @param element
     */
    @Override
    public void push(E element){
        array.addLast(element);
    }

    /**
     * 栈顶元素弹出
     * @return
     */
    @Override
    public E pop(){
        return array.removeLast();
    }

    /**
     * 查看栈顶元素
     * @return
     */
    @Override
    public E peek(){
         return array.getLast();
    }

    /**
     * 栈中元素大小
     * @return
     */
    @Override
    public int getSize(){
        return array.getSize();
    }

    /**
     * 是否为空
     * @return
     */
    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i=0; i<array.getSize(); i++){
            res.append(array.get(i));
            if(i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
