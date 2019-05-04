package com.aglorithm.visual.sort.merge;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: MergeSortFrame
 * @Description: 归并排序排序
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:10
 */
public class MergeSortFrame extends AigoFrame {

    public int[] arraySort;
    //开始位置
    private int start=0;
    //结束位置
    private int end = -1;
    //中间位置
    private int mid = -1;

    public MergeSortFrame(int canvasWidth, int canvasHeight, int n) {
        super("归并排序", canvasWidth, canvasHeight);
        arraySort=new int[n];
        for(int i=0 ;i< arraySort.length;i++){
            arraySort[i]= (int) (Math.random()*canvasHeight);
            if(arraySort[i]<=0){
                arraySort[i]=1;
            }
        }
    }

    public void drawIndex(int start,int end,int mid){
        this.start=start;
        this.end=end;
        this.mid=mid;
        repaint();
        AigoVisHelper.pause(10);
    }

    @Override
    protected void draw(Graphics2D g2d) {
        int i = arraySort.length;
        int w =getCanvasWidth()/i;
        for (int x=0 ;x< arraySort.length;x++){
            if(x>=start && x<=end){
                AigoVisHelper.setColor(g2d,Color.GREEN);
            }else {
                AigoVisHelper.setColor(g2d,Color.GRAY);
            }
            if(x>=start && x<= mid){
                AigoVisHelper.setColor(g2d,Color.red);
            }
            AigoVisHelper.fillRectangle(g2d,w*x,getCanvasHeight()-arraySort[x],w-1,arraySort[x]);
        }
    }
}
