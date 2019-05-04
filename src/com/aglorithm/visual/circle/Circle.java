package com.aglorithm.visual.circle;

/**
 * @Name: Circle
 * @Description: 小圆圈
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 16:48
 */
public class Circle {
    //位置
    private int x,y;
    //半径
    private int r;
    //速度
    private int vx,vy;

    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    /**
     * 移动
     * @param minx
     * @param miny
     * @param maxx
     * @param maxy
     */
    public void move(int minx, int miny, int maxx, int maxy){
        x += vx;
        y += vy;
        if(x-r<minx){
            x=r;
            vx=-vx;
        }
        if(x+r>=maxx){
            x=maxx-r;
            vx=-vx;
        }
        if(y-r<miny){
            y=r;
            vy=-vy;
        }
        if(y+r>=maxy){
            y=maxy-r;
            vy=-vy;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getR() {
        return r;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }
}
