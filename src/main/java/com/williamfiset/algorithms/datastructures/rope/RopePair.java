package com.williamfiset.algorithms.datastructures.rope;

public class RopePair {
    private Rope left;
    private Rope right;

    public RopePair(Rope left, Rope right) {
        this.left = left;
        this.right = right;
    }

    public Rope getLeft() {
        return left;
    }

    public Rope getRight() {
        return right;
    }
}
