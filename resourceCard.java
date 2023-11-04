enum ResourceType {
    WOOD,
    SHEEP,
    WHEAT,
    BRICK,
    ORE
}

public class resourceCard {
    public ResourceType typeOfResource;
    public int player;

    public resourceCard(ResourceType typeOfResource, int player) {
        this.typeOfResource = typeOfResource;
        this.player = player;
    }

    public ResourceType getType() {
        return this.typeOfResource;
    }

    public int getPlayer() {
        return this.player;
    }

    public void setType(ResourceType typeOfResource) {
        this.typeOfResource = typeOfResource;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
}