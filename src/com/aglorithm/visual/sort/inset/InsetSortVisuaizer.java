package com.aglorithm.visual.sort.inset;

import java.awt.*;
import java.util.Arrays;

/**
 * @Name: InsetSortVisuaizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:23
 */
public class InsetSortVisuaizer {
    public InsetSortVisuaizer(int w, int h, int n) {
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            InsetSortFrame frame= new InsetSortFrame(w,h,n);
            new Thread(()->{
                frame.drawIndex(0,-1);
                for (int i= 0 ;i<n; i++){
                    for (int j=i;j>0 && frame.arraySort[j]<frame.arraySort[j-1];j--){
                        int iv=frame.arraySort[j];
                        frame.arraySort[j]=frame.arraySort[j-1];
                        frame.arraySort[j-1]=iv;
                        frame.drawIndex(i+1,j-1);
                    }

                }
                frame.drawIndex(n,-1);
                System.out.println(Arrays.toString(frame.arraySort));
            }).start();
        });
    }
}
