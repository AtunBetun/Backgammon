package GAME;

import java.util.Arrays;

import static GAME.Backgammon.*;

public class Moves {

    public static final int EMPTY = 0;
    public static final int FIRST_DICE = 1;
    public static final int SECOND_DICE = 2;
    public static final int COMBINED_DICE = 3;

    public static final boolean POSSIBLE_MOVE = true;
    public static final boolean INVALID_MOVE = false;

    private int[] diceForMove;
    private boolean[] possibleMoves;
    private boolean[] capturePieces;
    private boolean playerHasPossibleTurn;

    public Moves(){
        diceForMove = new int[26];
        possibleMoves = new boolean[26];
        capturePieces = new boolean[26];

        clearPossibleMoves();
    }

    public boolean getPlayerHasPossibleTurn(){
        return playerHasPossibleTurn;
    }
    public int[] getDiceForMove(){
        return diceForMove;
    }
    public boolean[] getPossibleMoves(){
        return possibleMoves;
    }
    public boolean[] getCapturePieces(){
        return capturePieces;
    }

    public void setPossibleMove(int index){
        possibleMoves[index] = true;
    }
    public boolean isMovePossible(int index){
        if (possibleMoves[index]){
            return true;
        }
        return false;
    }
    public void printPossibleMoves(){
        for (int i = 0; i < 26; i++){
            System.out.printf("Column %s: ## possibleMove: %s   ## capturePieces: %s    ## diceForMove: %s\n",
                    i, possibleMoves[i], capturePieces[i], diceForMove[i]);
        }
    }

    public void clearPossibleMoves(){
        Arrays.fill(possibleMoves, INVALID_MOVE);
        Arrays.fill(diceForMove, EMPTY);
        Arrays.fill(capturePieces, INVALID_MOVE);
        playerHasPossibleTurn = false;
    }
    public void computeColumnPossibleMoves(int columnNumber){
        boolean firstDicePossible;
        boolean secondDicePossible;
        boolean combinedDicePossible;

        int firstDiceIndex;
        int secondDiceIndex;
        int combinedDiceIndex;

        System.out.print("# ComputeColumnPossibleMoves #\n");
        System.out.printf("Dice 1: %s    Dice 2: %s\n", theBoard.getDiceRoll()[0], theBoard.getDiceRoll()[1]);

        if (theGame.getCurrentTurn() == Game.WHITE_TURN){

//            System.out.printf("Column %s\n", columnNumber);

            firstDiceIndex = columnNumber + theBoard.getDiceRoll()[0];
            secondDiceIndex = columnNumber + theBoard.getDiceRoll()[1];
            combinedDiceIndex = columnNumber + theBoard.getDiceRoll()[0] + theBoard.getDiceRoll()[1];


            System.out.printf("Dice 1 Index: %s    Dice 2 Index: %s     CombinedDice Index: %s\n", firstDiceIndex, secondDiceIndex, combinedDiceIndex);

            firstDicePossible = isIndexPossible(firstDiceIndex);
            secondDicePossible = isIndexPossible(secondDiceIndex);
            combinedDicePossible = isIndexPossible(combinedDiceIndex);

            // ## FIRST DICE ##
            if (firstDicePossible && theBoard.getDiceRoll()[0] != 0){
                computeDiceIndexPossibleMoves(firstDiceIndex, Column.WHITE, FIRST_DICE);
            }

            // ## SECOND DICE ##
            if (secondDicePossible && theBoard.getDiceRoll()[1] != 0){
                computeDiceIndexPossibleMoves(secondDiceIndex, Column.WHITE, SECOND_DICE);
            }

            // ## COMBINED DICE ## (ONLY ON THE INITIAL DICE ROLL)
            if (combinedDicePossible && theBoard.getDiceRoll()[0] != 0 && theBoard.getDiceRoll()[1] != 0){
                computeDiceIndexPossibleMoves(combinedDiceIndex, Column.WHITE, COMBINED_DICE);
            }

        }

        else if (theGame.getCurrentTurn() == Game.BLACK_TURN){
            firstDiceIndex = columnNumber - theBoard.getDiceRoll()[0];
            secondDiceIndex = columnNumber - theBoard.getDiceRoll()[1];
            combinedDiceIndex = columnNumber - theBoard.getDiceRoll()[0] - theBoard.getDiceRoll()[1];

            firstDicePossible = isIndexPossible(firstDiceIndex);
            secondDicePossible = isIndexPossible(secondDiceIndex);
            combinedDicePossible = isIndexPossible(combinedDiceIndex);

            // ## FIRST DICE ##
            if (firstDicePossible && theBoard.getDiceRoll()[0] != 0){
                computeDiceIndexPossibleMoves(firstDiceIndex, Column.BLACK, FIRST_DICE);
            }

            // ## SECOND DICE ##
            if (secondDicePossible && theBoard.getDiceRoll()[1] != 0){
                computeDiceIndexPossibleMoves(secondDiceIndex, Column.BLACK, SECOND_DICE);
            }

            // ## COMBINED DICE ## (ONLY ON THE INITIAL DICE ROLL)
            if (combinedDicePossible && theBoard.getDiceRoll()[0] != 0 && theBoard.getDiceRoll()[1] != 0){
                computeDiceIndexPossibleMoves(combinedDiceIndex, Column.BLACK, COMBINED_DICE);
            }
        }

    }
    public void computeDiceIndexPossibleMoves(int diceIndex, int checkColor, int theDiceUsed){
        int oppositeColor = 0;

        if (checkColor == Column.WHITE){
            oppositeColor = Column.BLACK;
        }
        if (checkColor == Column.BLACK){
            oppositeColor = Column.WHITE;
        }

        System.out.printf("\n# Dice Index: %s  checkColor: %s  diceUsed: %s #\n", diceIndex, checkColor, theDiceUsed);

        // Empty Column
        if (theBoard.getTheColumns()[diceIndex].pieces.size() == 0){
            possibleMoves[diceIndex] = POSSIBLE_MOVE;
            diceForMove[diceIndex] = theDiceUsed;
            System.out.printf("Empty Column Possible %s\n", diceIndex);
            playerHasPossibleTurn = true;
        }

        // Filled Column
        else if (theBoard.getTheColumns()[diceIndex].pieces.size() != 0
                && theBoard.getTheColumns()[diceIndex].getColumnColor() == checkColor){
            possibleMoves[diceIndex] = POSSIBLE_MOVE;
            diceForMove[diceIndex] = theDiceUsed;
            System.out.printf("Filled Column Possible %s\n", diceIndex);
            playerHasPossibleTurn = true;
        }

        // Steal Column
        else if (theBoard.getTheColumns()[diceIndex].pieces.size() == 1
                && theBoard.getTheColumns()[diceIndex].getColumnColor() == oppositeColor){
            possibleMoves[diceIndex] = POSSIBLE_MOVE;
            capturePieces[diceIndex] = POSSIBLE_MOVE;
            diceForMove[diceIndex] = theDiceUsed;
            System.out.printf("Steal Column Possible %s\n", diceIndex);
            playerHasPossibleTurn = true;
        }
    }
    public boolean isIndexPossible(int index){
        if (index < 1 || index > 24){
            return false;
        }
        return true;
    }


}
