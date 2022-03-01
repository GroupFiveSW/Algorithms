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

    private Leaf getLeaf(Rope rope, int index) {
        if (rope instanceof Leaf) {
            return (Leaf) rope;
        }
        Node node = (Node) rope;
        if (index < node.count) {
            return getLeaf(node.left, index);
        }
        return getLeaf(node.right, index - count);
    }


    @Override
    public Rope report(int start, int length) {
        int finish = start + length;
        Rope currentNode = this;

        Leaf startLeaf = getLeaf(this, start);

        while (left != null) {
            if (finish < count) {
                break;
            } else {
                currentNode = left;
            }
        }

        String output = "";

        while (length > 0) {
            if ()
        }
        return;
    }




    @Override
    public RopePair split(int i) {
        Node currentNode = this;
        String lastDir = "";
        while (currentNode.left != null) {
            if (i < count) {
                //currentNode = left;
            } else {
                //con
                i -= count;
                ///currentNode = right;
            }
        }

        Leaf leaf = new Leaf("");
        String frontString = leaf.str.substring(0, i);

        if (frontString.length() != leaf.str.length()) {

            String tail = leaf.str.substring(i);
            Leaf leftLeaf = new Leaf(frontString);

            Node newParent = currentNode;

            newParent.left = leftLeaf;

            Leaf rightLeaf = new Leaf(tail);

            newParent.right = rightLeaf;
        }

//        if(i>=0 && i< leaf.str.length()){
//            Node left = new Node();
//        }

    }
}
