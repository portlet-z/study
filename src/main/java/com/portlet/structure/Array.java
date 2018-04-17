package com.portlet.structure;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: 张新征
 * @date: 2018/4/16 下午1:59
 */
@Slf4j
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量 capacity构造 Array
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 返回数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 向所有元素后添加一个元素
     * @param e
     */
    public void addLast(E e){
        add(size, e);
    }

    /**
     * 想数组第一个位置插入元素
     * @param e
     */
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 向 index 个位置插入一个元素 e
     * @param index
     * @param e
     */
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and <= size");
        }

        if(size == data.length){
            resize(2 * data.length);
        }

        for (int i = size-1; i >= index; i--){
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取 index 索引位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    /**
     * 修改 index 索引位置的元素 e
     * @param index
     * @param e
     */
    public void set(int index, E e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否有元素 e
     * @param e
     * @return
     */
    public boolean contains(E e){
        for (int i=0; i<size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素e 在数组中的索引位置
     * @param e
     * @return
     */
    public int find(E e){
        for (int i=0; i<size; i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除索引位置的元素
     * @param index
     * @return 返回要删除的元素
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E ret = data[index];
        for (int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 删除数组中的第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组中的最后一个元素。
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 从数组中删除元素 e
     * @param e
     */
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i=0; i<size; i++){
            res.append(data[i]);
            if(i != size-1){
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
