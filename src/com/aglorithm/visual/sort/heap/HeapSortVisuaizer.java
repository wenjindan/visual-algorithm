package com.aglorithm.visual.sort.heap;

import java.awt.*;
import java.util.Arrays;

/**
 * @Name: InsetSortVisuaizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:23
 */
public class HeapSortVisuaizer {

    private HeapSortFrame frame;

    public HeapSortVisuaizer(int w, int h, int n) {
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            frame= new HeapSortFrame(w,h,n);
            new Thread(()->{
                frame.drawIndex(n);
                run();
                frame.drawIndex(0);
                System.out.println(Arrays.toString(frame.arraySort));
            }).start();
        });
    }

    private void run() {
        int length = frame.arraySort.length;
        //建堆
        for(int i=(length-1-1)/2;i>=0;i--){
            shiftDown(length,i);
        }
        //堆排序
        for(int i=length-1;i>0;i--){
            int i1 = frame.arraySort[0];
            frame.arraySort[0]=frame.arraySort[i];
            frame.arraySort[i]=i1;
            shiftDown(i,0);
            frame.drawIndex(i);
        }
    }

    private void shiftDown(int n, int k) {
        while (2*k+1<n){
            int j=2*k+1;
            if(j+1<n&&frame.arraySort[j+1]>frame.arraySort[j]){
                j++;
            }
            if(frame.arraySort[k]>=frame.arraySort[j]){
                break;
            }
            int i1 = frame.arraySort[k];
            frame.arraySort[k]=frame.arraySort[j];
            frame.arraySort[j]=i1;
            frame.drawIndex();
            k=j;
        }
    }
}
