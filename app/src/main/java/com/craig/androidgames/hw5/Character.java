package com.craig.androidgames.hw5;

import com.craig.androidgames.framework.Pixmap;

/**
 * Created by craig on 12/8/2015.
 */
public class Character  {
    private Pixmap  player;
    private int width;
    private int height;
    private int x;
    private int y;

    Character(Pixmap p, int x, int y) {
        player = p;
        width = player.getWidth();
        height = player.getHeight();
        this.x = x;
        this.y = y;
    }
    Pixmap get() {
        return player;
    }
    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }


}
