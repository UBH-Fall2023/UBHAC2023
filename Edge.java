public class Edge {
    public Vertex fromVertex;
    public Vertex toVertex;
    public roadPiece rd;

    public Edge() {
        this.fromVertex = null;
        this.toVertex = null;
        this.rd = null;
    }

    public Vertex getFromVertex() {
        return this.fromVertex;
    }

    public Vertex getToVertex() {
        return this.toVertex;
    }

    public roadPiece getRoad() {
        return this.rd;
    }

    public void setToVertex(Vertex toVertex) {
        this.toVertex = toVertex;
    }

    public void setFromVertex(Vertex fromVertex) {
        this.fromVertex = fromVertex;
    }

}
