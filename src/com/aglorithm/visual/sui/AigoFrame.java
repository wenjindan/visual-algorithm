package com.aglorithm.visual.sui;

import javax.swing.*;
import java.awt.*;


/**
 * @Name: AigoFrame
 * @Description: 图形窗口
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 15:38
 */
public abstract class AigoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AigoFrame(String title, int canvasWidth, int canvasHeight) {
        super(title);
        this.canvasHeight = canvasHeight;
        this.canvasWidth = canvasWidth;
        //窗口大小
        AigoCanvas aigoCanvas = new AigoCanvas();
        setContentPane(aigoCanvas);
        //固定窗口大小
        this.setResizable(false);
        pack();
        //窗口可视
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    protected abstract void draw(Graphics2D g2d);

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    private class AigoCanvas extends JPanel{

        public AigoCanvas() {
            //开启双缓存
            super(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d= (Graphics2D) g;
            //抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            //绘制
            draw(g2d);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
