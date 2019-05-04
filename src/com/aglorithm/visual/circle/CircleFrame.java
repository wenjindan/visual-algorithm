package com.aglorithm.visual.circle;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: CircleFrame
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 17:20
 */
public class CircleFrame extends AigoFrame {
    //小球
    private Circle circles[];

    public CircleFrame(int w,int h,Circle circles[]) {
        super("圆圈", w, h);
        this.circles=circles;
    }

    @Override
    protected void draw(Graphics2D g2d) {
        AigoVisHelper.setColor(g2d,Color.RED);
        for(Circle circle : circles){
            AigoVisHelper.strokeCircle(g2d,circle.getX(),circle.getY(),circle.getR());
        }
    }

    public Circle[] getCircles() {
        return circles;
    }
}
