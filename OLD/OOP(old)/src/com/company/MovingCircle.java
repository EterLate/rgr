package com.company;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;


public class MovingCircle extends JComponent implements ActionListener {
    private double scale;
    private Color color;
    private Timer timer;
    public int scopeleft=0;
    public int scoperight=0;
    public double x =10;
    public double y =60;
    private double basespeed=3;
    public double speed=basespeed;
    public double changex=speed;
    public double changey=speed;
    public int LeftPlateSizeX=20;
    public int LeftPlateSizeY=100;
    public int RightPlateSizeX=20;
    public int RightPlateSizeY=100;
    public int LeftCoord=200;
    public int RightCoord=200;
    public boolean UpPressed=false;
    public boolean DownPressed=false;
    public boolean WPressed=false;
    public boolean SPressed=false;

    public MovingCircle(Color color, int delay) {
        scale = 1.0;
        timer = new Timer(delay, this);
        this.color = color;

        setPreferredSize(new Dimension(1100, 500));
    }
 public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (UpPressed && RightCoord>50) RightCoord-=5;
        if (DownPressed && RightCoord<400) RightCoord+=5;
        if (WPressed && LeftCoord>50) LeftCoord-=5;
        if (SPressed && LeftCoord<400) LeftCoord+=5;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        int width = 1100;
        int height = 450;
        g.fillRect(0,50,width,height);
        g2d.setColor(Color.black);
        g2d.drawRect(0, 50, width - 1, height - 1);
        g2d.setColor(Color.blue);
        /*switch(scoperight){
            case 0:g2d.drawImage();
            case 1:

        }*/
        g2d.fillRect(50,LeftCoord,LeftPlateSizeX,LeftPlateSizeY);
        g2d.setColor(Color.red);
        g2d.fillRect(1050,RightCoord,RightPlateSizeX,RightPlateSizeY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(color);
        g2d.scale(scale, scale);
        if(LeftCoord<y && (LeftCoord+100) >y && x<70 && x>50){
            speed+=1;
            changex=speed;

        }
        if(RightCoord<y && (RightCoord+100) >y && x>1030 && x<1050){
            speed+=1;
            changex=-speed;
        }
                //правая граница
        if(x>1080){
            scopeleft+=1;
            x=550;
            y=250;
            speed=basespeed;
            changex=-speed;
            changey=speed;
        }
        //левая граница
        if(x<0){
            scoperight+=1;
            x=550;
            y=250;
            speed=basespeed;
            changex=speed;
            changey=speed;
        }
        //верхняя? граница
        if(y<50){
            changey=speed;
        }
        //нижняя? граница
        if(y>480){
            changey=-speed;
        }



        x=x+changex;
        y=y+changey;
        Ellipse2D el = new Ellipse2D.Double(x, y, 20, 20);
        g2d.fill(el);
    }


}
