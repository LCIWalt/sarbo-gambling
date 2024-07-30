package com.company;
import javax.swing.*;
import java.awt.*;

public class Hands extends JLabel {

//direc 0-7
    public String type=null;//rock paper scissors
    public int direction;//左上0
    public int x;
    public int y;
    private int m=1;
    public int size=40;
    public void moveOne(){
        if (x<=2||x>=1138||y<=2||y>=718){
            modifyDirection();
        }
        switch (direction){
            case 0:
                this.x=x-m;
                this.y=y-m;
                this.setBounds(x,y,size,size);

                break;
            case 7:
                this.x=x+m;
                this.y=y+m;
                this.setBounds(x,y,size,size);

                break;
            case 1:
                this.y=y-m;
                this.setBounds(x,y,size,size);

                break;
            case 6:
                this.y=y+m;
                this.setBounds(x,y,size,size);

                break;
            case 2:
                this.x=x+m;
                this.y=y-m;
                this.setBounds(x,y,size,size);

                break;
            case 5:
                this.x=x-m;
                this.y=y+m;
                this.setBounds(x,y,size,size);

                break;
            case 3:
                this.x=x-m;
                this.setBounds(x,y,size,size);

                break;
            case 4:
                this.x=x+m;
                this.setBounds(x,y,size,size);

                break;
            default:
                System.out.println("sb");
                break;
        }

    }
    public void modifyDirection(){
        this.direction=7-direction;
        return;
    }
    public void setDirection(int d){
        this.direction=d;
        return;
    }
    public Hands(String a,int x,int y,int direction,int size){
        this.type=a;
        this.x=x;
        this.y=y;
        this.direction=direction;
        this.size=size;
        this.setBounds(x,y,size,size);
        ImageIcon icon=new ImageIcon("./asset/"+a+".png");
        icon.setImage(icon.getImage().getScaledInstance(size,size,Image.SCALE_FAST));
        //System.out.println(icon);
        //icon.setImage(icon.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT ));
        this.setIcon(icon);

    }


}
