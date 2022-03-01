package com.williamfiset.algorithms.datastructures.rope;


//import com.williamfiset.algorithms.datastructures.segmenttree.Node;

public abstract class Rope {

    final static int leafLength = 3;

    protected int count = 0;
    protected int totalCount = 0;

    static Rope treeBuilder(String s){
        int len = s.length();
        if(len <= leafLength){
            Leaf leaf = new Leaf(s);
            return leaf;
        }
        Node node = new Node();

        String leftStr = s.substring(0,(len/2));
        node.setLeft(treeBuilder(leftStr));

        String rightStr = s.substring((len/2));
        node.setRight(treeBuilder(rightStr));

        return node;
    }

    public static Rope toRope(String s){
        return treeBuilder(s);
    }

    public abstract char index(int i);

    public abstract RopePair split(int i);

    /**
     * Concatenates the new string on to the rope.
     * @param other rope to be concatenated on this rope.
     */
    public abstract Rope concat(Rope other);

    public abstract Rope report(int start, int length);

    public static void main(String[] args) {
        Rope r = Rope.toRope("golfbanan");
        //System.out.print("\n\n count root right:  " + r.root.right.left.count);
        System.out.println(r.index(5));;
        System.out.println("char at index 5:   " + r.index(5));
    }
}
