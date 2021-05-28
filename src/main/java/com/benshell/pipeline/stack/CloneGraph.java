package com.benshell.pipeline.stack;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {
        GraphNode no1 = new GraphNode(1);
        GraphNode no2 = new GraphNode(2);
        GraphNode no3 = new GraphNode(3);
        GraphNode no4 = new GraphNode(4);
        no1.neighbors.add(no2);
        no1.neighbors.add(no4);
        no2.neighbors.add(no1);
        no2.neighbors.add(no3);
        no3.neighbors.add(no2);
        no3.neighbors.add(no4);
        no4.neighbors.add(no3);
        no4.neighbors.add(no1);
        CloneGraph cloneGraph = new CloneGraph();
        GraphNode graphNode = cloneGraph.cloneGraph(no1);
        System.out.println("end");
    }


    public GraphNode cloneGraph(GraphNode node) {
        if(null == node){
            return null;
        }
        Map<Integer,GraphNode> visited = new HashMap<>();
        return copy(node,visited);
    }

    public GraphNode copy(GraphNode sourceNode, Map<Integer,GraphNode> visited){
        if(visited.containsKey(sourceNode.val)){
            return visited.get(sourceNode.val);
        }
        GraphNode graphNode = new GraphNode(sourceNode.val);
        visited.put(sourceNode.val,graphNode);
        Stack<GraphNode> stack = new Stack<>();
        stack.addAll(sourceNode.neighbors);
        while(!stack.isEmpty()){
            GraphNode sonNode = copy(stack.pop(),visited);
            if(null != sonNode){
                graphNode.neighbors.add(sonNode);
            }
        }
        return graphNode;
    }


    static class GraphNode {
        public int val;
        public List<GraphNode> neighbors;
        public GraphNode() {
                val = 0;
                neighbors = new ArrayList<GraphNode>();
            }
        public GraphNode(int _val) {
                val = _val;
                neighbors = new ArrayList<GraphNode>();
            }
        public GraphNode(int _val, List<GraphNode> _neighbors) {
                val = _val;
                neighbors = _neighbors;
            }
        }
}
