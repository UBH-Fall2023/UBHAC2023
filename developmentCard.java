enum DevelopmentCardType {
    KNIGHT,
    VICTORYPOINT,
    ROADBUILDING,
    MONOPOLY,
    YEAROFPLENTY
}

public class developmentCard {
    public DevelopmentCardType typeOfDevelopmentCard;
    public int player;

    public developmentCard(DevelopmentCardType type, int player) {
        this.typeOfDevelopmentCard = type;
        this.player = player;
    }

    public DevelopmentCardType getTypeOfDevelopmentCard() {
        return this.typeOfDevelopmentCard;
    }

    public int getPlayer() {
        return this.player;
    }

    public void setTypeOfDevelopmentCard(DevelopmentCardType type) {
        this.typeOfDevelopmentCard = type;
    }

    public void setPlayer(int player) {
        this.player = player;
    }
}
