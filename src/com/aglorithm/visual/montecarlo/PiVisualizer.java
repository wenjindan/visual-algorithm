package com.aglorithm.visual.montecarlo;

import com.aglorithm.visual.circle.Circle;
import com.aglorithm.visual.circle.CircleFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: PiVisualizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 17:58
 */
public class PiVisualizer {

    public PiVisualizer(int h, int n) {
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            PiFrame frame= new PiFrame(h);
            new Thread(()->{
                for (int i= 0 ;i<n; i++){
                    if(i%100==0){
                        frame.repaint();
                        AigoVisHelper.pause(40);
                    }
                    int x= (int) (Math.random()*h);
                    int y= (int) (Math.random()*h);
                    Point point=new Point(x,y);
                    frame.getPoints().add(point);
                }
            }).start();
        });
    }
}
