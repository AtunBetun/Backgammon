package GAME;

public class Game {

    public static final int WHITE_TURN = 1;
    public static final int BLACK_TURN = -1;
    public static final int COMPLETED_TURN = 1;
    public static final int INCOMPLETE_TURN = -1;

    private int gameState;
    private int currentTurn;
    private boolean hasStarted;
    private int turnStatus;

    private int whiteScore;
    private int blackScore;

    // Default Constructor for Game()
    public Game() {
        whiteScore = 0;
        blackScore = 0;

        setGameState(Backgammon.WELCOME_STATE);
        setHasStarted(Backgammon.GAME_HAS_NOT_STARTED);
    }

    public int getWhiteScore(){
        return whiteScore;
    }
    public void increaseWhiteScore(){
        whiteScore++;
    }
    public void decreaseWhiteScore(){
        whiteScore--;
    }

    public int getBlackScore(){
        return blackScore;
    }
    public void increaseBlackScore(){
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

    public void computePlayerPossibleMoves(){

    }

}
