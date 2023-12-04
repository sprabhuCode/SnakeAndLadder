/*
 * Copyright (c) 2022 VMware, Inc. All Rights Reserved.
 */

package org.game.model;

public class Ladder extends Entity {


    Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String message() {
       return "Hey you are going up on a Ladder to: " + start;
    }

    @Override
    public String info() {
        return " Ladder [" + start + "-" +end + "] ";
    }
}
