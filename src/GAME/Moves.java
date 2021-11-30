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

    private int[] bearOffDice;
    private int[] diceForMove;
    private boolean[] possibleMoves;
    private boolean[] capturePieces;


    private boolean playerHasPossibleTurn;
    private boolean whiteBearOff;
    private boolean blackBearOff;
    private boolean canBearOff;

    public Moves(){
        bearOffDice = new int[2];
        diceForMove = new int[26];
        possibleMoves = new boolean[26];
        capturePieces = new boolean[26];

        clearPossibleMoves();
    }


    public boolean getBlackBearOff(){
        return blackBearOff;
    }
    public boolean getWhiteBearOff(){
        return whiteBearOff;
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
        Arrays.fill(capturePieces, INVALID_MOVE);
        Arrays.fill(diceForMove, EMPTY);
        Arrays.fill(bearOffDice, EMPTY);

        playerHasPossibleTurn = false;
        whiteBearOff = false;
        blackBearOff = false;
        canBearOff = false;
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
            // CHeck if bear off is possible
            checkIfBearOffPossible(Game.WHITE_TURN, columnNumber);

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
            // CHeck if bear off is possible
            checkIfBearOffPossible(Game.BLACK_TURN, columnNumber);

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
    public void checkIfBearOffPossible(int GameTurn, int columnNumber){
        // White turn
        if (GameTurn == Game.WHITE_TURN){
            int homeBaseChipSize =  theBoard.getTheColumns()[19].pieces.size() +
                                    theBoard.getTheColumns()[20].pieces.size() +
                                    theBoard.getTheColumns()[21].pieces.size() +
                                    theBoard.getTheColumns()[22].pieces.size() +
                                    theBoard.getTheColumns()[23].pieces.size() +
                                    theBoard.getTheColumns()[24].pieces.size();

            if (homeBaseChipSize == 15 && !whiteBearOff){
                whiteBearOff = true;
            }

            // If white bear off is possible then check this piece for bear off
            if (whiteBearOff){
                // Clean First Dice Bear Off
                if (theBoard.getDiceRoll()[0] == 24 - columnNumber){
                    canBearOff = true;

                }

                // Clean Second Dice Bear Off
                else if (theBoard.getDiceRoll()[1] == 24 - columnNumber){
                    canBearOff = true;
                }

//                // A higher number was rolled
                else {
                    // BiggestDiceRoll from the current turn
                    int biggestDiceRoll = Math.max(theBoard.getDiceRoll()[0], theBoard.getDiceRoll()[1]);

                    boolean dirtyBearOff = true;
                    // Check if the dice rolled bigger than this particular column
                    if (biggestDiceRoll > 25 - columnNumber){
                        for (int y = 19; y < columnNumber; y++){
                            if (theBoard.getTheColumns()[y].pieces.size() != 0){
                                dirtyBearOff = false;
                            }
                        }
                    }

                    if (dirtyBearOff){
                        canBearOff = true;
                    }

                }

            }

        }

        // Black turn
        else if (GameTurn == Game.BLACK_TURN){
            int homeBaseChipSize =  theBoard.getTheColumns()[1].pieces.size() +
                                    theBoard.getTheColumns()[2].pieces.size() +
                                    theBoard.getTheColumns()[3].pieces.size() +
                                    theBoard.getTheColumns()[4].pieces.size() +
                                    theBoard.getTheColumns()[5].pieces.size() +
                                    theBoard.getTheColumns()[6].pieces.size();
            // If Black Bear off is possible then check this piece for bear off
            if (homeBaseChipSize == 15 && !whiteBearOff){
                blackBearOff = true;
            }

            if (blackBearOff){
                // Clean First Dice Bear Off
                if (theBoard.getDiceRoll()[0] == columnNumber){
                    canBearOff = true;
                    bearOffDice[0] = FIRST_DICE;
                }

                // Clean Second Dice Bear Off
                else if (theBoard.getDiceRoll()[1] == columnNumber){
                    canBearOff = true;
                    bearOffDice[1] = SECOND_DICE;
                }

//                // A higher number was rolled
                else {
                    // BiggestDiceRoll from the current turn
                    int biggestDiceRoll = Math.max(theBoard.getDiceRoll()[0], theBoard.getDiceRoll()[1]);

                    boolean dirtyBearOff = true;
                    // Check if the dice rolled bigger than this particular column

//                    dice roll: 6      column: 4
//                    columnDifference: 2
//                    Following will check columns 6 and 5 on this example
                    int columnDifference = biggestDiceRoll - columnNumber;
                    int indexCounter = 6;
                    if (biggestDiceRoll > columnNumber){
                        for (int y = 1; y <= columnDifference; y++){
                            if (theBoard.getTheColumns()[indexCounter].pieces.size() != 0){
                                dirtyBearOff = false;
                            }
                            indexCounter--;
                        }
                    }

                    if (dirtyBearOff){
                        canBearOff = true;
                        if (biggestDiceRoll == theBoard.getDiceRoll()[0]){
                            bearOffDice[0] = FIRST_DICE;
                        }
                        else{
                            bearOffDice[1] = SECOND_DICE;
                        }

                    }

                }

            }


        }

    }

}
