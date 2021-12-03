package GAME;

public class Game {

    public static final int WHITE_TURN = 1;
    public static final int BLACK_TURN = -1;
    public static final int COMPLETED_TURN = 1;
    public static final int INCOMPLETE_TURN = -1;
    public static final boolean CAN_BEAR_OFF = true;
    public static final boolean NO_BEAR_OFF = false;

    private int gameState;
    private int currentTurn;
    private boolean hasStarted;
    private int turnStatus;
    private boolean turnBearOff;

    private static int whiteScore;
    private static int blackScore;

    // Default Constructor for Game()
    public Game() {
        whiteScore = 0;
        blackScore = 0;

        setGameState(Backgammon.WELCOME_STATE);
        setHasStarted(Backgammon.GAME_HAS_NOT_STARTED);
        setTurnBearOff(NO_BEAR_OFF);
    }

    public void setTurnBearOff(boolean theBearOff){
        turnBearOff = theBearOff;
    }
    public boolean getTurnBearOff(){
        return turnBearOff;
    }

    public static int getWhiteScore(){
        return whiteScore;
    }
    public static void increaseWhiteScore(){
        whiteScore++;
    }
    public void decreaseWhiteScore(){
        whiteScore--;
    }

    public static int getBlackScore(){
        return blackScore;
    }
    public static void increaseBlackScore(){
        blackScore++;
    }
    public void decreaseBlackScore(){
        blackScore--;
    }

    // Game State Functions
    public void setGameState (int state) {
        gameState = state;
    }
    public int getGameState() {
        return gameState;
    }

    // Has Started Functions
    public void setHasStarted(boolean state) {
        hasStarted = state;
    }
    public boolean getHasStarted() {
        return hasStarted;
    }

    // Current Turn Functions
    public void setCurrentTurn(int theCurrentTurn){
        currentTurn = theCurrentTurn;
    }
    public int getCurrentTurn(){
        return currentTurn;
    }

    public void setTurnStatus(int theTurnStatus){
        turnStatus = theTurnStatus;
    }
    public int getTurnStatus(){
        return turnStatus;

    }

    public void gameComputePossibleMoves(){

        boolean playerHasPossibleTurn = false;
        gameClearPossibleMoves(); // Clean the possible moves for computation

        System.out.println("\n\n## Computing the possible Moves ##\n");
        if (Backgammon.theGame.getCurrentTurn() == Game.WHITE_TURN){

            System.out.println("# Computing WHITE #");
            for (int i = 1; i <= 24; i++){

                // Compute the column possible mvoes of a non empty column that is the turn's color
                if (Backgammon.theBoard.getTheColumns()[i].pieces.size() > 0
                    && Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.WHITE){
                    System.out.printf("\nColumn %s\n", i);

                    Backgammon.theBoard.getTheColumns()[i].columnComputePossibleMoves(i);

                    if (Backgammon.theBoard.getTheColumns()[i].columnGetPlayerHasPossibleTurn()){
                        playerHasPossibleTurn = true;
                    }

                }

            }

            if (Backgammon.theBoard.getWhiteMiddleColumn().pieces.size() > 0){
                // Set all of the buttons to unvisible first
                // Check on the dices which buttons must be turned on for the gettingOfMiddleColumn()
                //

            }


            // If there are no available moves then the turn is complete
            if (!playerHasPossibleTurn){
                Backgammon.theGame.setTurnStatus(COMPLETED_TURN);
            }

        }

        else if (Backgammon.theGame.getCurrentTurn() == Game.BLACK_TURN){
            System.out.println("# Computing BLACK #");
            for (int i = 1; i <= 24; i++){
                // Compute the column possible mvoes of a non empty column that is the turn's color
                if (Backgammon.theBoard.getTheColumns()[i].pieces.size() > 0
                    && Backgammon.theBoard.getTheColumns()[i].getColumnColor() == Column.BLACK){
                    System.out.printf("\nColumn %s\n", i);

                    Backgammon.theBoard.getTheColumns()[i].columnComputePossibleMoves(i);

                    if (Backgammon.theBoard.getTheColumns()[i].columnGetPlayerHasPossibleTurn()){
                        playerHasPossibleTurn = true;
                    }
                }
            }

            if (!playerHasPossibleTurn){
                Backgammon.theGame.setTurnStatus(COMPLETED_TURN);
            }
        }

    }
    public void gameClearPossibleMoves(){
        System.out.println("\n# GAME CLEARING POSSIBLE MOVES #");
        for (int i = 1; i <= 24; i++) {
            Backgammon.theBoard.getTheColumns()[i].columnClearPossibleMoves(i);
        }
    }

}
