package com.benshell.pipeline.stack;

import com.benshell.pipeline.tree.TreeNode;

import java.util.*;

public class StackInorderNode {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(null != node.left && !visited.contains(node)){
                visited.add(node);
                stack.push(node.left);
                continue;
            }
            else{
                stack.pop();
                result.add(node.val);
                if(null != node.right){
                    stack.add(node.right);
                }
            }
        }
        return result;
    }


}
