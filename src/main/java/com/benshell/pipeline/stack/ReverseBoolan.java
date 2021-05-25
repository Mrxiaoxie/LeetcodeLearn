package com.benshell.pipeline.stack;

import java.util.Stack;

public class ReverseBoolan {

    public static void main(String[] args) {
        String[] tokens = new String[]{"2","1","+","3","*"};
        ReverseBoolan reverseBoolan = new ReverseBoolan();
        System.out.println(reverseBoolan.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("*") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/")){
                int result = 0;
                int number1 = stack.pop();
                int number2 = stack.pop();
                switch (tokens[i]){
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number2 - number1;
                        break;
                    case "*":
                        result = number2 * number1;
                        break;
                    case "/":
                        result = number2 / number1;
                        break;
                }
                stack.add(result);
            }
            else{
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }
}
