import java.util.ArrayList;
import java.util.Stack;

public class player {
    public int playerNum;
    public int currentVictoryPoints;
    public int armySize;
    public int longestRoadLength;
    public boolean hasLargestArmy;
    public boolean hasLongestRoad;
    public ArrayList<resourceCard> resources;
    public ArrayList<developmentCard> developmentCards;
    public Stack<developmentCard> playedDevelopmentCards;
    public int settlementCount;
    public int cityCount;

    //Default Constructor
    public player() {
        this.playerNum = 0;
        this.currentVictoryPoints = 0;
        this.armySize = 0;
        this.longestRoadLength = 0;
        this.hasLargestArmy = false;
        this.hasLongestRoad = false;
        this.resources = null;
        this.developmentCards = null;
        this.playedDevelopmentCards = null;
        this.settlementCount = 0;
        this.cityCount = 0;
    }

    //Add to constructor
    public player(int playerNum, int currentVictoryPoints, boolean largestArmy, boolean longestRoad) {
        this.playerNum = playerNum;
        this.currentVictoryPoints = currentVictoryPoints;
        this.armySize = 0;
        this.longestRoadLength = 0;
        this.hasLargestArmy = false;
        this.hasLongestRoad = false;
        this.resources = new ArrayList<resourceCard>();
        this.developmentCards = new ArrayList<developmentCard>();
        this.playedDevelopmentCards = new Stack<developmentCard>();
        this.settlementCount = 0;
        this.cityCount = 0;
    }

    public void setPlayerNum(int newPlayerNum) {
        this.playerNum = newPlayerNum;
    }

    public int getPlayerNum() {
        return this.playerNum;
    }

    public void addVictoryPoints(int increasedPoints) {
        this.currentVictoryPoints += increasedPoints;
    }

    public int getCurrentVictoryPoints() {
        return this.currentVictoryPoints;
    }

    public void addToArmySize(int increasedArmySize) {
        this.armySize += increasedArmySize;
    }

    public void subtractArmySize(int decreasedArmySize) {
        this.armySize -= decreasedArmySize;
    }
    
    public int getArmySize() {
        return this.armySize;
    }

    public void increaseLongestRoad() {
        this.longestRoadLength++;
    }

    public int getLongestRoadLength() {
        return this.longestRoadLength;
    }

    public void setHasLargestArmy(boolean largestArmy) {
        this.hasLargestArmy = largestArmy;
    }

    public boolean getHasLargestArmy() {
        return this.hasLargestArmy;
    }

    public void setHasLongestRoad(boolean longestRoad) {
        this.hasLongestRoad = longestRoad;
    } 

    public boolean getHasLongestRoad() {
        return hasLongestRoad;
    }
    public ArrayList<resourceCard> getResources() {
        return this.resources;
    }

    public ArrayList<developmentCard> getDevelopmentCards() {
        return this.developmentCards;
    }

    public void addResource(resourceCard resource) {
        this.resources.add(resource);
    }

    public void removeResource(resourceCard resource) {
        this.resources.remove(resource);
    }

    public void addDevelopmentCard(developmentCard developmentCard) {
        this.developmentCards.add(developmentCard);
    }

    public void playDevelopmentCard(int index) {
        this.playedDevelopmentCards.add(this.developmentCards.get(index));
        developmentCards.remove(index);
        if (this.playedDevelopmentCards.peek().getType() == "knight") {
            this.armySize++;
        }
    }
}
