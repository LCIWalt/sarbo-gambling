package com.company;

public class Intersect {
    public static boolean isRectIntersect(Hands h1,Hands h2) {
        return (
                h1.x <= h2.x + h1.size &&
                        h1.x +  h1.size >= h2.x &&
                        h1.y <= h2.y +  h1.size &&
                        h1.y + h1.size >= h2.y
            );
    }
    public static void dealWithIntersect(Hands h1,Hands h2){
        Integer flag=0;

        if (h1.type.equals("rock")){
            if (h2.type.equals("scissors")){
                flag=1;//mean h1>h2
            }
            else if(h2.type.equals("paper")){
                flag=-1;
            }
        }else if (h1.type.equals("scissors")){
            if (h2.type.equals("paper")){
                flag=1;//mean h1>h2
            }
            else if(h2.type.equals("rock")){
                flag=-1;
            }

        }else if(h1.type.equals("paper")){
            if (h2.type.equals("rock")){
                flag=1;//mean h1>h2
            }
            else if(h2.type.equals("scissors")){
                flag=-1;
            }
        }

        if (flag.equals(0)){
            h1.modifyDirection();
            h2.modifyDirection();
            h1.moveOne();
            h2.moveOne();
            //System.out.println("flag");
        }else if(flag.equals(1)){
            h2.modifyDirection();
            //h2.setDirection(h1.direction);
            h2.setIcon(h1.getIcon());
            //h1.moveOne();
            h2.moveOne();
            h2.moveOne();
            h2.moveOne();
            h2.type=h1.type;
        }else if(flag.equals(-1)){
            h1.modifyDirection();
            //h1.setDirection(h2.direction);
            h1.setIcon(h2.getIcon());
            h1.moveOne();
            h1.moveOne();
            h1.moveOne();
            //h2.moveOne();
            h1.type=h2.type;
        }else{
            //System.out.println("flag");
        }

    }

}
