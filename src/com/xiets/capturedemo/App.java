package com.xiets.capturedemo;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class App {

    public static void main(String[] args) throws Exception {
        // 获取屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // 创建需要截取的矩形区域
        Rectangle rect = new Rectangle(0, 0, screenSize.width, screenSize.height);

        // 截屏操作
        BufferedImage bufImage = new Robot().createScreenCapture(rect);
        //获取本地时间
        LocalTime myObj = LocalTime.now();
        System.out.println(myObj);
        String time =  new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date().getTime());
        System.out.println(time);
        // 保存截取的图片+时间
        ImageIO.write(bufImage, "PNG", new File(time+".png"));

        //调用方法启动程序框架
        MainFrame myFrame = new MainFrame();
        myFrame.init();
    }
}
