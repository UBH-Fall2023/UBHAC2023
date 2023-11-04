import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addHexagon(Hexagon hexagon, int sideIndex, Hexagon adjacentHexagon) {
        Side newSide = hexagon.getSide(sideIndex);

        if (adjacentHexagon != null) {
            Side adjacentSide = adjacentHexagon.getSide((sideIndex + 3) % 6); // Opposite side index

            mergeVertices(newSide.getStartVertex(), adjacentSide.getStartVertex());
            mergeVertices(newSide.getEndVertex(), adjacentSide.getEndVertex());
            mergeEdges(newSide.getEdge(), adjacentSide.getEdge());
        } else {
            // If there is no adjacent hexagon, add new vertices and edges to the graph
            this.vertices.addAll(hexagon.getVertices());
            this.edges.addAll(hexagon.getEdges());
        }
    }

    public void mergeVertices(Vertex v1, Vertex v2) {
        if (v1.equals(v2)) {
            // They are already the same, no action needed.
            return;
        }

        // Replace all occurrences of v2 with v1 in the edges
        for (Edge edge : edges) {
            if (edge.getToVertex().equals(v2)) {
                edge.setToVertex(v1);
            }
            if (edge.getVertex2().equals(v2)) {
                edge.setVertex2(v1);
            }
        }

        // Remove v2 from the vertices list
        vertices.remove(v2);
    }

    public void mergeEdges(Edge e1, Edge e2) {
        if (e1.equals(e2)) {
            // They are already the same, no action needed.
            return;
        }

        // In this simple example, we'll assume an edge is defined by its vertices
        // If the edges are "equal" in the sense that they connect the same vertices,
        // then we don't need two separate Edge objects.

        // Remove e2 from the edges list, since we are using e1 as the merged edge.
        edges.remove(e2);
    }
}
