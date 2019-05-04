package com.aglorithm.visual.maze.domain;

import java.awt.*;

/**
 * @Name: Node
 * @Description: 迷宫节点
 * @Auther: wenjin.dan
 * @Date: 2019/5/2 13:48
 */
public class Node {



    public enum Type{
        //墙壁
        WALL,
        //路
        ROAD,
        //入口
        IN,
        //出口
        OUT;
    }

    //节点类型
    private Node.Type type;
    //颜色
    private Color color;

    public Node(Type type,boolean isMist) {
        this.type = type;
        if(isMist){
            color = Color.BLACK;
            return;
        }
        init();
    }

    /**
     * 初始化颜色
     */
    public void init(){
        if(Type.WALL.equals(type)){
            color = Color.BLUE;
        }
        if(Type.ROAD.equals(type)){
            color = Color.WHITE;
        }
        if(Type.IN.equals(type)){
            color = Color.PINK;
        }
        if(Type.OUT.equals(type)){
            color = Color.GREEN;
        }
    }

    /**
     * 走过此路
     */
    public void runRoad(){
        if(Type.ROAD.equals(type)){
            color = Color.YELLOW;
        }
    }

    /**
     * 是否走过此路
     * @return
     */
    public boolean isRunRoad() {
        if(Type.ROAD.equals(type)){
            if(color == Color.YELLOW){
                return true;
            }
        }
        return false;
    }

    /**
     * 正确道路
     */
    public void trueRoad(){
        if(Type.ROAD.equals(type)){
            color = Color.RED;
        }
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
