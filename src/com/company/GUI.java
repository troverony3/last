package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;


public class GUI extends JFrame {
    private Path path = new Path();
    private Thread thread;

    public GUI() {
        super("Симулятор Волго-Балтийского речного водного пути");

        this.setBounds(1, 1, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(0, 1));

        ButtonGroup buttonGroup = new ButtonGroup();
        path.getPath().forEach(comp -> {
            contentPane.add(comp);
            buttonGroup.add(comp);
        });

        Dimension dimension = new Dimension(120, 40);
        JButton beginbutton = new JButton("Начать");
        beginbutton.setSize(dimension);

        JButton endbutton = new JButton("Завершить");
        endbutton.setMaximumSize(dimension);
        endbutton.setSize(dimension);
        contentPane.add(beginbutton);
        contentPane.add(endbutton);

        beginbutton.addActionListener(e -> {
            thread = getWorkingThread();
            thread.start();
        });
        endbutton.addActionListener(e -> thread.interrupt());
    }

    private Thread getWorkingThread() {
        return new Thread(() -> path.getPath().forEach(node -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            node.setSelected(true);
        }));
    }
}