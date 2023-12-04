/*
 * Copyright (c) 2022 VMware, Inc. All Rights Reserved.
 */

package org.game;

import org.game.model.Board;
import org.game.model.Entity;
import org.game.model.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Game {
    Board board;

    int dimension;

    Queue<Player> queue;
    Queue<Player> winner;

    List<Player> players;

    Game(int size)  {
       this.dimension = size*size;
       this.board = new Board(size);
       this.queue = new LinkedList<>();
       this.winner = new LinkedList<>();
       this.players = new ArrayList<>();
    }

    public void addPlayers(String name) {
        Player player = new Player(name);
        queue.add(player);
        players.add(player);

    }


    public void launchGame() {
        board.printBoard();
        while(queue.size() > 1) {
            Player player = queue.poll();
            System.out.println();
            System.out.println("Player: " + player.getName() + " turn to roll dice ");
            System.out.println("Press Enter to roll the dice.");
            Scanner sc = new Scanner(System.in);
            char c = sc.next().charAt(0);
            makeMove(player);
            if(player.getPosition() == dimension){
                System.out.println(player.getName() + " Finished the game!!!");
                winner.add(player);
            } else {
                queue.add(player);
            }
            printPositions();
        }
        printWinners();
    }

    public int rollDice() {
        int min = 1;
        int max = 6;
        return (int) Math.floor(Math.random()*(max-min+1)+min);
    }

    public void makeMove(Player player) {
        int rollNumber = rollDice();
        int currentPosition = player.getPosition();

        System.out.println(" Player: " + player.getName() + " position: " + currentPosition);
        System.out.println(" Player: " + player.getName() + " rolled: " + rollNumber);

        int nextPosition = currentPosition + rollNumber;
        if(nextPosition <= dimension) {
            if(board.hasSnakeorLadder(nextPosition)) {
                Entity entity = board.getSnakeOrLadder(nextPosition);
                entity.message();
                nextPosition = entity.getEnd();
            }
        } else {
            System.out.println("Try again in the next turn.");
            nextPosition = currentPosition;
        }
        player.setPosition(nextPosition);
    }

    private void printPositions() {
        for(Player player : players) {
            System.out.println(player.getName()+":"+player.getPosition());
        }

    }

    private void printWinners() {
        while(!queue.isEmpty()) {
            Player player = queue.poll();
            System.out.println(player.getName()+ " ");
        }
    }
}
