package com.company;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.*;


public class MovingCircle extends JComponent implements ActionListener {
    private double scale;
    private Color color;
    private Timer timer;
    public int scopeleft=0;
    public int scoperight=0;
    public double x =300;
    public double y =200;
    public double playballsize = 20;
    public double xa=x-playballsize;
    public double ya=y-playballsize;
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
    public int bonusballx = 550;
    public int bonusbally = 275;
    public int bonusballsize = 30;
    public int debuffballx = 550;
    public int debuffbally = 100;
    public int debuffballsize = 30;
    public int darkballx = 550;
    public int darkbally = 450;
    public int darkballsize = 30;
    public boolean BlackSquare = false;
    public int BlackSquarex;
    public int BlackSquarey;

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
        if (DownPressed && RightCoord<500 - RightPlateSizeY) RightCoord+=5;
        if (WPressed && LeftCoord>50) LeftCoord-=5;
        if (SPressed && LeftCoord<500 - RightPlateSizeY) LeftCoord+=5;
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        int width = 1100;
        int height = 450;
        Random rand = new Random();
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
        xa=x+playballsize/2;
        ya=y+playballsize/2;
            if ((((xa+((bonusballsize / 2) + (playballsize / 2)))>bonusballx && x<bonusballx) && (ya>=bonusbally && ya<=(bonusbally+((bonusballsize / 2) + (playballsize / 2)))))
                    || (((xa+((bonusballsize / 2) + (playballsize / 2)))>bonusballx && xa<bonusballx) && (ya<=bonusbally && (ya+((bonusballsize / 2) + (playballsize / 2)))>=bonusbally))
                    || ((xa<(bonusballx+((bonusballsize / 2) + (playballsize / 2))) && xa>bonusballx) && (ya>=bonusbally && ya<=(bonusbally+((bonusballsize / 2) + (playballsize / 2)))))
                    || ((xa<(bonusballx+((bonusballsize / 2) + (playballsize / 2))) && xa>bonusballx) && (ya<=bonusbally && (ya+((bonusballsize / 2) + (playballsize / 2)))>=bonusbally)))
            {
                bonusballx = rand.nextInt(900-bonusballsize)+100;
                bonusbally = rand.nextInt(400-bonusballsize)+50;
                LeftPlateSizeY += 25;
                RightPlateSizeY += 25;
            }
            if ((((xa+((debuffballsize / 2) + (playballsize / 2)))>debuffballx && x<debuffballx) && (ya>=debuffbally && ya<=(debuffbally+((debuffballsize / 2) + (playballsize / 2)))))
                    || (((xa+((debuffballsize / 2) + (playballsize / 2)))>debuffballx && xa<debuffballx) && (ya<=debuffbally && (ya+((debuffballsize / 2) + (playballsize / 2)))>=debuffbally))
                    || ((xa<(debuffballx+((debuffballsize / 2) + (playballsize / 2))) && xa>debuffballx) && (ya>=debuffbally && ya<=(debuffbally+((debuffballsize / 2) + (playballsize / 2)))))
                    || ((xa<(debuffballx+((debuffballsize / 2) + (playballsize / 2))) && xa>debuffballx) && (ya<=debuffbally && (ya+((debuffballsize / 2) + (playballsize / 2)))>=debuffbally)))
            {
                debuffballx = rand.nextInt(900-debuffballsize)+100;
                debuffbally = rand.nextInt(400-debuffballsize)+50;
                LeftPlateSizeY -= 25;
                RightPlateSizeY -= 25;
            }
            if ((((xa+((darkballsize / 2) + (playballsize / 2)))>darkballx && x<darkballx) && (ya>=darkbally && ya<=(darkbally+((darkballsize / 2) + (playballsize / 2)))))
                    || (((xa+((darkballsize / 2) + (playballsize / 2)))>darkballx && xa<darkballx) && (ya<=darkbally && (ya+((darkballsize / 2) + (playballsize / 2)))>=darkbally))
                    || ((xa<(darkballx+((darkballsize / 2) + (playballsize / 2))) && xa>darkballx) && (ya>=darkbally && ya<=(darkbally+((darkballsize / 2) + (playballsize / 2)))))
                    || ((xa<(darkballx+((darkballsize / 2) + (playballsize / 2))) && xa>darkballx) && (ya<=darkbally && (ya+((darkballsize / 2) + (playballsize / 2)))>=darkbally)))
            {
                darkballx = rand.nextInt(900-darkballsize)+100;
                darkbally = rand.nextInt(400-darkballsize)+50;
                BlackSquarex = rand.nextInt(600)+200;
                BlackSquarey = rand.nextInt(50)+200;
                    if (BlackSquare == false){
                        BlackSquare = true;
                    } else {
                        BlackSquare = false;
                    }
            }
        if(LeftCoord<y && (LeftCoord+LeftPlateSizeY) >y && x<70 && x>50){
            speed+=1;
            changex=speed;

        }
        if(RightCoord<y && (RightCoord+RightPlateSizeY) >y && x>1030 && x<1050){
            speed+=1;
            changex=-speed;
        }
                //правая граница
        if(x>1080){
            BlackSquare = false;
            RightPlateSizeY=100;
            scopeleft+=1;
            x=550;
            y=250;
            speed=basespeed;
            changex=-speed;
            changey=speed;
        }
        //левая граница
        if(x<0){
            BlackSquare = false;
            LeftPlateSizeY=100;
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
        Ellipse2D el = new Ellipse2D.Double(x, y, playballsize, playballsize);
        g2d.fill(el);
        g2d.setColor(Color.orange);
        Ellipse2D bonusball = new Ellipse2D.Double(bonusballx-bonusballsize/2, bonusbally-bonusballsize/2, bonusballsize, bonusballsize);
        g2d.fill(bonusball);
        g2d.setColor(Color.pink);
        Ellipse2D debuffball = new Ellipse2D.Double(debuffballx-debuffballsize/2, debuffbally-debuffballsize/2, debuffballsize, debuffballsize);
        g2d.fill(debuffball);
        if (BlackSquare == true){
            g2d.setColor(Color.black);
            g2d.fillRect(BlackSquarex, BlackSquarey, 200, 200);
            g2d.setColor(Color.cyan);
        } else {
            g2d.setColor(Color.black);
        }
        Ellipse2D darkball = new Ellipse2D.Double(darkballx-darkballsize/2, darkbally-darkballsize/2, darkballsize, darkballsize);
        g2d.fill(darkball);

    }


}
