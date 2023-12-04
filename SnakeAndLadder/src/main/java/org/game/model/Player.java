/*
 * Copyright (c) 2022 VMware, Inc. All Rights Reserved.
 */

package org.game.model;


public class Player {

    String name;

    int position;

    public Player(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
