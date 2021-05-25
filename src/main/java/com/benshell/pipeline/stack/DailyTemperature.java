package com.benshell.pipeline.stack;

import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] tempertures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperature.stackDailyTempture(tempertures);
        for(int i = 0 ;i<result.length;i++){
            System.out.print(result[i] +" ");
        }
    }

    public int[] dailyTemperatures(int[] temperatures){
        int[] result = new int[temperatures.length];
        for(int i = 0;i<temperatures.length;i++){
            if(i + 1 == temperatures.length){
                result[i] = 0;
            }
            else{
                boolean isHiger = false;
                for(int j = i+ 1; j<temperatures.length;j++){
                    if(temperatures[i] < temperatures[j]){
                        result[i] = j - i;
                        isHiger = true;
                        break;
                    }
                }
                if(!isHiger){
                    result[i] = 0;
                }
            }
        }
        return result;
    }

    public int[] stackDailyTempture(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length;  i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int target = stack.pop();
                result[target] = i - target ;
            }
            stack.add(i);
        }
        return result;
    }
}
