package computergraphics.datastructures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import computergraphics.math.Vector3;

public class TriangleMeshTest {
	private TriangleMesh mesh1;
	private TriangleMesh mesh2;

	@Before
	public void setUp() throws Exception {
		mesh1 = new TriangleMesh();
		mesh2 = new TriangleMesh();
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
	public void testEqualsObject1() {
		// Zwei Leere Dreiecksnetze sind gleich. 
		assertEquals("Zwei leere Dreiecksnetze sind gleich",mesh1,mesh2);
	}
	
	@Test
	public void testEqualsObject2() {
		/* Zwei anfänglich leere Dreiecksnetze, zu welchen der gleiche Vertex
		 * hinzufügt wurde sind auch gleich. 
		 */
		Vertex v1 = new Vertex(new Vector3());
		mesh1.addVertex(v1);
		mesh2.addVertex(v1);
		assertEquals(mesh1,mesh2);
	}
	
	@Test
	public void testEqualsObject3() {
		/* Zwei anfänglich leere Dreiecksnetze, zu welchen das gleiche Dreieck 
		 * hinzugefügt wurde sind ebenfalls gleich. TODO test schreiben
		 */
		fail("TODO mit dreiecken testen");
	}

	@Test
	public void testToString1() {
		TriangleMesh mesh = new TriangleMesh();
		String meshAsString = "TriangleMesh(vertexList=[],facetList=[])";
		assertEquals(meshAsString,mesh.toString());
	}
	
	@Test
	public void testToString2() {
		TriangleMesh mesh = new TriangleMesh(); 
		String expected = "TriangleMesh("
				+ "vertexList=["
				+ "Vertex(position=(0,0,0),normal=(1,0,0),color=(0,0,0))"
				+ "],"
				+ "facetList=[]"
				+ ")";
		Vertex v = new Vertex(new Vector3());
		
		mesh.addVertex(v);
		
		assertEquals(expected,mesh.toString());
	}

}
