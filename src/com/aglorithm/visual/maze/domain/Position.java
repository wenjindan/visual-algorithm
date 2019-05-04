package com.aglorithm.visual.maze.domain;

/**
 * @Name: Position
 * @Description: 点
 * @Auther: wenjin.dan
 * @Date: 2019/5/2 16:25
 */
public class Position {
    private int x,y;

    private Position next;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getNext() {
        return next;
    }

    public void setNext(Position next) {
        this.next = next;
    }
}
