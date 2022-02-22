package com.williamfiset.algorithms.geometry;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

public class LineSegmentLineSegmentIntersectionTest {
    /**
     * Test that two lines with no intersection correctly returns empty list.
     */
    @Test
    public void testNoIntersection() {
        LineSegmentLineSegmentIntersection.Pt[] points = {new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(1, 1),
                new LineSegmentLineSegmentIntersection.Pt(1, 1)};
        points = LineSegmentLineSegmentIntersection.lineSegmentLineSegmentIntersection(points[0], points[1], points[2], points[3]);
        assertEquals(0, points.length, "Should return empty array.");
    }

    /**
     * Test case where both lines consist of a single point and overlap.
     */
    @Test
    public void testSingletonIntersections(){
        LineSegmentLineSegmentIntersection.Pt[] points = {new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(0, 0)};
        points = LineSegmentLineSegmentIntersection.lineSegmentLineSegmentIntersection(points[0], points[1], points[2], points[3]);
        assertEquals(1, points.length, "Should return only one point.");
        assertEquals(0, points[0].x, "X coordinate should be 0.");
        assertEquals(0, points[0].y, "Y coordinate should be 0.");
    }

    /**
     * Test case where both lines are equal, and not a single point.
     */
    @Test
    public void testEqualSegments(){
        LineSegmentLineSegmentIntersection.Pt[] points = {new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(5, 5),
                new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(5, 5)};
        points = LineSegmentLineSegmentIntersection.lineSegmentLineSegmentIntersection(points[0], points[1], points[2], points[3]);
        assertEquals(2, points.length, "Should return two points.");
        assertEquals(0, points[0].x, "First X coordinate should be 0.");
        assertEquals(0, points[0].y, "First Y coordinate should be 0.");
        assertEquals(5, points[1].x, "Second X coordinate should be 5.");
        assertEquals(5, points[1].y, "Second Y coordinate should be 5.");
    }

    /**
     * Test case where there is a unique intersection
     */
    @Test
    public void testUniqueIntersection(){
        LineSegmentLineSegmentIntersection.Pt[] points = {new LineSegmentLineSegmentIntersection.Pt(0, 0),
                new LineSegmentLineSegmentIntersection.Pt(5, 5),
                new LineSegmentLineSegmentIntersection.Pt(5, 0),
                new LineSegmentLineSegmentIntersection.Pt(0, 5)};
        points = LineSegmentLineSegmentIntersection.lineSegmentLineSegmentIntersection(points[0], points[1], points[2], points[3]);
        assertEquals(1, points.length, "Should return one point.");
        assertEquals(2.5, points[0].x, "X coordinate should be 2.5.");
        assertEquals(2.5, points[0].y, "Y coordinate should be 2.5.");


    }
}