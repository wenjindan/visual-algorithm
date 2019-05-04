package com.aglorithm.visual;
import com.aglorithm.visual.circle.CircleVisualizer;
import com.aglorithm.visual.divmoney.DividendMoneyVisualizer;
import com.aglorithm.visual.maze.MazeVisuaizer;
import com.aglorithm.visual.maze.domain.DataStructure;
import com.aglorithm.visual.montecarlo.PiVisualizer;
import com.aglorithm.visual.sort.bubble.BubbleSortVisuaizer;
import com.aglorithm.visual.sort.heap.HeapSortVisuaizer;
import com.aglorithm.visual.sort.inset.InsetSortVisuaizer;
import com.aglorithm.visual.sort.merge.MergeSortVisuaizer;
import com.aglorithm.visual.sort.quick.QuickSortVisuaizer;
import com.aglorithm.visual.sort.select.SelectSortVisuaizer;
import javax.swing.*;
import java.awt.*;

/**
 * @Name: Main
 * @Description:
 * @Auther: wenjin.dan
 * @Date: 2019/4/30 15:13
 */
public class Main {


    private Main() {
        JFrame f = new JFrame("Main");
        JButton b = new JButton("移动的圆");
        b.setBounds(0, 0, 100, 30);
        b.addActionListener(e->new CircleVisualizer(800,800,10));
        f.add(b);
        JButton b1 = new JButton("分钱问题");
        b1.setBounds(100, 0, 100, 30);
        b1.addActionListener(e->new DividendMoneyVisualizer(800,800,80));
        f.add(b1);
        JButton b2 = new JButton("圆周率Π");
        b2.setBounds(200, 0, 100, 30);
        b2.addActionListener(e->new PiVisualizer(800,10000));
        f.add(b2);
        String []ct= {"冒泡排序","选择排序","插入排序","归并排序","快速排序","堆排序"};
        JComboBox jComboBox= new JComboBox(ct);
        jComboBox.setBounds(0,30,100,30);
        f.add(jComboBox);
        JButton b3 = new JButton("开始排序");
        b3.setBounds(100, 30, 100, 30);
        b3.addActionListener(e->{
            Object selectedItem = jComboBox.getSelectedItem();
            if("冒泡排序".equals(selectedItem)){
                new BubbleSortVisuaizer(800,800,80);
            }
            if("选择排序".equals(selectedItem)){
                new SelectSortVisuaizer(800,800,80);
            }
            if("插入排序".equals(selectedItem)){
                new InsetSortVisuaizer(800,800,80);
            }
            if("归并排序".equals(selectedItem)){
                new MergeSortVisuaizer(800,800,80);
            }
            if("快速排序".equals(selectedItem)){
                new QuickSortVisuaizer(800,800,80);
            }
            if("堆排序".equals(selectedItem)){
                new HeapSortVisuaizer(800,800,80);
            }
        });
        f.add(b3);
        String []mg= {"深度优先遍历迷宫(递归)","深度优先遍历迷宫(栈)","广度优先遍历迷宫(队列)"};
        JComboBox jmg= new JComboBox(mg);
        jmg.setBounds(0,60,150,30);
        f.add(jmg);
        JButton b4 = new JButton("生成遍历迷宫");
        b4.setBounds(150, 60, 150, 30);
        b4.addActionListener(e->{
            Object selectedItem = jmg.getSelectedItem();
            if("深度优先遍历迷宫(递归)".equals(selectedItem)){
                new MazeVisuaizer(101,101, DataStructure.RANDOM_QUEUE,DataStructure.RECURSIVE);
            }
            if("深度优先遍历迷宫(栈)".equals(selectedItem)){
                new MazeVisuaizer(101,101, DataStructure.RANDOM_QUEUE,DataStructure.STACK);
            }
            if("广度优先遍历迷宫(队列)".equals(selectedItem)){
                new MazeVisuaizer(101,101, DataStructure.RANDOM_QUEUE,DataStructure.QUEUE);
            }
        });
        f.add(b4);
        f.setSize(300, 250);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(()->{
            Main frame= new Main();
        });
        //移动的圆
        //new CircleVisualizer(800,800,10);
        //100人随即分钱,初始资金100，每人一次拿出一元，n次查看资金变化
        //new DividendMoneyVisualizer(1000,800,100);
        //计算圆周率
        //new PiDome(800,100000);
        //new PiVisualizer(800,10000);
        //冒泡排序
        //new BubbleSortVisuaizer(800,800,80);
        //选择排序
        //new SelectSortVisuaizer(800,800,80);
        //插入排序
        //new InsetSortVisuaizer(800,800,80);
        //归并排序
        //new MergeSortVisuaizer(800,800,80);
        //快速排序
        //new QuickSortVisuaizer(800,800,100);
        //堆排序
        //new HeapSortVisuaizer(800,800,100);
        //迷宫
        //new MazeVisuaizer(101,101, DataStructure.RANDOM_QUEUE,DataStructure.STACK);
    }


}
