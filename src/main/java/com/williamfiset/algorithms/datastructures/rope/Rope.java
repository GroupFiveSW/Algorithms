//package com.williamfiset.algorithms.datastructures.rope;


//import com.williamfiset.algorithms.datastructures.segmenttree.Node;

public class Rope {

    Node root;
    final static int leafLength = 3;

    public static class Node {
        int count;
        String str;
        Node left;
        Node right;

        public Node(int count, String str) {
            this.count = count;
            this.str = str;
        }

        public Node(int count) {
            this.count = count;
        }

        public Node() {
            count = 0;
            str = null;
            left = null;
            right = null;
        }
    }

    public Node treeBuilder(Node parent, String s){
        int len = s.length();
        if(len <= leafLength){
            parent.str = s;
            parent.count = len;
            return parent;
        }
        Node left = new Node();
        Node right = new Node();

        String leftStr = s.substring(0,(len/2));
        parent.left = left;
        treeBuilder(left, leftStr);

        String rightStr = s.substring((len/2));
        parent.right = right;
        treeBuilder(right, rightStr);

        parent.count = parent.left.count;

        if (parent.left.right != null){
            parent.count += parent.left.right.count;
        }
        return parent;
    }

    public Rope(String s){
        this.root = new Node(s.length());
        Node left = new Node();
        this.root.left = left;
        treeBuilder(left,s);
    }

    public char index(int i){
        Node currentNode = root;
        while(currentNode.left != null){
            if(i<currentNode.count){
                currentNode=currentNode.left;
            }
            else{
                i-= currentNode.count;
                currentNode=currentNode.right;
            }
        }
        return currentNode.str.charAt(i);
    }


    public static void main(String[] args) {
        Rope r = new Rope("golfbanan");
        //System.out.print("\n\n count root right:  " + r.root.right.left.count);
        System.out.println(r.index(5));;

    }
}
