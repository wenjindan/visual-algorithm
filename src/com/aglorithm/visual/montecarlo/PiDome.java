package com.aglorithm.visual.montecarlo;

import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name: PiDome
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 22:33
 */
public class PiDome {
    //半径
    private int r;
    //边长
    private int s;
    //模拟个数
    private int count;

    private List<Point> points=new ArrayList<>();

    public PiDome(int s, int count) {
        this.r = s;
        this.s = s;
        this.count = count;
        run();
    }

    private void run(){
        for (int i= 0 ;i<count; i++){
            if(i%(count/100)==0){
                long redp= points.stream()
                        .filter(p -> Math.pow(p.getX()-r,2)+Math.pow(p.getY()-r,2) <=r*r)
                        .count();
                double pi=4*(double)redp/points.size();
                System.out.println(pi);
            }
            int x= (int) (Math.random()*s);
            int y= (int) (Math.random()*s);
            Point point=new Point(x,y);
            points.add(point);
        }
    }
}
