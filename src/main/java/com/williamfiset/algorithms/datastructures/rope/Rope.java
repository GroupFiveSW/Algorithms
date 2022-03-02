package com.williamfiset.algorithms.datastructures.rope;


//import com.williamfiset.algorithms.datastructures.segmenttree.Node;

public abstract class Rope {

    final static int leafLength = 3;

    protected int count = 0;
    protected int totalCount = 0;

    /**
     * Helper function for toRope, creates Rope tree consisting of Nodes and Leaves.
     * @param s String to be tuned into Rope.
     * @return Rope containing s.
     */
    static Rope treeBuilder(String s){
        int len = s.length();
        if(len <= leafLength){
            return new Leaf(s);
        }
        return new Node(s);
    }

    /**
     * Takes string and returns Rope constructed of Nodes and Leaves.
     * @param s String to be stored as rope
     * @return Rope containing s.
     */
    public static Rope toRope(String s){
        return treeBuilder(s);
    }

    /**
     * Returns character at position i.
     * @param i position of character.
     * @return Character.
     */
    public abstract char index(int i);

    /**
     * Splits the rope into two new ropes, rope1 = C1,...,Ci and rope2 = Ci+1,...Cm
     * @param i Index to split at.
     * @return RopePair which contains the two new ropes.
     */
    public abstract RopePair split(int i);

    /**
     * Concatenates the new string on to the rope.
     * @param other rope to be concatenated on this rope.
     */
    public abstract Rope concat(Rope other);

    /**
     * Outputs the rope consisting of Ci,..,Ci+j-1
     * @param start Starting index of string.
     * @param length Number of characters in the string.
     * @return New Rope containing Ci,..,Ci+j-1
     */
    public abstract Rope report(int start, int length);

    /**
     * insert the rope "other" beginning at position i in the current rope,
     * to form a new rope C1,...Ci, S', Ci+1,...Cm
     * @param i Position to insert rope.
     * @param other Rope to be inserted.
     * @return New rope containing other.
     */
    public abstract Rope insert(int i, Rope other);

    /**
     * Deletes the substring Ci,...Ci+j-1, from rope to form a new rope C1,...Ci-1,Ci+j,...,Cm
     * @param start Starting index for delete.
     * @param length Amount of characters to delete.
     * @return New rope missing chars at indexes start...(start + length)
     */
    public abstract Rope delete(int start, int length);

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        addToBuffer(buffer);
        return buffer.toString();
    }

    /**
     * Helper function for toString.
     * @param buffer buffer containing substring in node/leaf.
     */
    protected abstract void addToBuffer(StringBuffer buffer);
}
