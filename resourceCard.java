public class resourceCard {
    public String type;
    public int player;

    public resourceCard(String type, int player) {
        this.type = type;
        this.player = player;
    }

    public String getType() {
        return this.type;
    }

    public int getPlayer() {
        return this.player;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
}