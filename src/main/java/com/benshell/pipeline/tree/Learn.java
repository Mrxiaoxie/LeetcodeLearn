package com.benshell.pipeline.tree;

import com.benshell.pipeline.linktable.ListNode;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;

import java.util.*;

public class Learn {

    public static void main(String[] args) {
        TreeNode four1Left = new TreeNode(7);
        TreeNode four1Right = new TreeNode(8);
        TreeNode third0 = new TreeNode(4);
        TreeNode third1 = new TreeNode(5,four1Left,four1Right);
        TreeNode third2 = new TreeNode(6);
        TreeNode secondLeft = new TreeNode(2,third0,third1);
        TreeNode secondRight = new TreeNode(3,null,third2);
        TreeNode root = new TreeNode(1,secondLeft,secondRight);
//        List<Integer> result = new ArrayList<>();
//        preorder2(root,result);
//        List<Integer> result = preorderTraversal(root);
//        List<Integer> result = inorderTraversal(root);
//        List<Integer> result = inorder(root);
//        for(int i = 0; i< result.size(); i ++){
//            System.out.print(result.get(i) + " ");
//        }
//        List<List<Integer>> result = levelOrder(root);
//        for(List<Integer> level : result){
//            for(Integer value: level){
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(maxDepth(root));
//        System.out.println(maxDepth2(root));
        buildTree(new int[]{1,2,3,4},new int[]{3,2,4,1});
    }

    public static List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        while(node != null || !stack.empty()){
            while(null != node){
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if(!stack.empty()){
                node = stack.pop();
                node = node.right;
            }

        }
        return result;
    }

    public static List<Integer> preorder(TreeNode root){
        if(root == null){
            return null;
        }
        return null;
    }

    public static void preorder2(TreeNode root,List<Integer> result){
        if(null == root){
            return ;
        }
        result.add(root.val);
        preorder2(root.left,result);
        preorder2(root.right,result);
    }


