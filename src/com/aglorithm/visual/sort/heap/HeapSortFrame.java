package com.aglorithm.visual.sort.heap;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: HeapSortFrame
 * @Description: 堆排序
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:10
 */
public class HeapSortFrame extends AigoFrame {

    public int[] arraySort;
    //排序位置
    private int sort=0;

    public HeapSortFrame(int canvasWidth, int canvasHeight, int n) {
        super("堆排序", canvasWidth, canvasHeight);
        arraySort=new int[n];
        for(int i=0 ;i< arraySort.length;i++){
            arraySort[i]= (int) (Math.random()*canvasHeight);
            if(arraySort[i]<=0){
                arraySort[i]=1;
            }
        }
    }

    public void drawIndex(int sort){
        this.sort=sort;
        drawIndex();
    }
    public void drawIndex(){
        repaint();
        AigoVisHelper.pause(10);
    }

    @Override
    protected void draw(Graphics2D g2d) {
        int i = arraySort.length;
        int w =getCanvasWidth()/i;
        for (int x=0 ;x< arraySort.length;x++){
            if(x>=sort){
                AigoVisHelper.setColor(g2d,Color.BLUE);
            }else {
                AigoVisHelper.setColor(g2d,Color.RED);
            }
            AigoVisHelper.fillRectangle(g2d,w*x,getCanvasHeight()-arraySort[x],w-1,arraySort[x]);
        }
    }
}
