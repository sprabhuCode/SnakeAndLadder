/*
 * Copyright (c) 2022 VMware, Inc. All Rights Reserved.
 */

package org.game.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
    int cellCount;
    int size;
    Map<Integer, Entity> cell;

    public Board(int size) {
        this.cellCount = size*size;
        this.size = size;
        cell = new HashMap<>();
        createCell();


    }

    public int getCellCount() {
        return cellCount;
    }

    public void setCellCount(int cellCount) {
        this.cellCount = cellCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<Integer, Entity> getCell() {
        return cell;
    }

    public void setCell(Map<Integer, Entity> cell) {
        this.cell = cell;
    }

    private void createCell() {
        for(int i=0;i<size;i++) {
            int max = size-1;
            int min = 2;
            int start = (int)Math.floor(Math.random()*(max-min)+min);
            max = start-1;
            int end = (int)Math.floor(Math.random()*(max-min)+min);
            if(!hasSnakeorLadder(start)) {
               cell.put(start, new Snake(start, end));
            }
            max = size-1;
            end = (int)Math.floor(Math.random()*(max-min)+min);
            max  = end - 1;
            start = (int)Math.floor(Math.random()*(max-min)+min);
            if(!hasSnakeorLadder(start)) {
                cell.put(start, new Ladder(start, end));
            }
        }
    }

    public boolean hasSnakeorLadder(int start) {
        return cell.containsKey(start);
    }

    public Entity getSnakeOrLadder(int start) {
        return cell.get(start);
    }

    public void printBoard() {
        for(int i=size;i>0;i--) {
            if(cell.containsKey(i)) {
                System.out.print( cell.get(i).info());
            } else {
                System.out.print( " " + size + " ");
            }
        }
        if(size%10==0) System.out.println();
    }

}
