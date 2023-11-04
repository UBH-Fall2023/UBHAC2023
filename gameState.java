import java.util.ArrayList;

public class gameState {
    public int turn = 0;
    public ArrayList<hexagon> board;
    public ArrayList<player> players;

    public gameState(player player1, player player2, player player3, player player4) {
        this.board = new ArrayList<hexagon>();
        board.add(new hexagon("stone", 10));
        board.add(new hexagon("sheep", 2));
        board.add(new hexagon("wood", 9));
        board.add(new hexagon("wheat", 12));
        board.add(new hexagon("brick", 6));
        board.add(new hexagon("sheep", 4));
        board.add(new hexagon("brick", 10));
        board.add(new hexagon("wheat", 9));
        board.add(new hexagon("wood", 11));
        board.add(new hexagon("desert", 0));
        board.add(new hexagon("wood", 3));
        board.add(new hexagon("stone", 8));
        board.add(new hexagon("wood", 8));
        board.add(new hexagon("stone", 3));
        board.add(new hexagon("wheat", 4));
        board.add(new hexagon("sheep", 5));
        board.add(new hexagon("brick", 5));
        board.add(new hexagon("wheat", 6));
        board.add(new hexagon("sheep", 11));
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

    }

    public player getPlayer(int id) {
        return players.get(id);
    }

    public void nextTurn() {
        turn++;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public ArrayList<hexagon> getBoard() {
        return board;
    }

}