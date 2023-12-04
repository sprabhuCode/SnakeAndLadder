/*
 * Copyright (c) 2022 VMware, Inc. All Rights Reserved.
 */

package org.game.model;

public class Snake extends Entity{

    Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public String message() {
        return " OOPs you are eaten by snake , you move to: " + end ;
    }

    @Override
    public String info() {
        return " Snake [" + start + "-" +end + "] ";
    }
}
