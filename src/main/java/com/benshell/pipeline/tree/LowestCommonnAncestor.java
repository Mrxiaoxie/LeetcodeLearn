package com.benshell.pipeline.tree;

public class LowestCommonnAncestor {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightNode = lowestCommonAncestor(root.right,p,q);
        if(null == leftNode){
            //都在左节点
            return rightNode;
        }
        if(null == rightNode){
            //都在右节点
            return leftNode;
        }
        return root;
    }
}
