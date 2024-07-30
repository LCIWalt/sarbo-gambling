package test;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestPic {
    @Test
    public void testFile(){
        try{
            File file=new File("../asset/rock.png");
            JFrame jFrame=new JFrame();
            ImageIcon icon=new ImageIcon("../asset/rock.png");
            jFrame.setSize(1000,1000);
            jFrame.setIconImage(icon.getImage());
            jFrame.setVisible(true);
        }catch (NullPointerException ex){
            System.out.println("couldn't find the pic assets");
        }
        File file=new File("../asset/rock.png");
        JFrame jFrame=new JFrame();
        ImageIcon icon=new ImageIcon("../asset/rock.png");
        jFrame.setSize(1000,1000);
        jFrame.setIconImage(icon.getImage());
        jFrame.setVisible(true);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        return;
    }

}
