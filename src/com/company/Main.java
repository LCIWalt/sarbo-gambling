package com.company;
import javax.swing.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

public class Main {

    public static void main(String[] args){
        JFrame jFrame = new JFrame();
        int jLabelSize=40;
        jFrame.setSize(1200,800);//1140 720
        jFrame.setJMenuBar(null);
        jFrame.setLayout(null);
        Random random=new Random();
        ArrayList<Hands>grid=new ArrayList<>();

        for (int i=0;i<30;) {

            int x=random.nextInt(( 1120));
            int y= random.nextInt((720));
            int dir=random.nextInt(8);//[0,8)
            int h=random.nextInt(3);
            boolean f=true;
            for (int j=0;j<grid.size();j++){
                if ((x>=grid.get(j).x-jLabelSize) && (x<=grid.get(j).x+jLabelSize) && (y>=grid.get(j).y-jLabelSize)&& (y<=grid.get(j).y+jLabelSize)){
                    System.out.println("有重叠");
                    f=false;
                    break;
                }
            }
            if (f){
                System.out.println(h);
                switch (h){
                    case 0:
                        //Hands hands=new Hands("rock",x,y,dir,jLabelSize);
                        grid.add(new Hands("rock",x,y,dir,jLabelSize));
                        break;
                    case 1:
                        //Hands hands=new Hands("paper",x,y,dir,jLabelSize);
                        grid.add(new Hands("paper",x,y,dir,jLabelSize));
                        break;
                    case 2:
                        //Hands hands=new Hands("scissors",x,y,dir,jLabelSize);
                        grid.add(new Hands("scissors",x,y,dir,jLabelSize));
                        break;

                    }

                System.out.println(grid.size()+" "+x+" "+y);
                //System.out.println(grid.get(grid.size()-1));
                jFrame.add(grid.get(grid.size()-1));

                grid.get(grid.size()-1).setLocation(x,y);
                i++;
            }

        }

        jFrame.setVisible(true);
        Timer timer=new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<grid.size();i++){

                    //jFrame.remove(grid.get(i));
                    grid.get(i).moveOne();
                    //jFrame.add(grid.get(i));
                }
                for (int i=0;i<grid.size();i++){
                    for (int j=i+1;j<grid.size();j++){
                        if(Intersect.isRectIntersect(grid.get(i),grid.get(j))){
                           // System.out.println("Intersected");
                            if(grid.get(i).type==grid.get(j).type){
                                grid.get(i).modifyDirection();grid.get(j).modifyDirection();
                                grid.get(i).moveOne();
                                grid.get(j).moveOne();

                            }
                           else {
                                Intersect.dealWithIntersect(grid.get(i), grid.get(j));
                           }
                           /*while (Intersect.isRectIntersect(grid.get(i),grid.get(j))){
                               grid.get(i).moveOne();
                               grid.get(j).moveOne();
                            }*/
                        }

                    }

                }
                //System.out.println("i got move");
            }
        });
        timer.start();


    }

}
