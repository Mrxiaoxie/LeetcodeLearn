package com.benshell.pipeline.tree;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public static void main(String[] args) {
        int[] group = new int[]{183,0,1,2,-184,367};
        int sum = 183;
        Map<Integer,Integer> result = find(group,sum);
        for(Map.Entry<Integer,Integer> entry:result.entrySet()){
            System.out.println(group[entry.getKey()] +" " + group[entry.getValue()]);
        }
    }

    public static Map<Integer,Integer> find(int[] group,int sum){
        Map<Integer,Integer> result = new HashMap<>();
        Map<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i <group.length;i++){
            int rest = sum - group[i];
            if(hash.containsKey(group[i])){
                result.put(i,hash.get(group[i]));
            }
            else{
                hash.put(rest,i);
            }

        }
        return result;
    }


}
