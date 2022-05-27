package com.tutorialspoint.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
public class TakeAScreen {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    public TakeAScreen(){
        prepareGUI();
    }
    public static void main(String[] args){
        TakeAScreen takeAScreen = new TakeAScreen();
        takeAScreen.showEventDemo();

    }
    private void prepareGUI(){
        //UI的一些设计 标题
        mainFrame = new JFrame("Screenshot for Research Beta.01");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));

        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showEventDemo(){
        //按钮的设计 文本信息
        headerLabel.setText("Use Button To Take Action");

        JButton okButton = new JButton("Screenshots");
        JButton submitButton = new JButton("Save");
        JButton cancelButton = new JButton("Cancel");
        JButton filesave = new JButton("Save the file to:");

        okButton.setActionCommand("OK");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");
        filesave.setActionCommand("Save to");
        //调用Listener 启动事件
        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());
        filesave.addActionListener(new FileButtonClickListener());


        controlPanel.add(okButton);
        controlPanel.add(submitButton);
        controlPanel.add(cancelButton);
        controlPanel.add(filesave);

        mainFrame.setVisible(true);

    }
    JButton button = new JButton("点击这里开始~");


    //SAVE文件的用法
    final JLabel label = new JLabel();
    private class FileButtonClickListener implements  ActionListener{
        public void actionPerformed(ActionEvent e){
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(mainFrame);
            if(option == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                label.setText("文件保存为: " + file.getName());
            }else{
                label.setText("保存命令取消");
            }
        }
    }


    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //编辑第一个事件
            //根据当前窗口截图
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
                // 保存截取的图片+时间 并且保存当地时间为文件名进行输出
                ImageIO.write(image, "PNG", new File(time+".png"));

            } catch (AWTException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            String command = e.getActionCommand();

            if( command.equals( "OK" ))  {
                statusLabel.setText("Screenshots Success.");
            } else if( command.equals( "Submit" ) )  {
                statusLabel.setText("Save Success.");
            } else {
                statusLabel.setText("Cancel Success.");
            }
        }

    }

}