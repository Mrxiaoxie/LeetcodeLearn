package com.benshell.pipeline.stack;

import java.util.Stack;

public class KuoHao {

    public static void main(String[] args) {
        KuoHao kuoHao = new KuoHao();
        System.out.println(kuoHao.isValid("(]"));
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ;i<chars.length;i++){
            if(stack.isEmpty()){
                stack.push(chars[i]);
            }
            else{
                //判断能否组成括号对
                if(isPair(stack.peek(),chars[i])){
                    stack.pop();
                    continue;
                }
                else{
                    //不能组成，判断是否] } )，如果是 则往后的都不可能存在配置的,直接return false
                    if(chars[i] == ']' || chars[i] == '}' || chars[i] == ')'){
                        return false;
                    }
                    else{
                        stack.add(chars[i]);
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isPair(char top,char current){
        return (top == '[' && current == ']') || (top == '{' && current == '}') || (top == '(' && current == ')');
    }
}
