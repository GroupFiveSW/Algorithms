package com.williamfiset.algorithms.datastructures.rope;

import static com.google.common.truth.Truth.assertThat;

import org.junit.*;

public class RopeTest {

    @Test
    public void testEmpty(){
        Rope rope = new Rope("");
        assertThat(rope.root).isNotNull();
        assertThat(rope.root.left).isNull();
        assertThat(rope.root.right).isNull();
    }

    @Test
    public void testOne() {
        Rope rope = new Rope("a");
        assertThat(rope.root.left).isNotNull();
        assertThat(rope.root.left.str).isEqualTo("a");
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
}
