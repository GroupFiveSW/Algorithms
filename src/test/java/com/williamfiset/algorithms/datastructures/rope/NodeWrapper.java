package com.williamfiset.algorithms.datastructures.rope;

class NodeWrapper {
    private Rope.Node val;
    public NodeWrapper(Rope.Node val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object other){
        if (other instanceof NodeWrapper) {
            return compare(this.val, ((NodeWrapper) other).val);
        }
        if (other instanceof Rope.Node) {
            return compare(this.val, (Rope.Node)other);
        }
        return false;
    }

    private boolean compare(Rope.Node node1, Rope.Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }
        if (node1.count != node2.count) {
            return false;
        }
        if (node1.str != null && !node1.str.equals(node2.str)){
            return false;
        }
        return compare(node1.left, node2.left) && compare(node1.right, node2.right);
    }
}
