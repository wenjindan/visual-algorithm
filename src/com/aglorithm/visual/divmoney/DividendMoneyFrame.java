package com.aglorithm.visual.divmoney;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: DividendMoneyFrame
 * @Description: 分钱问题
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 20:33
 */
public class DividendMoneyFrame extends AigoFrame {

    private int[] ints;

    public DividendMoneyFrame(int canvasWidth, int canvasHeight,int[] ints) {
        super("分钱问题", canvasWidth, canvasHeight);
        this.ints = ints;
    }

    public int[] getInts() {
        return ints;
    }

    @Override
    protected void draw(Graphics2D g2d) {

        int w=getCanvasWidth()/ints.length;
        for(int i=0;i<ints.length;i++){
            if(ints[i]>0){
                AigoVisHelper.setColor(g2d,Color.BLUE);
                AigoVisHelper.fillRectangle(g2d,i*w+1,getCanvasHeight()/2-ints[i],w-1,ints[i]);
            }else{
                AigoVisHelper.setColor(g2d,Color.RED);
                AigoVisHelper.fillRectangle(g2d,i*w+1,getCanvasHeight()/2,w-1,-ints[i]);
            }

        }
    }
}
