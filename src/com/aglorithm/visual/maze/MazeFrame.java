package com.aglorithm.visual.maze;

import com.aglorithm.visual.maze.domain.DataStructure;
import com.aglorithm.visual.maze.domain.MazeMap;
import com.aglorithm.visual.maze.domain.Node;
import com.aglorithm.visual.sui.AigoFrame;
import com.aglorithm.visual.sui.AigoVisHelper;

import java.awt.*;

/**
 * @Name: MazeFrame
 * @Description: 迷宫
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:10
 */
public class MazeFrame extends AigoFrame {

    private MazeMap mazeMap;

    public MazeFrame(int canvasWidth, int canvasHeight,MazeMap mazeMap) {
        super("迷宫", canvasWidth, canvasHeight);
        this.mazeMap=mazeMap;

    }

    /**
     * 生成迷宫
     */
    public void generate(DataStructure structure){
        mazeMap.generate(this,structure);
    }

    /**
     * 通过迷宫
     */
    public void traversing(DataStructure structure){
        mazeMap.traversing(this,structure);
    }

    public void drawIndex(){
        repaint();
        AigoVisHelper.pause(5);
    }

    @Override
    protected void draw(Graphics2D g2d) {
        int w=getCanvasWidth()/mazeMap.getM();
        int h=getCanvasHeight()/mazeMap.getN();
        for (int i=0;i<mazeMap.getN();i++){
            for(int j=0;j<mazeMap.getM();j++){
                AigoVisHelper.setColor(g2d,mazeMap.getNodes(i,j).getColor());
                AigoVisHelper.fillRectangle(g2d,j*w,i*h,w,h);
            }
        }
    }
}
