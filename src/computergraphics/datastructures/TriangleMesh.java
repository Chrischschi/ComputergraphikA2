/**
* Praktikum WPCG, Wintersemester 2014/2015
* Gruppe: 
* Andreas Mauritz (Andreas.Mauritz@haw-hamburg.de)
* Christian Schirin (Christian.Schirin@haw-hamburg.de)
* Aufgabe: Aufgabenblatt 2, Aufgabe 1
* Verwendete Quellen: 
* Phillip Jenke: Folien zu Vorlesung 2 - Polygonale Netze (S.6)
* 
*/
package computergraphics.datastructures;

import java.util.List;

/** Diese Klasse repräsentiert ein Polygonales Netz in dem die Polygone alle
 * Dreiecke sind. Es wird bei dieser Implementierung auf Wert der verständlich-
 * keit der Implementation statt Effizienz Wert gelegt.
 * @author Andreas Mauritz, Christian Schirin 
 */
public class TriangleMesh implements ITriangleMesh {
	
	//Ein Polygonales Netz ist definiert durch eine... 
	
	//Knotenliste V...
	List<Vertex> vertexList; 
	
	//und eine Facettenliste F. 
	List<Triangle> facetList; //Unsere Facetten sind alle dreieckig
	

	@Override
	public void addTriangle(Triangle t) {
		// TODO Auto-generated method stub

	}

	@Override
	public int addVertex(Vertex v) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfTriangles() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Triangle getTriangle(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex getVertex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * Calling this method has the same behaviour as this code block:
	 * { V.clear(); F.clear(); }
	 * where V is the vertex list and F is the facet list of the Triangle Mesh.
	 */
	@Override
	public void clear() {
		vertexList.clear();
		facetList.clear();
	}

}
