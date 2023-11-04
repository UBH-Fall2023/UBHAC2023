package Moves;
import java.io.Serializable;

// Abstract Move class
public abstract class Move implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    // Common attributes for all moves, if any
    String moveType;

    public abstract CatanBoard execute(CatanBoard); // Example method to execute the move
}
