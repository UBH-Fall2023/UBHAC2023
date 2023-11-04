package UBHAC2023;


class diceRoll {
    private final static int MINDIE = 1;
    private final static int MAXDIE = 6;

    public static int rollDice() {
        int yellowDie = (int) Math.floor(Math.random() * (MAXDIE - MINDIE + 1) + MINDIE);
        return yellowDie;
    }

    public static void main(String args[]) {
        int yellowDie = rollDice();
        int redDie = rollDice();
        int totalDice = yellowDie + redDie;
        System.out.println("Yellow Die: " + yellowDie);
        System.out.println("Red Die: " + redDie);
        System.out.println("Total Die: " + totalDice);
    }
}