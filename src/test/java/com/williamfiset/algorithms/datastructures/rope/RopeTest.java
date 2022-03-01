package com.williamfiset.algorithms.datastructures.rope;

import static com.google.common.truth.Truth.assertThat;

import org.junit.*;

public class RopeTest {
    /**
     * Tests that an empty instance of the original String object can be reconstructed
     * with the overridden toString method.
     */
    @Test
    public void testToStringEmpty() {
        String expected = "";
        Rope rope = Rope.toRope(expected);
        assertThat(rope.toString()).isEqualTo(expected);
    }


    /**
     * Tests that an identical instance of the original String object can be reconstructed
     * with the overridden toString method.
     */
    @Test
    public void testToString() {
        String expected = "This is a longer string";
        Rope rope = Rope.toRope(expected);
        assertThat(rope.toString()).isEqualTo(expected);
    }


    /**
     * Test cases that tests REQ-1 that Insert(i,S)
     * should insert the string S beginning at position i in the string s, to form a new string
     */

    //Test for REQ-1 with single letter at start
    @Test
    public void testInsertAtIndexSingleStart(){
        Rope rope = new Rope("Word");
        rope.insert(0,"A");
        assertThat(rope.toString()).isEqualTo("AWord");
        assertThat(rope.index(0)).isEqualTo('A');
    }

    //Test for REQ-1 with single letter at end
    @Test
    public void testInsertAtIndexSingleEnd(){
        Rope rope = new Rope("Word");
        rope.insert(4,"A");
        assertThat(rope.toString()).isEqualTo("WordA");
        assertThat(rope.index(4)).isEqualTo('A');
    }

    //Test for REQ-1 with full word at start
    @Test
    public void testInsertAtIndexFullStart(){
        Rope rope = new Rope("Lorem");
        rope.insert(0,"Another");
        assertThat(rope.toString()).isEqualTo("AnotherWord");
        assertThat(rope.index(0)).isEqualTo('A');
    }

    //Test for REQ-1 with full word at end
    @Test
    public void testInsertAtIndexFullEnd(){
        Rope rope = new Rope("Word");
        rope.insert(4,"Another");
        assertThat(rope.toString()).isEqualTo("WordAnother");
        assertThat(rope.index(4)).isEqualTo('A');
    }

    /**
     * Test case that tests REQ-2 (that <code>Index(i)</code> should return the character at position i).
     * In the following test case the string is "test" and thus, <code>Index(2)</code> should return "s".
     */
    @Test
    public void testIndex() {
        Rope rope = Rope.toRope("test");
        assertThat(rope.index(2)).isEqualTo('s');
    }

    /**
     * Test case that tests REQ-2 (that <code>Index(i)</code> should return the character at position i).
     * In the following test case the string is "test_test" and thus, <code>Index(4)</code> should return "_".
     */
    @Test
    public void testIndexUnderScore(){
        Rope rope = Rope.toRope("test_test");
        assertThat(rope.index(4)).isEqualTo('_');
    }

    /**
     * Test case that tests REQ-6 (that <code>concat(s)</code> concatenates the rope with s).
     * Tests that a small string concatenates correctly with another small string.
     */
    @Test
    public void testConcat() {
        String s1 = "First part of the string";
        String s2 = "Second part of it";
        String expected = s1 + s2;
        Rope rope = Rope.toRope(s1);
        rope.concat(Rope.toRope(s2));
        assertThat(rope.toString()).isEqualTo(expected);
    }

    private static int totalCount(Rope rope) {
        if (rope == null) {
            return 0;
        }
        if (rope instanceof Leaf) {
            return ((Leaf) rope).str.length();
        }
        Node node = (Node)rope;
        return totalCount(node.left) + totalCount(node.right);
    }

    private static Node node(Rope left, Rope right) {
        Node newNode = new Node();
        newNode.left = left;
        newNode.right = right;
        newNode.count = totalCount(left);
        return newNode;
    }

    private static Leaf leaf(String s) {
        return new Leaf(s);
    }
}
