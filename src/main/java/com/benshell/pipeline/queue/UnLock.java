package com.benshell.pipeline.queue;

import java.util.*;

public class UnLock {

    public static void main(String[] args) {
        UnLock unLock = new UnLock();
        System.out.println(unLock.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},"8888"));
    }

    public int openLock(String[] deadends, String target) {
        int count = -1;
        Set<String> deads = new HashSet<>();
        deads.addAll(Arrays.asList(deadends));
        if("0000".equals(target)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> used = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0; i<size;i++){
                String item = queue.poll();
                if(item.equals(target)){
                    return count;
                }
                if(used.contains(item) || deads.contains(item)){
                    continue;
                }
                // visisted
                used.add(item);
                //add neiboger node
                for(int j = 0;j<4;j++){
                    String plus = plus(item,j);
                    String reduce =reduce(item,j);
                    if(!used.contains(plus)){
                        queue.offer(plus);
                    }
                    if(!used.contains(reduce)){
                        queue.offer(reduce);
                    }
                }
            }
        }
        return -1;
    }

    public String plus(String item, int i){
        char[] chars = item.toCharArray();
        if(chars[i] == '9'){
            chars[i] = '0';
        }
        else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    public String reduce(String item, int j){
        char[] chars = item.toCharArray();
        if(chars[j] == '0'){
            chars[j] = '9';
        }
        else{
            chars[j] -= 1;
        }
        return new String(chars);
    }

    public List<String> nexts(String item){
        List<String> result = new ArrayList<>();
        for(int i =0; i < item.length(); i++){
            Integer value = Integer.parseInt(item.substring(i,i+1));
            int valuePlus = (value + 1 ) % 10;
            int valueReduce = (value + 9) % 10;
            StringBuilder plus = new StringBuilder();
            StringBuilder reduce = new StringBuilder();
            if(i == 0){
                plus.append(valuePlus).append(item.substring(i+1));
                reduce.append(valueReduce).append(item.substring(i+1));
            }
            else if( i  == item.length() - 1){
                plus.append(item.substring(0,i)).append(valuePlus);
                reduce.append(item.substring(0,i)).append(valueReduce);
            }
            else{
                plus.append(item.substring(0,i)).append(valuePlus).append(item.substring(i+1));
                reduce.append(item.substring(0,i)).append(valueReduce).append(item.substring(i+1));
            }
            result.add(plus.toString());
            result.add(reduce.toString());
        }
        return result;
    }

    public boolean contains(String[] deadends, String target){
        if(null == deadends || deadends.length == 0){
            return false;
        }
        for(int i = 0; i < deadends.length; i++){
            if(deadends[i].equals(target)){
                return true;
            }
        }
        return false;
    }
}