    // 中序非递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(null != node){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    // 中序 递归
    public static List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        inorderTree(root,result);
        return result;
    }

    public static void inorderTree(TreeNode root, List<Integer> result){
        if(null == root){
            return ;
        }
        inorderTree(root.left,result);
        result.add(root.val);
        inorderTree(root.right,result);
    }


    //后续非递归
    public static List<Integer> suffixOrder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastNode = null;
        while(node != null || !stack.isEmpty()){
            while(null != node){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                if(node.right == null || node.right == lastNode){
                    result.add(node.val);
                    lastNode = node;
                    node = null;
                }
                else{
                    stack.push(node);
                    node = node.right;
                }
            }
        }
        return result;
    }

    //后序 递归
    public static List<Integer> suffix(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.size();
        queue.poll();
        List<Integer> result = new ArrayList<>();
        suf(root,result);
        return result;
    }

    public static void suf(TreeNode root,List<Integer> result){
        if(null == root){
            return ;
        }
        suf(root.left,result);
        suf(root.right,result);
        result.add(root.val);
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> popList = new ArrayList<>();
        popList.add(root);
        while(!popList.isEmpty()){
            int size = popList.size();
            int count = 0;
            List<Integer> levelResult = new ArrayList<>();
            while(count < size){
                TreeNode node = popList.remove(0);
                levelResult.add(node.val);
                count ++;
                if(null != node.left){
                    popList.add(node.left);
                }
                if(null != node.right){
                    popList.add(node.right);
                }
            }
            result.add(levelResult);
        }
        return  result;
    }


    //自顶向下
    public static int maxDepth(TreeNode treeNode){
        max(treeNode,1);
        return answer;
    }

    private static int answer = 0;

    public static void max(TreeNode node,int depth){
        if(null == node){
            return ;
        }
        if(null == node.left && null == node.right){
            answer = Math.max(answer,depth);
        }
        max(node.left,depth + 1);
        max(node.right, depth + 1);
    }

    //自底向上
    public static int maxDepth2(TreeNode treeNode){
        return bottom_up(treeNode);
    }

    public static int bottom_up(TreeNode treeNode){
        if(null == treeNode){
            return 0;
        }
        int left = bottom_up(treeNode.left);
        int right = bottom_up(treeNode.right);
        return Math.max(left,right) + 1;
    }

    public static boolean isMirror(TreeNode root){
        if(null == root){
            return true;
        }
        boolean result = same(root.left,root.right);
        return result;
    }

    public static boolean same(TreeNode left, TreeNode right){
        if(null == left && null == right){
            return true;
        }
        else if(null != left && null != right){
            if(left.val == right.val){
                return same(left.left,right.right) && same(left.right,right.left);
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }

    public static boolean isMirror2(TreeNode root){
        if(null == root){
            return true;
        }
        Queue<TreeNode> leftList = new LinkedList<>();
        Queue<TreeNode> rightList = new LinkedList<>();
        leftList.offer(root.left);
        rightList.offer(root.right);
        while(!leftList.isEmpty()){
            TreeNode left = leftList.poll();
            TreeNode right = rightList.poll();
            if(null == left && null == right){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            else{
                // 两个都都不为空
                if(left.val != left.val){
                    return false;
                }
            }
            leftList.add(left.left);
            rightList.add(right.right);
            leftList.add(left.right);
            rightList.add(right.left);
        }
        return true;
    }

    public boolean hasPathSum(TreeNode root, int targetSum){
        if(null == root){
            return false;
        }
        if(null == root.left  && null == root.right && targetSum - root.val == 0){
            return true;
        }
        else{
            if(null != root.left && null != root.right){
                return hasPathSum(root.left,targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
            }
            else if(null != root.left){
                return hasPathSum(root.left,targetSum - root.val);
            }
            else{
                return hasPathSum(root.right, targetSum - root.val);
            }
        }
    }


    public static boolean isSame(TreeNode root){
        if(null == root){
            return true;
        }
        return isSame(root.left,root.right);
    }

    public static boolean isSame(TreeNode left, TreeNode right){
        if(null == left && null == right){
            return true;
        }
        if(null != left && null != right){
            if(left.val != right.val){
                return false;
            }
            else{
                return isSame(left.left,right.right) && isSame(left.right,right.left);
            }
        }
        else{
            return false;
        }
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        if(postorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        for(int i = postorder.length - 2; i >= 0; i--){
            int rootVal = postorder[i];
            TreeNode node = stack.peek();
            int nodeIndex = findIndex(inorder,node.val);
            //[0,nodeIndex - 1] 是左子树 [nodeIndex + 1,inorder.length] 是右子树
            int rootIndex = findIndex(inorder,rootVal);
            if(rootIndex>nodeIndex){
                //是右节点
                node.right = new TreeNode(rootVal);
                stack.push(node.right);
            }
            else{
                // node的左节点, 要决定是哪个节点的左节点
                while(!stack.isEmpty() && stack.peek().val != node.val){
                    node = stack.pop();
                }
                node.left = new TreeNode(rootVal);
                stack.push(node.left);
            }
        }
        return root;
    }

    public static int findIndex(int[] inorder,int val){
        for(int i = 0; i<inorder.length; i++){
            if(val == inorder[i]){
                return i;
            }
        }
        return -1;
    }


    public static TreeNode buildTree2(int[] inorder, int[] postorder){
        if(null == inorder || inorder.length == 0 || null == postorder || 0 == postorder.length){
            return null;
        }
        TreeNode root = buildTree(inorder,0,inorder.length - 1,postorder, 0,postorder.length - 1);
        return  root;
    }

    public static TreeNode buildTree(int[] inorder,int start,int end,int[] postorder, int ps,int pe){
        if(end < start || pe < ps){
            return null;
        }
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex  = findIndex(inorder,rootVal);
        root.left = buildTree(inorder,start,rootIndex - 1,postorder,ps, ps + rootIndex - 1 - start);
        root.right = buildTree(inorder,rootIndex + 1,end,postorder,ps + rootIndex - start, pe - 1);
        return root;
    }

    public static TreeNode generateTree(int[] preorder,int[] inorder){
        if(null == preorder || preorder.length == 0 || null == inorder || 0 == inorder.length){
            return null;
        }
        TreeNode root = buildTrees(preorder,0,preorder.length - 1, inorder, 0, inorder.length);
        return root;
    }

    public static TreeNode buildTrees(int[] preorder,int ps,int pe,int[] inorder,int is,int ie){
        if(pe < ps || ie < is){
            return null;
        }
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = findIndex(inorder,rootVal);
        root.left = buildTrees(preorder,ps + 1,ps + rootIndex - is,inorder,is,rootIndex - 1);
        root.right = buildTree(preorder,ps + rootIndex - is + 1,pe, inorder, rootIndex + 1,pe);
        return root;
    }

    public static Node connect(Node root){
        if(null == root){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int count = 1;
            Node first = queue.poll();
            if(null != first.left){
                queue.add(first.left);
            }
            if(null != first.right){
                queue.add(first.right);
            }
            while(count < size){
                Node node = queue.poll();
                if(null != node.left){
                    queue.add(node.left);
                }
                if(null != node.right){
                    queue.add(node.right);
                }
                first.next = node;
                first = node;
                count++;
            }
        }
        return root;
    }

    public static Node connect2(Node root){
        if(null == root){
            return null;
        }
        Node pre = root;
        while(null != pre.left){
            Node head = pre;
            while(null != head){
                head.left = head.right;
                if(null != head.next){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            pre = pre.left;
        }
        return root;
    }

}

