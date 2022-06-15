package com.company;

import javax.swing.*;
import java.awt.*;


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
        JButton endbutton = new JButton("Завершить");
        endbutton.setMaximumSize(dimension);
        endbutton.setSize(dimension);
        contentPane.add(beginbutton);
        contentPane.add(endbutton);
    }
}