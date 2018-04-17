package com.portlet.structure;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: 张新征
 * @date: 2018/4/16 下午2:23
 */
@Slf4j
public class Main {
    public static void main(String[] args){
        Array<Integer> arr = new Array<>(20);
        for (int i=0; i<10; i++){
            arr.addLast(i);
        }
        log.info("{}", arr);

        arr.add(1, 100);
        log.info("{}", arr);

        arr.remove(2);
        log.info("{}", arr);

        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i=0; i<5; i++){
            stack.push(i);
            log.info("{}", stack);
        }
        stack.pop();
        log.info("{}", stack);

        System.out.println(isValid("{}[]([{})"));

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(3);
        log.info("{}", arrayQueue);
        arrayQueue.dequeue();
        log.info("{}", arrayQueue);
    }

    private static boolean isValid(String parentheses){
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i=0; i<parentheses.length(); i++){
            char c = parentheses.charAt(i);
            if (c == '(' || c == '[' || c =='{'){
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
