package com.williamfiset.algorithms.datastructures.rope;

public class Node extends Rope{
        int count;
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

    @Override
    public char index(int i){
        Rope.Node currentNode = root;
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


    /**
     * Concatenates the new string on to the rope.
     * @param newStr String to be concatenated.
     */
    @Override
    public void concat(String newStr){
        Rope newRope = new Rope(newStr);
        root.right = newRope.root.left;
        Node newRoot = new Node();
        newRoot.left = root;
        newRoot.count = newRoot.left.count + newRope.root.count;
        root = newRoot;
    }


    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buildBuffer(buffer, root);
        return buffer.toString();
    }


    private void buildBuffer(StringBuffer buffer, Node node) {
        if (node == null) {
            return;
        }
        if (node.str != null) {
            buffer.append(node.str);
            return;
        }
        buildBuffer(buffer, node.left);
        buildBuffer(buffer, node.right);
    }

    @Override
    public void report(int start, int finish){
        Node currentNode = root;
        while(currentNode.left!=null){
            if(start<currentNode.count){
                currentNode = currentNode.left;
            }
            else{
                start-= currentNode.count;
                currentNode = currentNode.right;
            }
        }
        String output = "";

//        int subLen = finish-start;
//        while (subLen > 0){
//            if()
//        }
        return;
    }


    @Override
    public void split(int i){
        Node currentNode = root;
        String lastDir = "";
        while(currentNode.left!=null){
            if(i<currentNode.count){
                lastDir = "left";
                currentNode = currentNode.left;
            }
            else{
                Rope leftRope = new Rope(currentNode.left.str);
                //con
                lastDir = "right";
                i-= currentNode.count;
                currentNode = currentNode.right;
            }
        }

        Node leaf = currentNode;
        String frontString = leaf.str.substring(0,i);

        if(frontString.length() != leaf.str.length()){
            String tail = leaf.str.substring(i);
            Node leftLeaf = new Node(frontString.length(), frontString);
            leaf.left = leftLeaf;

            Node rightLeaf = new Node(tail.length(), tail);
            leaf.right = rightLeaf;
        }

//        if(i>=0 && i< leaf.str.length()){
//            Node left = new Node();
//        }

    }
}
