package GAME;

public class Board {
    private Column[] theColumns;
    private Column blackMiddleColumn;
    private Column whiteMiddleColumn;

    private int diceRoll[];
    private int doubleRoll[];

    public int[] getDiceRoll(){
        return diceRoll;
    }

    public void setDiceRoll(int[] theDiceRoll){
        diceRoll = theDiceRoll;
    }

    public int[] getDoubleRoll(){
        return doubleRoll;
    }

    public void setDoubleRoll(int[] theDoubleRoll){
        diceRoll = theDoubleRoll;
    }

}
