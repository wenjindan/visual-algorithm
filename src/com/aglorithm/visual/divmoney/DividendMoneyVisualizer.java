package com.aglorithm.visual.divmoney;

import com.aglorithm.visual.circle.Circle;
import com.aglorithm.visual.circle.CircleFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Name: CircleVisualizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 17:58
 */
public class DividendMoneyVisualizer {

    public DividendMoneyVisualizer(int w, int h, int n) {
        int[] ints=new int[n];
        for(int i = 0; i<n;i++){
           ints[i]=100;
        }
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            DividendMoneyFrame frame= new DividendMoneyFrame(w,h,ints);
            new Thread(()->{
                while (frame.isDisplayable()){
                    Arrays.sort(ints);
                    frame.repaint();
                    AigoVisHelper.pause(40);
                    for(int k =0;k<50;k++){
                        for (int i = 0 ;i< ints.length;i++){
                            int j = (int) (Math.random()*ints.length);
                            ints[i]--;
                            ints[j]++;
                        }
                    }
                }
            }).start();
        });
    }
}
