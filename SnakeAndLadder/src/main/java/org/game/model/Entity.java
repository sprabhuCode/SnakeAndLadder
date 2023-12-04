/*
 * Copyright (c) 2022 VMware, Inc. All Rights Reserved.
 */

package org.game.model;

public abstract class Entity {
    int start;
    int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public abstract String message();

    public abstract String info();
}
