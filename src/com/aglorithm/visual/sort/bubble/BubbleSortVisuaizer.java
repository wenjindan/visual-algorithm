package com.aglorithm.visual.sort.bubble;

import java.awt.*;
import java.util.Arrays;

/**
 * @Name: SelectSortVisuaizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:23
 */
public class BubbleSortVisuaizer {
    public BubbleSortVisuaizer(int w, int h, int n) {
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            BubbleSortFrame frame= new BubbleSortFrame(w,h,n);
            new Thread(()->{
                frame.drawIndex(n,-1);
                for (int i= 0 ;i<n; i++){
                    frame.drawIndex(n-i,-1);
                    for (int j=0;j<n-i-1;j++){
                        if(frame.arraySort[j]>frame.arraySort[j+1]){
                            int iv=frame.arraySort[j];
                            frame.arraySort[j]=frame.arraySort[j+1];
                            frame.arraySort[j+1]=iv;
                        }
                        frame.drawIndex(n-i,j);
                    }
                }
                frame.drawIndex(0,-1);
                System.out.println(Arrays.toString(frame.arraySort));
            }).start();
        });
    }
}
