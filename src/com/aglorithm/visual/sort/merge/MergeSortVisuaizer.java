package com.aglorithm.visual.sort.merge;

import java.awt.*;
import java.util.Arrays;

/**
 * @Name: MergeSortVisuaizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:23
 */
public class MergeSortVisuaizer {

    private MergeSortFrame frame;

    public MergeSortVisuaizer(int w, int h, int n) {
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            frame= new MergeSortFrame(w,h,n);
            new Thread(()->{
                frame.drawIndex(-1,-1,-1);
                sort(frame.arraySort);
                frame.drawIndex(0,n-1,n-1);
            }).start();
        });
    }

    private void merge(int[] arr,int start,int mid,int end){
        int[] aux = Arrays.copyOfRange(arr, start, end + 1);
        int i=start,j=mid+1;
        for(int k=start; k<=end;k++){
            if(i>mid){
                arr[k]=aux[j-start];
                j++;
            }else if(j>end){
                arr[k]=aux[i-start];
                i++;
            }else if(aux[j-start]>aux[i-start]){
                arr[k]=aux[i-start];
                i++;
            }else{
                arr[k]=aux[j-start];
                j++;
            }
            frame.drawIndex(start,end,k);
        }
    }

    private void sort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        frame.drawIndex(start,end,-1);
        int mid=(end+start)/2;
        sort(arr,start,mid);
        sort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }

}
