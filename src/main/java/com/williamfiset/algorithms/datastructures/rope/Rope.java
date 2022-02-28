//package com.williamfiset.algorithms.datastructures.rope;


//import com.williamfiset.algorithms.datastructures.segmenttree.Node;

public class Rope {

    Node root;


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
    }


    public Node treeBuilder(Node parent, String s){
        int len = s.length();
        if(len <= 3){
            System.out.print("\n\nString of leaf: " + s);
            System.out.print("\n\n len of leaf: " + parent.count);
            parent.str = s;
            return parent;
        }

        String left = s.substring(0,(len/2));
        if (left.length()<=3){
            Node leftNode = new Node(left.length());
            parent.left = leftNode;
            treeBuilder(leftNode, left);
        }
        else{
            Node leftNode = new Node(left.substring(0,left.length()/2).length());
            parent.left = leftNode;
            treeBuilder(leftNode, left);
        }

        String right = s.substring(len/2);
        if (right.length()<=3){
            Node rightNode = new Node(right.length());
            parent.left = rightNode;
            treeBuilder(rightNode, right);
        }
        else{
            Node rightNode = new Node(right.substring(0,right.length()/2).length());
            parent.right = rightNode;
            treeBuilder(rightNode, right);
        }


//        int leftLenCount = left.substring(0,left.length()/2).length();
//        int rightLenCount = right.substring(0,right.length()/2).length();
//        System.out.print(("\n\ncountleft: " + left));
//        System.out.print(("\n\ncountright: " + right));

//        Node leftNode = new Node(leftLenCount);
//        Node rightNode = new Node(rightLenCount);

//        System.out.print(("\n\ncountleft: " + leftNode.count));
//        System.out.print(("\n\ncountright: " + rightNode.count));

//        parent.left = leftNode;
//        parent.right = rightNode;
//        treeBuilder(leftNode, left);
//        treeBuilder(rightNode, right);

        return parent;
    }

    public Rope(String s){
        this.root = new Node(s.length());
        treeBuilder(root,s);
//        System.out.print("\n\n count root right:  " + root.left.left.count);
    }

    public int split(int i){
        System.out.print("\n\nentered split");
        Node currentNode = root;
        while(currentNode.count>2){
            System.out.print("\n\ncurrent count: " + currentNode.count);
            System.out.print("\n\ncurrent index:  " + i);

            if(i<=currentNode.count){
                System.out.print("\n\ntook left");
                currentNode=currentNode.left;
            }
            else{
                System.out.print("\n\ntook right");

                i-= currentNode.count;
                currentNode=currentNode.right;
            }
        }
        System.out.print("\n\ncurrent count: " + currentNode.count);

        System.out.print("\n\ncurrent string: " + currentNode.str);

        System.out.print("\n\ncurrent index: " + i);

        System.out.print("\n\nletter found: " + currentNode.str.charAt(i-1));
        return 0;
    }


    public static void main(String[] args) {
        Rope r = new Rope("golfbanan");
        System.out.print("\n\n count root right:  " + r.root.right.left.count);
//        int k = r.split(7);

    }
}
