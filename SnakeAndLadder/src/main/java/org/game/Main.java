package org.game;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Game game = new Game(5);
        game.addPlayers("A");
        game.addPlayers("B");
        game.addPlayers("C");
        game.launchGame();

    }
}