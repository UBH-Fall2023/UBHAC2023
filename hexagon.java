//Set up for each tile on the board
//Types: 0 = sheep, 1 = brick, 2 = stone, 3 = wheat, 4 = wood, 5 = desert

import java.util.ArrayList;

public class Hexagon {
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private ArrayList<Side> sides;

    public Hexagon() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public Side getSide(int sideIndex) {
        return sides.get(sideIndex);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
    public ArrayList<Edge> getEdges() {
        return edges;
    }

}
