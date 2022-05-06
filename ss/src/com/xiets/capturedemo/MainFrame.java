package com.xiets.capturedemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;



public class MainFrame extends JFrame implements ActionListener{
    JButton button;
    //方法init
    public void init(){
        
        button = new JButton("Take a SS"); 
        button.setBounds(100,100,250,100);
        button.addActionListener(this);
        setTitle("Screenshot record data 1.0Beta");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);        
    }

    public void actionPerformed(ActionEvent e) { 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot;
        try {
            robot = new Robot();
            BufferedImage image = robot.createScreenCapture(screenRectangle);
            LocalTime myObj = LocalTime.now();
            System.out.println(myObj);
            String time =  new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date().getTime());
            System.out.println(time);
            // 保存截取的图片+时间
            ImageIO.write(image, "PNG", new File(time+".png"));
            
        } catch (AWTException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
}

