package computergraphics.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleMeshTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddTriangle() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddVertex() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberOfTriangles() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberOfVertices() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTriangle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVertex() {
		fail("Not yet implemented");
	}

	@Test
	public void testClear() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		// Zwei Leere Dreiecksnetze sind gleich. 
		TriangleMesh mesh1 = new TriangleMesh();
		TriangleMesh mesh2 = new TriangleMesh();
		assertEquals("Zwei leere Dreiecksnetze sind gleich",mesh1,mesh2);
	}

	@Test
	public void testToString() {
		TriangleMesh mesh = new TriangleMesh();
		String meshAsString = "TriangleMesh(vertexList=[],facetList=[])";
		assertEquals(meshAsString,mesh.toString());
	}

}
