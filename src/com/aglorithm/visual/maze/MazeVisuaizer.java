package com.aglorithm.visual.maze;

import com.aglorithm.visual.maze.domain.DataStructure;
import com.aglorithm.visual.maze.domain.MazeMap;

import java.awt.*;

/**
 * @Name: MazeVisuaizer
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/5/1 12:23
 */
public class MazeVisuaizer {

    //方块大小
    private static int SIZE=8;
    private MazeMap mazeMap;

    public MazeVisuaizer(int n, int m, DataStructure generate,DataStructure traversing) {
        mazeMap=new MazeMap(n,m);
        //事件窗口创建，事件分发
        EventQueue.invokeLater(()->{
            MazeFrame frame= new MazeFrame(mazeMap.getN()*SIZE,mazeMap.getM()*SIZE,mazeMap);
            new Thread(()->{
                frame.generate(generate);
                frame.traversing(traversing);
            }).start();
        });
    }
}
