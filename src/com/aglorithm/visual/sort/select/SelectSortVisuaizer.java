package com.aglorithm.visual.sort.select;

import java.awt.*;
import java.util.Arrays;

/**
 * @Name: SelectSortVisuaizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:23
 */
public class SelectSortVisuaizer {
    public SelectSortVisuaizer(int w,int h, int n) {
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            SelectSortFrame frame= new SelectSortFrame(w,h,n);
            new Thread(()->{
                frame.drawIndex(0,-1,-1);
                for (int i= 0 ;i<n; i++){
                    frame.drawIndex(i,-1,-1);
                    int minindex=i;
                    for (int j=i;j<n;j++){
                        if(frame.arraySort[j]<frame.arraySort[minindex]){
                            minindex = j;
                        }
                        frame.drawIndex(i,j,minindex);
                    }
                    int iv=frame.arraySort[i];
                    frame.arraySort[i]=frame.arraySort[minindex];
                    frame.arraySort[minindex]=iv;
                }
                frame.drawIndex(n,-1,-1);
                System.out.println(Arrays.toString(frame.arraySort));
            }).start();
        });
    }
}
