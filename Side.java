public class Side {
    private Vertex startVertex;
    private Vertex endVertex;
    private Edge edge;

    public Side(Vertex startVertex, Vertex endVertex, Edge edge) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.edge = edge;
    }

    public Vertex getStartVertex() {
        return this.startVertex;
    }

    public Vertex getEndVertex() {
        return this.endVertex;
    }

    public Edge getEdge() {
        return this.edge;
    }

    // Getters and possibly setters if you want to change vertices or edge
}