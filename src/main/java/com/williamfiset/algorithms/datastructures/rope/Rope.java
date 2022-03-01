package com.williamfiset.algorithms.datastructures.rope;


//import com.williamfiset.algorithms.datastructures.segmenttree.Node;

public abstract class Rope {

    final static int leafLength = 3;


    public static void treeBuilder(Node parent, String s){
        int len = s.length();
        if(len <= leafLength){
            parent.count = len;
            return;
        }
        String leftStr = s.substring(0,(len/2));
        Node left = new Node();
        parent.left = left;


        String rightStr = s.substring((len/2));
        Node right = new Node();
        parent.right = right;

        treeBuilder(left, leftStr);

        treeBuilder(right, rightStr);

        parent.count = parent.left.count;

        if (parent.left.right != null){
            parent.count += parent.left.right.count;
        }
        return;
    }

    public static Rope toRope(String s){
        Node root = new Node(s.length());
        Node left = new Node();
        root.left = left;
        treeBuilder(left,s);
        return root;
    }

    public abstract char index(int i);


    public abstract  void split(int i);


    /**
     * Concatenates the new string on to the rope.
     * @param newStr String to be concatenated.
     */
    public abstract void concat(String newStr);

    public abstract Rope report(int start, int finish);

    public static void main(String[] args) {
        Rope r = new Rope("golfbanan");
        //System.out.print("\n\n count root right:  " + r.root.right.left.count);
        System.out.println(r.index(5));;
        System.out.println("char at index 5:   " + r.index(5));
    }
}
