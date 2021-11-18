package GAME;

public class Game {
    private int gameState;
    private boolean hasStarted;

    public Game() {
        setGameState(Backgammon.WELCOME_STATE);

    }

    public void setGameState (int state) { gameState = state; }
    public int getGameState() { return gameState; }
    public void setHasStarted(boolean state) { hasStarted = state; }
    public boolean getHasStarted() { return hasStarted; }

}
