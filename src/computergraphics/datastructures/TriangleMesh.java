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

import java.util.ArrayList;
import java.util.List;

import computergraphics.math.Vector3;

/** Diese Klasse repräsentiert ein Polygonales Netz in dem die Polygone alle
 * Dreiecke sind. Es wird bei dieser Implementierung auf Wert der verständlich-
 * keit der Implementation statt Effizienz Wert gelegt.
 * @author Andreas Mauritz, Christian Schirin 
 */
public class TriangleMesh implements ITriangleMesh {
	
	//Ein Polygonales Netz ist definiert durch eine... 
	
	//Knotenliste V...
	private List<Vertex> vertexList; 
	
	//und eine Facettenliste F. 
	private List<Triangle> facetList; //Unsere Facetten sind alle dreieckig

	/** Initializer. */ 
	{ 
		vertexList = new ArrayList<>();
		facetList = new ArrayList<>();
	}

	@Override
	public void addTriangle(Triangle t) {
		facetList.add(t);
	}

	@Override
	public int addVertex(Vertex v) {
		vertexList.add(v);
		
		/* Da Vertices an das Ende der Liste angehängt werden, ist der Index 
		 * des lezten Vertex der hinzugefügt wurde der letzte erreichbare Index
		 * der Liste. */
		return vertexList.size() - 1;	
	}

	@Override
	public int getNumberOfTriangles() {
		return facetList.size();
	}

	@Override
	public int getNumberOfVertices() {
		return vertexList.size();
	}

	@Override
	public Triangle getTriangle(int index) {
		return facetList.get(index);
	}

	@Override
	public Vertex getVertex(int index) {
		return vertexList.get(index);
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
	
	
	//Aufgabe 2: Dreiecksnormalen ausrechnen und speichern
	public void calculateAllNormals() {
		
		for (Triangle t : facetList){
			
			//alle einzelnen Werte des ersten Vectors des Dreiecks
			double vectorA_index0 = 
					vertexList.get(t.getA()).getPosition().get(0);
			double vectorA_index1 = 
					vertexList.get(t.getA()).getPosition().get(1);
			double vectorA_index2 = 
					vertexList.get(t.getA()).getPosition().get(2);
			
			//alle einzelnen Werte des zweiten Vectors des Dreiecks
			double vectorB_index0 = 
					vertexList.get(t.getB()).getPosition().get(0);
			double vectorB_index1 = 
					vertexList.get(t.getB()).getPosition().get(1);
			double vectorB_index2 = 
					vertexList.get(t.getB()).getPosition().get(2);
			
			
			//alle einzelnen Werte des dritten Vectors des Dreiecks
			double vectorC_index0 = 
					vertexList.get(t.getC()).getPosition().get(0);
			double vectorC_index1 = 
					vertexList.get(t.getC()).getPosition().get(1);
			double vectorC_index2 = 
					vertexList.get(t.getC()).getPosition().get(2);
			
			
			//Vector B minus Vector A
			Vector3 bMinusA = new Vector3(vectorB_index0 - vectorA_index0,
										  vectorB_index1 - vectorA_index1,
										  vectorB_index2 - vectorA_index2);
			
			//Vector C minus Vector A
			Vector3 cMinusA = new Vector3(vectorC_index0 - vectorA_index0,
					  					  vectorC_index1 - vectorA_index1,
					  					  vectorC_index2 - vectorA_index2);
			

			//Kreuzprodukt bMinusA X cMinusA
			double kreuzIndex1 = bMinusA.get(1) * cMinusA.get(2) - bMinusA.get(2) * cMinusA.get(1);
			
			double kreuzIndex2 = bMinusA.get(2) * cMinusA.get(0) - bMinusA.get(0) * cMinusA.get(2);
			
			double kreuzIndex3 = bMinusA.get(0) * cMinusA.get(1) - bMinusA.get(1) * cMinusA.get(0);
			
			
			//Normalenvector zusammensetzen
			Vector3 facetNormal = new Vector3(kreuzIndex1, kreuzIndex2, kreuzIndex3);

			//Normalenvector dem Dreieck hinzufügen
			t.setNormal(facetNormal);			
		}
		
	}
	
	
	
	// Methods for Testing: equals and toString
	
	/**
	 * Use this to check if this triangle mesh is equal to 
	 * another triangle mesh.
	 */
	@Override
	public boolean equals(Object o) {
		//check for reference equality
		if (this == o) {return true;};
		//check if null or different type
		if (!(o instanceof TriangleMesh)) {return false;};
		//Safe cast now possible
		TriangleMesh that = (TriangleMesh)o;
		
		//two meshes are equal if their vertex lists and facet lists are equal.
		return this.vertexList.equals(that.vertexList) && 
			   this.facetList.equals(that.facetList);
	}
	
	
	/** 
	 * Returns a string representation of the Triangle Mesh, 
	 * useful for debugging and testing. 
	 */
	@Override 
	public String toString() {
		return "TODO";
	}
	
	
	
	public static void main(String args[]){
		TriangleMesh mesh1 = new TriangleMesh();
		
		Triangle tri = new Triangle(0, 1, 2);
		
		Vertex vertA = new Vertex(new Vector3(1,2,3));
		Vertex vertB = new Vertex(new Vector3(3,2,1));
		Vertex vertC = new Vertex(new Vector3(2,1,3));
		
		
		mesh1.addTriangle(tri);
		
		mesh1.addVertex(vertA);
		mesh1.addVertex(vertB);
		mesh1.addVertex(vertC);
		
		mesh1.calculateAllNormals();
		
		System.out.println("normal: " + tri.getNormal().toString());		
	}

}
