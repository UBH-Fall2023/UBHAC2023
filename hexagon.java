//Set up for each tile on the board
//Types: 0 = sheep, 1 = brick, 2 = stone, 3 = wheat, 4 = wood, 5 = desert

public class hexagon {
    public int corners[] = new int[6];
    public int edge[] = new int[6];
    public String type;
    public int number;
    public boolean robber;

    public hexagon(String type, int number) {
        this.type = type;
        this.number = number;
        this.robber = false;
        for (int i = 0; i < 6; i++) {
            this.edge[i] = 0;
        }
        for (int i = 0; i < 6; i++) {
            this.corners[i] = 0;
        }
    }

    public String getType() {
        return this.type;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean getRobber() {
        return this.robber;
    }

    public void setRobber(boolean robber) {
        this.robber = robber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setEdge(int edge, int player) {
        this.edge[edge] = player;
    }

    public int getEdge(int edge) {
        return this.edge[edge];
    }
}
