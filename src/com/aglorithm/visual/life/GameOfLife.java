package com.aglorithm.visual.life;

import java.util.Random;

/**
 * @Name: GameOfLife
 * @Description: 生存游戏主体
 * @Auther: wenjin.dan
 * @Date: 2021/2/8
 */
public class GameOfLife {

    /**
     * 随机类
     */
    private static final Random RANDOM = new Random();

    /**
     * 交换区1
     */
    private byte[][] swap1;
    /**
     * 交换区2
     */
    private byte[][] swap2;
    /**
     * 当期选择区
     */
    private byte[][] select;

    /**
     * 数组大小
     */
    private int size;

    public GameOfLife(int size){
        swap1 = new byte[size][size];
        swap2 = new byte[size][size];
        this.size = size;
        for(int i =0; i<size;i++){
            for(int j = 0; j<size;j++){
                if(RANDOM.nextBoolean()){
                    swap1[i][j] = 1;
                }else {
                    swap1[i][j] = 0;
                }
            }
        }
        select = swap1;
    }

    public GameOfLife(byte[][] maps){
        if(maps.length < 1 || maps.length != maps[0].length){
            throw new RuntimeException("数组格式长款必须相等并且大于1");
        }
        this.size = maps.length;
        swap1 = new byte[size][size];
        swap2 = new byte[size][size];
        for(int i =0; i<size;i++){
            for(int j = 0; j<size;j++){
                swap1[i][j] = maps[i][j];
            }
        }
        select = swap1;
    }

    /**
     * 计算下一次生成
     */
    public void nextLife(){
        byte[][] next = select == swap1 ? swap2 : swap1;
        for(int i = 0;i < size; i++){
            for (int j= 0;j<size;j++){
                byte b = select[i][j];
                int count = 0;
                if(i-1>0 && j-1>0 && select[i-1][j-1] == 1){
                    count++;
                }
                if(i-1>0 && select[i-1][j] ==1){
                    count++;
                }
                if(i-1>0 && j+1<size && select[i-1][j+1] ==1){
                    count++;
                }
                if(j-1>0 && select[i][j-1] ==1){
                    count++;
                }
                if(j+1<size && select[i][j+1] ==1){
                    count++;
                }
                if(i+1<size && j-1>0 && select[i+1][j-1] == 1){
                    count++;
                }
                if(i+1<size && select[i+1][j] ==1){
                    count++;
                }
                if(i+1<size && j+1<size && select[i+1][j+1] ==1){
                    count++;
                }

                if(b ==1){
                    if(count<2){
                        next[i][j] = 0;
                    }
                    if (count>3){
                        next[i][j] = 0;
                    }
                    if(count==2||count==3){
                        next[i][j] = 1;
                    }
                }
                if(b == 0){
                    if(count==3){
                        next[i][j] = 1;
                    }else {
                        next[i][j] = 0;
                    }
                }
            }
        }
        select = next;
    }

    public byte[][] getSwap1() {
        return swap1;
    }

    public byte[][] getSwap2() {
        return swap2;
    }

    public byte[][] getSelect() {
        return select;
    }

    public int getSize() {
        return size;
    }
}
