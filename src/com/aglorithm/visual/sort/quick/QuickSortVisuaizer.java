package com.aglorithm.visual.sort.quick;

import java.awt.*;
import java.util.Arrays;

/**
 * @Name: QuickSortVisuaizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:23
 */
public class QuickSortVisuaizer {

    private QuickSortFrame frame;

    public QuickSortVisuaizer(int w, int h, int n) {
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            frame= new QuickSortFrame(w,h,n);
            new Thread(()->{
                frame.drawIndex(-1,-1,-1,-1,-1);
                sort(frame.arraySort);
                frame.drawIndex(-1,-1,-1,-1,-1);
            }).start();
        });
    }

    private int[] partition(int[] arr,int start,int end){
        int x=start;
        if(end-start>1){
            frame.drawIndex(start,end,-1,x,-1);
            x= (int) (Math.random()*(end-start+1))+start;
            int is=frame.arraySort[start];
            frame.arraySort[start]=frame.arraySort[x];
            frame.arraySort[x]=is;
        }
        int v = arr[start];
        frame.drawIndex(start,end,-1,start,-1);
        int j=start;
        int k=end;
        for (int i=start+1;i<=k;i++){
            if(arr[i]!=v){
                if(arr[i]<v){
                    j++;
                    int iv=frame.arraySort[j];
                    frame.arraySort[j]=frame.arraySort[i];
                    frame.arraySort[i]=iv;
                    frame.drawIndex(start,end,-1,start,i,k+1);
                }else{
                    int iv=frame.arraySort[k];
                    frame.arraySort[k]=frame.arraySort[i];
                    frame.arraySort[i]=iv;
                    k--;
                    i--;
                    frame.drawIndex(start,end,-1,start,i,k+1);
                }
            }
        }
        k++;

        int iv=frame.arraySort[start];
        frame.arraySort[start]=frame.arraySort[j];
        frame.arraySort[j]=iv;
        for (int i=j;i<k;i++){
            frame.drawIndex(start,end,i,-1,-1);
        }
        int[] is=new int[]{j-1,k};
        return is;
    }


    private void sort(int[] arr,int start,int end){
        if(start>end){
            return;
        }
        if(start==end){
            frame.drawIndex(start,end,start,-1,-1);
            return;
        }
        frame.drawIndex(start,end,-1,-1,-1);
        int[] p=partition(arr,start,end);
        sort(arr,start,p[0]);
        sort(arr,p[1],end);
    }

    private void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

}
