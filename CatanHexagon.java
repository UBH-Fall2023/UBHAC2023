enum TerrainType {
    FOREST,
    PASTURE,
    FIELD,
    HILL,
    MOUNTAIN,
    DESERT
    // ... Add other terrain types
}

public class CatanHexagon extends Hexagon {
    public TerrainType terrainType;
    public int number;
    public boolean hasRobber;

    public CatanHexagon(TerrainType terrainType, int number) {
        super(); // Call Hexagon's constructor
        this.terrainType = terrainType;
        this.number = number;
        this.hasRobber = false; // Initially, no hexagon has the robber
    }

    public boolean getRobber() {
        return this.hasRobber;
    }

    public void setRobber(boolean robber) {
        this.hasRobber = robber;
    }

    public void removeRobber() {
        this.hasRobber = false;
    }

    public void addRobber() {
        this.hasRobber = true;
    }
}
