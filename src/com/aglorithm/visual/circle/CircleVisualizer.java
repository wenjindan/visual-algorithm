package com.aglorithm.visual.circle;

import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Name: CircleVisualizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 17:58
 */
public class CircleVisualizer {

    public CircleVisualizer(int w,int h,int n) {
        Circle[] circles = new Circle[n];
        int r=50;
        for(int i = 0; i<n;i++){
            int x= (int) (Math.random()*(w-2*r)+r);
            int y= (int) (Math.random()*(h-2*r)+r);
            int vx= (int) (Math.random()*11-5);
            int vy= (int) (Math.random()*11-5);
            circles[i]= new Circle(x,y,r,vx,vy);
        }
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            CircleFrame frame= new CircleFrame(w,h,circles);
            new Thread(()->{
                while (frame.isDisplayable()){
                    frame.repaint();
                    AigoVisHelper.pause(20);
                    for (Circle circle : frame.getCircles()){
                        circle.move(0,0,w,h);
                    }
                }
            }).start();
        });
    }
}
