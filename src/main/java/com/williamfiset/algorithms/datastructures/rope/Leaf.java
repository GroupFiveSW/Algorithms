package com.williamfiset.algorithms.datastructures.rope;



public class Leaf extends Rope{
    String str;


    public Leaf(String str) {
        this.str = str;
        count = str.length();
        totalCount = str.length();
    }

    @Override
    public char index(int i) {
        return str.charAt(i);
    }

    @Override
    public Rope concat(Rope other) {
        Node newRoot = new Node();
        newRoot.setLeft(this);
        newRoot.setRight(other);
        return newRoot;
    }

    @Override
    public Rope report(int start, int length) {
        return new Leaf(str.substring(start, start + length));
    }

    @Override
    public Rope insert(int i, Rope other) {
        RopePair pair = this.split(i-1);
        Rope newRope = pair.getLeft().concat(other);
        return newRope.concat(pair.getRight());
    }

    @Override
    public Rope delete(int start, int length) {
        return new Leaf(new String(str.substring(0, start).concat(str.substring(start + length - 1))));
    }

    @Override
    public RopePair split(int i) {
        String s1 = str.substring(0, i + 1);
        String s2 = str.substring(i + 1);
        return new RopePair(new Leaf(s1),new Leaf(s2));
    }

    @Override
    public String toString(){
        return str;
    }
}
