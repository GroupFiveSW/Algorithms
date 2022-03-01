package com.williamfiset.algorithms.datastructures.rope;

import static com.google.common.truth.Truth.assertThat;

import org.junit.*;

public class RopeTest {

    /**
     * Tests that an empty string results in a proper structure.
     */
    @Test
    public void testEmpty(){
        Rope.Node expected = node(leaf(""), null);
        Rope rope = new Rope("");
        assertThat(new NodeWrapper(rope.root)).isEqualTo(expected);
    }

    /**
     * Tests that a trivial non empty string results in a simple structure.
     */
    @Test
    public void testOne() {
        Rope.Node expected = node(leaf("a"), null);
        Rope rope = new Rope("a");
        assertThat(new NodeWrapper(rope.root)).isEqualTo(expected);
    }

    /**
     * Tests that an identical instance of the original String object can be reconstructed
     * with the overridden toString method.
     */
    @Test
    public void testToString() {
        String expected = "This is a longer string";
        Rope rope = new Rope(expected);
        assertThat(rope.toString()).isEqualTo(expected);
    }

    /**
     * Test case that tests REQ-2 (that <code>Index(i)</code> should return the character at position i).
     * In the following test case the string is "test" and thus, <code>Index(2)</code> should return "s".
     */
    @Test
    public void testIndex() {
        Rope rope = new Rope("test");
        assertThat(rope.index(2)).isEqualTo('s');
    }

    /**
     * Test case that tests REQ-2 (that <code>Index(i)</code> should return the character at position i).
     * In the following test case the string is "test_test" and thus, <code>Index(4)</code> should return "_".
     */
    @Test
    public void testIndexUnderScore(){
        Rope rope = new Rope("test_test");
        assertThat(rope.index(4)).isEqualTo('_');
    }

    private static int totalCount(Rope.Node node) {
        if (node == null) {
            return 0;
        }
        if (node.str != null) {
            return node.count;
        }
        return totalCount(node.left) + totalCount(node.right);
    }

    private static Rope.Node node(Rope.Node left, Rope.Node right) {
        Rope.Node newNode = new Rope.Node();
        newNode.left = left;
        newNode.right = right;
        newNode.count = totalCount(left);
        return newNode;
    }

    private static Rope.Node leaf(String s) {
        Rope.Node newLeaf = new Rope.Node();
        newLeaf.str = s;
        newLeaf.count = s.length();
        return newLeaf;
    }
}
