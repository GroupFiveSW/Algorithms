package com.williamfiset.algorithms.datastructures.rope;


//import com.williamfiset.algorithms.datastructures.segmenttree.Node;

public abstract class Rope {

    final static int leafLength = 3;

    protected int count = 0;
    protected int totalCount = 0;

    static Rope treeBuilder(String s){
        int len = s.length();
        if(len <= leafLength){
            return new Leaf(s);
        }
        return new Node(s);
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

    public abstract Rope insert(int i, Rope other);

    public abstract Rope delete(int start, int length);

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        addToBuffer(buffer);
        return buffer.toString();
    }

    protected abstract void addToBuffer(StringBuffer buffer);
}
