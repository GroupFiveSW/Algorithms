package com.williamfiset.algorithms.datastructures.rope;

public class Node extends Rope {
    Rope left;
    Rope right;

    public Node(int count) {
        this.count = count;
    }

    public Node() {
        count = 0;
        left = null;
        right = null;
    }

    void setLeft(Rope rope) {
        left = rope;
        count = rope.totalCount;
        totalCount = rope.totalCount + (right == null ? 0 : right.totalCount);
    }

    void setRight(Rope rope) {
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
        Node newRoot = new Node();
        newRoot.setLeft(this);
        newRoot.setRight(other);
        return newRoot;
    }


    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buildBuffer(buffer);
        return buffer.toString();
    }

    private void buildBuffer(StringBuffer buffer) {
        if (left instanceof Node) {
            ((Node) left).buildBuffer(buffer);
        } else if (left instanceof Leaf) {
            buffer.append(left);
        }
        if (right instanceof Node) {
            ((Node) right).buildBuffer(buffer);
        } else if (right instanceof Leaf) {
            buffer.append(right);
        }
    }

    @Override
    public Rope report(int start, int length) {
        RopePair leftPair = split(start);
        RopePair rightPair = leftPair.getRight().split(length);
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
        return null;
    }

    @Override
    public RopePair split(int i) {
        if (i <= count) {
            RopePair leftPair = left.split(i);
            Rope right = leftPair.getRight().concat(this.right);
            return new RopePair(leftPair.getLeft(), right);
        }
        RopePair rightPair = right.split(i - count);
        Rope left = this.left.concat(rightPair.getLeft());
        return new RopePair(left, rightPair.getRight());

    }
}
