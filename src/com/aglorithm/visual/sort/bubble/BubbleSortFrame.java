package com.aglorithm.visual.sort.bubble;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: SelectSortFrame
 * @Description: 冒泡排序
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:10
 */
public class BubbleSortFrame extends AigoFrame {

    public int[] arraySort;
    //排序位置
    private int sort=0;
    //遍历位置
    private int index = -1;

    public BubbleSortFrame(int canvasWidth, int canvasHeight, int n) {
        super("冒泡排序", canvasWidth, canvasHeight);
        arraySort=new int[n];
        for(int i=0 ;i< arraySort.length;i++){
            arraySort[i]= (int) (Math.random()*canvasHeight);
            if(arraySort[i]<=0){
                arraySort[i]=1;
            }
        }
    }

    public void drawIndex(int sort,int index){
        this.index=index;
        this.sort=sort;
        repaint();
        AigoVisHelper.pause(10);
    }

    @Override
    protected void draw(Graphics2D g2d) {
        int i = arraySort.length;
        int w =getCanvasWidth()/i;
        for (int x=0 ;x< arraySort.length;x++){
            if(x<sort){
                AigoVisHelper.setColor(g2d,Color.GRAY);
            }else {
                AigoVisHelper.setColor(g2d,Color.BLUE);
            }
            if(x==index){
                AigoVisHelper.setColor(g2d,Color.YELLOW);
            }
            AigoVisHelper.fillRectangle(g2d,w*x,getCanvasHeight()-arraySort[x],w-1,arraySort[x]);
        }
    }
}
