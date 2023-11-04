package boardPieces;
public class settlerPieces {
    protected int playerID;
    protected int numOfResourceGained;
    protected int victoryPoint;

    //Constructor
    public settlerPieces(int playerID, int numOfResourceGained, int victoryPoint) {
        this.playerID = playerID;
        this.numOfResourceGained = numOfResourceGained;
        this.victoryPoint = victoryPoint;
    }

    //Setter for playerID
    public void setPlayerID(int newPlayerID) {
        this.playerID = newPlayerID;
    }

    //Getter for playerID
    public int getPlayerID() {
        return this.playerID;
    }

    //Setter for settlement upgrade
    public void setNumOfResourceGained(int newNumResourceGain) {
        this.numOfResourceGained = newNumResourceGain;
    }

    //Gets resources when number rolled
    public int getNumOfResourceGained() {
        return this.numOfResourceGained;
    }

    //Setter for victory point of piece
    public void setVictoryPoint(int newVictoryPoint) {
        this.victoryPoint = newVictoryPoint;
    }

    //Gets victory point from piece
    public int getVictoryPoint() {
        return this.victoryPoint;
    }
}
