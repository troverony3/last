package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private Path path = new Path();

    public GUI() {
        super("Симулятор Волго-Балтийского речного водного пути");

        this.setBounds(1, 1, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(0, 1));

        path.getPath().forEach(contentPane::add);

        Dimension dimension = new Dimension(120, 40);
        JButton beginbutton = new JButton("Начать");
        beginbutton.setSize(dimension);
        beginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                path.getPath().element().setSelected(true);
                new Thread((new Runnable() {
                    @Override
                    public void run() {
                        public void run(){
                            int i;
                            for (i = 1; i <= 24; i++) {
                                path.getPath().element().setSelected(true);
                            }
                            });
                        try {
                            java.lang.Thread.sleep(100);
                        }
                        catch(Exception e) { }
                    }

            }).start();
        );}

        JButton endbutton = new JButton("Завершить");
        endbutton.setMaximumSize(dimension);
        endbutton.setSize(dimension);
        contentPane.add(beginbutton);
        contentPane.add(endbutton);
    }
}