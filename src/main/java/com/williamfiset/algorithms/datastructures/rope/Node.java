package com.williamfiset.algorithms.datastructures.rope;

public class Node extends Rope {
    private Rope left;
    private Rope right;

    Node(String s) {
        int len = s.length();
        String leftStr = s.substring(0, (len / 2));
        setLeft(toRope(leftStr));
        String rightStr = s.substring((len / 2));
        setRight(toRope(rightStr));
    }

    Node(Rope left, Rope right) {
        setLeft(left);
        setRight(right);
    }

    private void setLeft(Rope rope) {
        left = rope;
        count = rope.totalCount;
        totalCount = rope.totalCount + (right == null ? 0 : right.totalCount);
    }

    private void setRight(Rope rope) {
        right = rope;
        totalCount = rope.totalCount + (left == null ? 0 : left.totalCount);
    }

    @Override
    public char index(int i) {
        if (i < count) {
            return left.index(i);
        }
        return right.index(i - count);
    }


    /**
     * Concatenates the new string on to the rope.
     *
     * @param other rope to be concatenated to this rope.
     */
    @Override
    public Rope concat(Rope other) {
        return new Node(this, other);
    }

    @Override
    protected void addToBuffer(StringBuffer buffer) {
        if (left != null) {
            left.addToBuffer(buffer);
        }
        if (right != null) {
            right.addToBuffer(buffer);
        }
    }

    @Override
    public Rope report(int start, int length) {
        RopePair leftPair = split(start-1);
        RopePair rightPair = leftPair.getRight().split(length-1);
        return rightPair.getLeft();
    }

    @Override
    public Rope insert(int i, Rope other) {
        RopePair pair = this.split(i-1);
        Rope newRope = pair.getLeft().concat(other);
        return newRope.concat(pair.getRight());
    }

    @Override
    public Rope delete(int start, int length) {
        RopePair leftPair = this.split(start-1);
        RopePair rightPair = leftPair.getRight().split(length-1);
        return leftPair.getLeft().concat(rightPair.getRight());
    }

    @Override
    public RopePair split(int i) {
        if (i < count) {
            RopePair leftPair = left.split(i);
            Rope right = leftPair.getRight().concat(this.right);
            return new RopePair(leftPair.getLeft(), right);
        }
        RopePair rightPair = right.split(i - count);
        Rope left = this.left.concat(rightPair.getLeft());
        return new RopePair(left, rightPair.getRight());

    }
}
