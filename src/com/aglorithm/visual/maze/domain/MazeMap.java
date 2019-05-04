package com.aglorithm.visual.maze.domain;

import com.aglorithm.visual.maze.MazeFrame;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Name: MazeMap
 * @Description: 迷宫地图
 * @Auther: wenjin.dan
 * @Date: 2019/5/2 13:49
 */
public class MazeMap {

    /**
     * 方向
     */
    private static final int d[][]={{-1,0},{0,1},{1,0},{0,-1}};

    private Node[][] nodes;
    /**
     * 迷宫的大小
     */
    private int n,m;

    /**
     * 迷宫入口位置
     */
    private int inx,iny;
    /**
     * 迷宫出口位置
     */
    private int outx,outy;

    public MazeMap(int n, int m) {
        init(n, m);

    }
    /**
     * 初始化迷宫
     * @param n
     * @param m
     */
    private void init(int n, int m) {
        if(n%2!=1){
            n++;
        }
        if(m%2!=1){
            m++;
        }
        this.n = n;
        this.m = m;
        nodes=new Node[n][m];
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i%2==1&&j%2==1){
                    nodes[i][j]=new Node(Node.Type.ROAD,true);
                }else {
                    nodes[i][j]=new Node(Node.Type.WALL,true);
                }
            }
        }
        inx=1;
        iny=0;
        outx=n-2;
        outy=m-1;
        nodes[inx][iny]=new Node(Node.Type.IN,false);
        nodes[outx][outy]=new Node(Node.Type.OUT,false);

    }



    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    /**
     * 获取迷宫位置节点
     * @param n
     * @param m
     * @return
     */
    public Node getNodes(int n,int m) {
        return nodes[n][m];
    }

    /**
     * 点是否在迷宫内
     * @param x
     * @param y
     * @return
     */
    public boolean isArea(int x,int y){
        return x>=0 && x<n && y>=0 && y<m;
    }

    public int getInx() {
        return inx;
    }

    public int getIny() {
        return iny;
    }

    public int getOutx() {
        return outx;
    }

    public int getOuty() {
        return outy;
    }

    /**
     * 生成迷宫
     * @param mazeFrame
     */
    public void generate(MazeFrame mazeFrame,DataStructure structure) {
        mazeFrame.drawIndex();
        if(DataStructure.RECURSIVE.equals(structure)){
            recursive(inx,iny+1,mazeFrame);
        }
        if(DataStructure.STACK.equals(structure)){
            stack(mazeFrame);
        }
        if(DataStructure.QUEUE.equals(structure)){
            queue(mazeFrame,true);
        }
        if(DataStructure.RANDOM_QUEUE.equals(structure)){
            queue(mazeFrame,false);
        }
        initRoad();
        mazeFrame.drawIndex();
    }

    /**
     * 队列生成迷宫
     * @param mazeFrame
     * @param b 是否随机
     */
    private void queue(MazeFrame mazeFrame, boolean b) {
        LinkedList<Position> queue =new LinkedList<>();
        Position fist=new Position(inx,iny+1);
        queue.addLast(fist);
        getNodes(fist.getX(),fist.getY()).runRoad();
        while (!queue.isEmpty()){
            Position curPos;
            if(b){
                curPos = queue.removeFirst();
            }else {
//                int x= (int) (Math.random()*queue.size());
//                curPos=queue.remove(x);
                if(Math.random()<0.5){
                    curPos = queue.removeFirst();
                }else{
                    curPos = queue.removeLast();
                }
            }

            for (int i=0;i<4;i++){
                int newx=curPos.getX()+d[i][0]*2;
                int newy=curPos.getY()+d[i][1]*2;
                if(isArea(newx,newy) && !getNodes(newx,newy).isRunRoad()){
//                    int x= (int) (Math.random()*queue.size());
//                    queue.add(x,new Position(newx,newy));
                    if(Math.random()<0.5){
                        queue.addFirst(new Position(newx,newy));
                    }else{
                        queue.addLast(new Position(newx,newy));
                    }
                    getNodes(newx,newy).runRoad();
                    int qx=curPos.getX()+d[i][0];
                    int qy=curPos.getY()+d[i][1];
                    if(isArea(qx,qy)){
                        nodes[qx][qy]=new Node(Node.Type.ROAD,false);
                        nodes[qx][qy].runRoad();
                    }
                    mazeFrame.drawIndex();
                }
            }
        }
    }

    /**
     * 栈生成迷宫
     * @param mazeFrame
     */
    private void stack(MazeFrame mazeFrame) {
        Stack<Position> stack =new Stack<>();
        Position fist=new Position(inx,iny+1);
        stack.push(fist);
        getNodes(fist.getX(),fist.getY()).runRoad();
        while (!stack.empty()){
            Position curPos = stack.pop();
            for (int i=0;i<4;i++){
                int newx=curPos.getX()+d[i][0]*2;
                int newy=curPos.getY()+d[i][1]*2;
                if(isArea(newx,newy) && !getNodes(newx,newy).isRunRoad()){
                    stack.push(new Position(newx,newy));
                    getNodes(newx,newy).runRoad();
                    int qx=curPos.getX()+d[i][0];
                    int qy=curPos.getY()+d[i][1];
                    if(isArea(qx,qy)){
                        nodes[qx][qy]=new Node(Node.Type.ROAD,false);
                        nodes[qx][qy].runRoad();
                    }
                    mazeFrame.drawIndex();
                }
            }
        }
    }

    /**
     * 初始化路
     */
    public void initRoad() {
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nodes[i][j].init();
            }
        }
    }

    /**
     * 递归生成迷宫
     * @param x
     * @param y
     * @param mazeFrame
     */
    private void recursive(int x, int y, MazeFrame mazeFrame) {
        if(!isArea(x,y)){
            return;
        }
        getNodes(x,y).runRoad();
        for (int i=0;i<4;i++){
            int newx=x+d[i][0]*2;
            int newy=y+d[i][1]*2;
            if(isArea(newx,newy) && !getNodes(newx,newy).isRunRoad()){
                int qx=x+d[i][0];
                int qy=y+d[i][1];
                if(isArea(qx,qy)){
                    nodes[qx][qy]=new Node(Node.Type.ROAD,false);
                    nodes[qx][qy].runRoad();
                }
                mazeFrame.drawIndex();
                recursive(newx,newy,mazeFrame);
            }
        }
    }


    /**
     * 寻找迷宫出路径
     * @param mazeFrame
     * @param structure
     */
    public void traversing(MazeFrame mazeFrame, DataStructure structure) {
        mazeFrame.drawIndex();
        if(DataStructure.RECURSIVE.equals(structure)){
            traversingRecursive(inx,iny+1,mazeFrame);
        }
        if(DataStructure.STACK.equals(structure)){
            traversingStack(mazeFrame);
        }
        if(DataStructure.QUEUE.equals(structure)){
            traversingQueue(mazeFrame);
        }
        mazeFrame.drawIndex();
    }

    private void traversingQueue(MazeFrame mazeFrame) {
        LinkedList<Position> queue =new LinkedList<>();
        Position fist=new Position(inx,iny+1);
        queue.addFirst(fist);
        getNodes(fist.getX(),fist.getY()).runRoad();
        while (!queue.isEmpty()){
            Position curPos = queue.removeLast();
            for (int i=0;i<4;i++){
                int newx=curPos.getX()+d[i][0];
                int newy=curPos.getY()+d[i][1];
                Node node = getNodes(newx, newy);
                if(isArea(newx,newy) && node.getType().equals(Node.Type.ROAD) && !node.isRunRoad()){
                    Position position = new Position(newx, newy);
                    position.setNext(curPos);
                    queue.addFirst(position);
                    getNodes(newx,newy).runRoad();
                    mazeFrame.drawIndex();
                }else if(node.getType().equals(Node.Type.OUT)){
                    while (curPos!=null){
                        getNodes(curPos.getX(),curPos.getY()).trueRoad();
                        curPos = curPos.getNext();
                    }
                    return;
                }
            }
        }
    }

    private void traversingStack(MazeFrame mazeFrame) {
        Stack<Position> stack =new Stack<>();
        Position fist=new Position(inx,iny+1);
        stack.push(fist);
        getNodes(fist.getX(),fist.getY()).runRoad();
        while (!stack.empty()){
            Position curPos = stack.pop();
            for (int i=0;i<4;i++){
                int newx=curPos.getX()+d[i][0];
                int newy=curPos.getY()+d[i][1];
                Node node = getNodes(newx, newy);
                if(isArea(newx,newy) && node.getType().equals(Node.Type.ROAD) && !node.isRunRoad()){
                    Position position = new Position(newx, newy);
                    position.setNext(curPos);
                    stack.push(position);
                    getNodes(newx,newy).runRoad();
                    mazeFrame.drawIndex();
                }else if(node.getType().equals(Node.Type.OUT)){
                    while (curPos!=null){
                        getNodes(curPos.getX(),curPos.getY()).trueRoad();
                        curPos = curPos.getNext();
                    }
                    return;
                }
            }
        }
    }

    private boolean traversingRecursive(int x,int y, MazeFrame mazeFrame) {
        getNodes(x,y).runRoad();
        for (int i=0;i<4;i++){
            int newx=x+d[i][0];
            int newy=y+d[i][1];
            Node node = getNodes(newx, newy);
            if(isArea(newx,newy) && node.getType().equals(Node.Type.ROAD) && !node.isRunRoad()){
                mazeFrame.drawIndex();
                boolean b = traversingRecursive(newx, newy, mazeFrame);
                if(b){
                    getNodes(x,y).trueRoad();
                    return b;
                }

            } else if(node.getType().equals(Node.Type.OUT)){
                getNodes(x,y).trueRoad();
                return true;
            }
        }
        return false;
    }
}
