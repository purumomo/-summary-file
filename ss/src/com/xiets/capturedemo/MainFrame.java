package com.xiets.capturedemo;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    public void init(){
        JButton btn1 = new JButton("Click"); 
        JPanel jp=new JPanel();//创建JPanel对象
        jp.add(btn1);
        setTitle("Screening Success");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setVisible(true);

        btn1.setPreferredSize(getPreferredSize());
        //按钮事件
        btn1.addActionListener(e ->
        {
        // your code here
            });
           

        
    }
}
