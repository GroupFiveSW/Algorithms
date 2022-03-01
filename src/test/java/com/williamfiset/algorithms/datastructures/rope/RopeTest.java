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
}
