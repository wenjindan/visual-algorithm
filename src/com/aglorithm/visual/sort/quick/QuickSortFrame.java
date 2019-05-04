package com.aglorithm.visual.sort.quick;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: QuickSortFrame
 * @Description: 快速排序
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:10
 */
public class QuickSortFrame extends AigoFrame {

    public int[] arraySort;
    //开始位置
    private int start;
    //结束位置
    private int end;
    //处理位置
    private int p;
    //正在处理元素
    private int px0,px1;
    //处理好的元素
    private boolean[] bs;

    public QuickSortFrame(int canvasWidth, int canvasHeight, int n) {
        super("快速排序", canvasWidth, canvasHeight);
        arraySort=new int[n];
        bs=new boolean[n];
        for(int i=0 ;i< arraySort.length;i++){
            arraySort[i]= (int) (Math.random()*canvasHeight);
            if(arraySort[i]<=0){
                arraySort[i]=1;
            }
            bs[i]=false;
        }
    }

    public void drawIndex(int start,int end,int b,int p,int... px){
        this.start=start;
        this.end=end;
        this.p=p;
        this.px0=px[0];
        if(px.length<2){
            this.px1=px[0];
        }else {
            this.px1=px[1];
        }

        if(b!=-1){
            bs[b]=true;
        }
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
            if(x==p){
                AigoVisHelper.setColor(g2d,Color.BLUE);
            }
            if(px0==x){
                AigoVisHelper.setColor(g2d,Color.YELLOW);
            }
            if(px1==x){
                AigoVisHelper.setColor(g2d,Color.YELLOW);
            }
            if(bs[x]){
                AigoVisHelper.setColor(g2d,Color.red);
            }
            AigoVisHelper.fillRectangle(g2d,w*x,getCanvasHeight()-arraySort[x],w-1,arraySort[x]);
        }
    }
}
