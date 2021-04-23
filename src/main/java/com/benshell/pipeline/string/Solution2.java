package com.benshell.pipeline.string;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(isAnagram("cat","car"));
    }

    public static boolean isAnagram(String s, String t){
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key) + 1);
            }
            else{
                map.put(key,1);
            }
        }
        for(int i = 0 ;i<t.length();i++){
            char key = t.charAt(i);
            if(map.containsKey(key)){
                map.put(key,map.get(key) - 1);
            }
            else{
                return false;
            }
        }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
