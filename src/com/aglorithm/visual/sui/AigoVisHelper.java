package com.aglorithm.visual.sui;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * @Name: AigoVisHelper
 * @Description: 图形绘制工具
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 16:17
 */
public class AigoVisHelper {
    private AigoVisHelper(){}

    /**
     * 设置画笔宽度
     * @param graphics2D
     * @param width
     */
    public static void setStrokeWidth(Graphics2D graphics2D,int width){
        graphics2D.setStroke(new BasicStroke(width,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }

    /**
     * 设置画笔颜色
     * @param graphics2D
     * @param color
     */
    public static void setColor(Graphics2D graphics2D,Color color){
        graphics2D.setColor(color);
    }

    /**
     * 绘制空心圆
     * @param graphics2D
     * @param x
     * @param y
     * @param r
     */
    public static void strokeCircle(Graphics2D graphics2D,int x,int y, int r){
        Ellipse2D ellipse2D =new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        graphics2D.draw(ellipse2D);
    }

    /**
     * 绘制实心圆
     * @param graphics2D
     * @param x
     * @param y
     * @param r
     */
    public static void fillCircle(Graphics2D graphics2D,int x,int y, int r){
        Ellipse2D ellipse2D =new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        graphics2D.fill(ellipse2D);
    }

    /**
     * 停留时间
     * @param ms
     */
    public static void pause(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 绘制实心矩形
     * @param g2d
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public static void fillRectangle(Graphics2D g2d, int x, int y, int w, int h) {
        Rectangle2D rectangle2D=new Rectangle2D.Double(x,y,w,h);
        g2d.fill(rectangle2D);
    }
}
