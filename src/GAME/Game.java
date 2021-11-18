package GAME;

public class Game {
    private static String gameState;
    private static String endGame;

    public Game() { }

    public void setGameState (String state) { gameState = state; }
    public static String getGameState() { return gameState; }
    public void setEndGame(String state) { endGame = state; }
    public static String getEndGame() { return endGame; }


}
