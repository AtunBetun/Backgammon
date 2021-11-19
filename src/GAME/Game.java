package GAME;

public class Game {

    public static final int WHITE_TURN = 1;
    public static final int BLACK_TURN = -1;

    private int gameState;
    private int currentTurn;
    private boolean hasStarted;

    // Default Constructor for Game()
    public Game() {
        setGameState(Backgammon.WELCOME_STATE);
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

}
