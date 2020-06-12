package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args) {

            JFrame frame = new JFrame("Ping-pong");
            JPanel panel = new JPanel();
            JTextField schetleft = new JTextField("0");
            JTextField schetright = new JTextField("0");
            MovingCircle MovingCircleGreen = new MovingCircle(Color.green, 20);
            panel.add(MovingCircleGreen);
            frame.getContentPane().add(panel);
            final JButton button = new JButton("Start");
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode()==KeyEvent.VK_W) MovingCircleGreen.WPressed=true;
                if (e.getKeyCode()==KeyEvent.VK_S) MovingCircleGreen.SPressed=true;
                if (e.getKeyCode()==KeyEvent.VK_UP) MovingCircleGreen.UpPressed=true;
                if (e.getKeyCode()==KeyEvent.VK_DOWN) MovingCircleGreen.DownPressed=true;

            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (e.getKeyCode()==KeyEvent.VK_W) MovingCircleGreen.WPressed=false;
                if (e.getKeyCode()==KeyEvent.VK_S) MovingCircleGreen.SPressed=false;
                if (e.getKeyCode()==KeyEvent.VK_UP) MovingCircleGreen.UpPressed=false;
                if (e.getKeyCode()==KeyEvent.VK_DOWN) MovingCircleGreen.DownPressed=false;
            }
        });
        button.addActionListener(new ActionListener() {
                private boolean pulsing = false;
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (pulsing) {
                            pulsing = false;
                            MovingCircleGreen.stop();
                            button.setText("Start");
                        } else {
                            pulsing = true;
                            MovingCircleGreen.start();
                            button.setText("Stop");
                        }
                    }
                });
                panel.add(button);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(1200, 600);
                frame.setVisible(true);


    }
}
