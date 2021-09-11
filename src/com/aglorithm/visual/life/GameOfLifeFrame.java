package com.aglorithm.visual.life;

import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: GameOfLifeFrame
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2021/2/8 17:20
 */
public class GameOfLifeFrame extends AigoFrame {

    /**
     * 生成单位大小
     */
    private int size;

    /**
     * 主体
     */
    private GameOfLife gameOfLife;


    public GameOfLifeFrame(GameOfLife gameOfLife) {
        super("GameOfLife", gameOfLife.getSize() < 64 ? gameOfLife.getSize()*10:gameOfLife.getSize()*3, gameOfLife.getSize() < 64 ? gameOfLife.getSize()*10:gameOfLife.getSize()*3);
        size = gameOfLife.getSize() < 64 ? 10:3;
        this.gameOfLife =gameOfLife;
    }

    @Override
    protected void draw(Graphics2D g2d) {
        byte[][] select = gameOfLife.getSelect();
        byte[][] before = gameOfLife.getSelect() == gameOfLife.getSwap1()? gameOfLife.getSwap2():gameOfLife.getSwap1();
        for (int i = 0; i< select.length;i++){
            for (int j = 0;j<select.length;j++){
                byte s = select[i][j];
                if(s==0){
                    if(s!=before[i][j]){
                        //正在死亡
                        AigoVisHelper.setColor(g2d,Color.YELLOW);
                    }else {
                        //死亡
                        AigoVisHelper.setColor(g2d,Color.GRAY);
                    }
                }
                if(s==1){
                    //存活
                    AigoVisHelper.setColor(g2d,Color.GREEN);
                }
                AigoVisHelper.fillRectangle(g2d,i*size,j*size,size,size);
            }
        }
    }
}
