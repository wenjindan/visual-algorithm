package com.aglorithm.visual.montecarlo;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Name: PiFrem
 * @Description: 求圆周率
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 21:21
 */
public class PiFrame extends AigoFrame {

    private List<Point> points =new ArrayList<>();
    private int r;
    JLabel jLabel;

    public PiFrame(int h) {
        super("求圆周率", h, h);
        this.r=h/2;
        jLabel =new JLabel();
        jLabel.setLocation(0,0);
        jLabel.setBackground(Color.white);
        add(jLabel);
    }

    @Override
    protected void draw(Graphics2D g2d) {
        AigoVisHelper.setStrokeWidth(g2d,3);
        AigoVisHelper.setColor(g2d,Color.BLUE);
        AigoVisHelper.strokeCircle(g2d,r,r,r);
        int redp=0;
        for(int i=0 ;i<points.size();i++){
            Point point=points.get(i);
            boolean contain = contain(point);
            AigoVisHelper.setColor(g2d,contain?Color.RED:Color.BLUE);
            if(contain){
                redp++;
            }
            AigoVisHelper.fillCircle(g2d,point.x,point.y,3);
        }
        if(!points.isEmpty()){
            double pi=4*(double)redp/points.size();
            jLabel.setText("Π："+pi);
        }
    }

    private boolean contain(Point p){
        return Math.pow(p.getX()-r,2)+Math.pow(p.getY()-r,2) <=r*r;
    }

    public List<Point> getPoints() {
        return points;
    }
}
