package com.xiets.capturedemo;

import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    public void init(){
        setTitle("Screen shot when you what to");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        JButton btn1=new JButton("我是普通按钮"); 
    }
}
