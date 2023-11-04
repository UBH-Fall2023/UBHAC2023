public class Vertex {
    public int id;
    public boardPiece piece;

    public Vertex(int id) {
        this.id = id;
        this.piece = null;
    }

    public settlerPiece getPiece() {
        return this.piece;
    }

    public void setPiece(settlerPiece piece) {
        this.piece = piece;
    }

    public void removePiece() {
        this.piece = null;
    }
}