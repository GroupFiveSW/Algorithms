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

    //Test for REQ-1 with single letter at start using Node rope.
    @Test
    public void testInsertAtIndexSingleStart() {
        Rope rope = Rope.toRope("Word");
        rope = rope.insert(0, Rope.toRope("A"));
        assertThat(rope.toString()).isEqualTo("AWord");
        assertThat(rope.index(0)).isEqualTo('A');
    }

    //Test for REQ-1 with single letter at end using Node rope.
    @Test
    public void testInsertAtIndexSingleEnd() {
        Rope rope = Rope.toRope("Word");
        rope = rope.insert(4, Rope.toRope("A"));
        assertThat(rope.toString()).isEqualTo("WordA");
        assertThat(rope.index(4)).isEqualTo('A');
    }

    //Test for REQ-1 with full word at start using Node rope.
    @Test
    public void testInsertAtIndexFullStart() {
        Rope rope = Rope.toRope("Word");
        rope = rope.insert(0, Rope.toRope("Another"));
        assertThat(rope.toString()).isEqualTo("AnotherWord");
        assertThat(rope.index(0)).isEqualTo('A');
    }

    //Test for REQ-1 with full word at end using Node rope.
    @Test
    public void testInsertAtIndexFullEnd() {
        Rope rope = Rope.toRope("Word");
        rope = rope.insert(4, Rope.toRope("Another"));
        assertThat(rope.toString()).isEqualTo("WordAnother");
        assertThat(rope.index(4)).isEqualTo('A');
    }

    //Test for REQ-1 with single letter at start using Leaf rope.
    @Test
    public void testLeafInsertAtIndexSingleStart() {
        Leaf leaf = new Leaf("Word");
        Rope rope = leaf.insert(0, new Leaf("A"));
        assertThat(rope.toString()).isEqualTo("AWord");
        assertThat(rope.index(0)).isEqualTo('A');
    }

    //Test for REQ-1 with single letter at end using Leaf rope.
    @Test
    public void testLeafInsertAtIndexSingleEnd() {
        Leaf leaf = new Leaf("Word");
        Rope rope = leaf.insert(4, new Leaf("A"));
        assertThat(rope.toString()).isEqualTo("WordA");
        assertThat(rope.index(4)).isEqualTo('A');
    }

    //Test for REQ-1 with full word at start using Leaf rope.
    @Test
    public void testLeafInsertAtIndexFullStart() {
        Leaf leaf = new Leaf("Word");
        Rope rope = leaf.insert(0, new Leaf("Another"));
        assertThat(rope.toString()).isEqualTo("AnotherWord");
        assertThat(rope.index(0)).isEqualTo('A');
    }

    //Test for REQ-1 with full word at end using Leaf rope.
    @Test
    public void testLeafInsertAtIndexFullEnd() {
        Leaf leaf = new Leaf("Word");
        Rope rope = leaf.insert(4, new Leaf("Another"));
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
    public void testIndexUnderScore() {
        Rope rope = Rope.toRope("test_test");
        assertThat(rope.index(4)).isEqualTo('_');
    }


    /**
     * Test cases that tests REQ-3 that Split(i,S) * should split the string S into
     * two new strings S1 and S2, S1 = C1,...,Ci and S2 = Ci+1,...Cm
     */
    //Test for REQ-3 that should return two words, split in middle
    @Test
    public void testSplitInMiddle() {
        Rope rope = Rope.toRope("Word");
        RopePair expected = rope.split(1);
        String left = expected.getLeft().toString();
        String right = expected.getRight().toString();

        assertThat(left).isEqualTo("Wo");
        assertThat(right).isEqualTo("rd");
    }

    //Test for REQ-3 that should return two words, split at the end
    @Test
    public void testSplitAtEnd() {
        Rope rope = Rope.toRope("Word");
        RopePair expected = rope.split(3);
        String left = expected.getLeft().toString();
        String right = expected.getRight().toString();

        assertThat(left).isEqualTo("Word");
        assertThat(right).isEqualTo("");
    }

    /**
     * Test cases that tests REQ-4 that Delete(i,j):
     * should delete the substring Ci,...Ci+j-1, from s to
     * form a new string C1,...Ci-1,Ci+j,...,Cm
     */
    //Test for REQ-4 that should a string where the middle is deleted
    @Test
    public void testDeleteInMiddle() {
        Rope rope = Rope.toRope("Word");
        rope = rope.delete(1, 2);
        assertThat(rope.toString()).isEqualTo("Wd");
    }

    //Test for REQ-4 that should return a string where the start is deleted
    @Test
    public void testDeleteInStart() {
        Rope rope = Rope.toRope("Word");
        rope = rope.delete(0, 2);
        assertThat(rope.toString()).isEqualTo("rd");
    }

    //Test for REQ-4 that should return a string where the end is deleted
    @Test
    public void testDeleteInEnd() {
        Rope rope = Rope.toRope("Word");
        rope = rope.delete(1, 3);
        assertThat(rope.toString()).isEqualTo("W");
    }

    //Test for REQ-4 that should return an empty string
    @Test
    public void testDeleteEntireString() {
        Rope rope = Rope.toRope("Word");
        rope = rope.delete(0, 4);
        assertThat(rope.toString()).isEqualTo("");
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
        rope = rope.concat(Rope.toRope(s2));
        assertThat(rope.toString()).isEqualTo(expected);
    }

    /**
     * Test case that tests REQ-6 (that <code>concat(s)</code> concatenates the rope with s).
     * Tests that an empty string concatenates correctly with a non-empty string.
     */
    @Test
    public void testConcatEmptyStart() {
        String s2 = "Second part";
        Rope rope = Rope.toRope("");
        rope = rope.concat(Rope.toRope(s2));
        assertThat(rope.toString()).isEqualTo(s2);
    }

    /**
     * Test case that tests REQ-6 (that <code>concat(s)</code> concatenates the rope with s).
     * Tests that a non-empty string concatenates correctly with an empty string.
     */
    @Test
    public void testConcatEmptyEnd() {
        String s1 = "First part";
        Rope rope = Rope.toRope(s1);
        rope = rope.concat(Rope.toRope(""));
        assertThat(rope.toString()).isEqualTo(s1);
    }

    /**
     * Test case that tests REQ-3 (that <code>split(i)</code> splits the rope at index i).
     * Tests that a normal string is split properly at the correct place.
     */
    @Test
    public void testSplit() {
        String s1 = "First part of the string";
        String s2 = "Second part of it";
        String concat = s1 + s2;
        Rope rope = Rope.toRope(concat);
        RopePair pair = rope.split(s1.length() - 1);
        assertThat(pair.getLeft().toString()).isEqualTo(s1);
        assertThat(pair.getRight().toString()).isEqualTo(s2);
    }

    /**
     * Test case that tests REQ-5 (that <code>report(i, j)</code> returns chars C(i)..C(i+j-1).
     * Tests that a report in the middle of a normal string is reported correctly.
     */
    @Test
    public void testReport() {
        String s = "Lorem_abcd_efgh_ipsum";
        int startIndex = 5, length = 5;
        String expected = s.substring(startIndex, startIndex + length);
        Rope rope = Rope.toRope(s);
        String result = rope.report(startIndex, length).toString();
        assertThat(result).isEqualTo(expected);
    }

    /**
     * Test case that tests REQ-5 (that <code>report(i, j)</code> returns chars C(i)..C(i+j-1).
     * Tests that a report of length 0 results in an empty string.
     */
    @Test
    public void testReportNoLength() {
        String s = "abcdef";
        int startIndex = 2, length = 0;
        Rope rope = Rope.toRope(s);
        String result = rope.report(startIndex, length).toString();
        assertThat(result).isEqualTo("");
    }

    /**
     * Test case that tests REQ-5 (that <code>report(i, j)</code> returns chars C(i)..C(i+j-1).
     * Tests that a leaf report in the middle of a normal string is reported correctly.
     */
    @Test
    public void testReportLeaf() {
        String s = "abcdef";
        int startIndex = 2, length = 2;
        String expected = s.substring(startIndex, startIndex + length);
        Leaf leaf = new Leaf(s);
        String result = leaf.report(startIndex, length).toString();
        assertThat(result).isEqualTo(expected);
    }

    /**
     * Test case that tests REQ-5 (that <code>report(i, j)</code> returns chars C(i)..C(i+j-1).
     * Tests that a leaf report of length 0 results in an empty string.
     */
    @Test
    public void testReportLeafNoLength() {
        String s = "abcdef";
        int startIndex = 2, length = 0;
        String expected = s.substring(startIndex, startIndex + length);
        Leaf leaf = new Leaf(s);
        String result = leaf.report(startIndex, length).toString();
        assertThat(result).isEqualTo(expected);
    }
}
