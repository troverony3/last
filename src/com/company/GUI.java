package com.company;

import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame {
    private int currentTact = 0;
    private JLabel statusLabel;
    private Mode mode = null;
    private final Path path = new Path();
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

        statusLabel = new JLabel(" Ожидание ");
        statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(statusLabel);


        Dimension dimension = new Dimension(120, 40);
        JButton beginbutton = new JButton("Начать автоматически");
        beginbutton.setSize(dimension);
        contentPane.add(beginbutton);

        JButton manualbutton = new JButton("Начать пошагово");
        manualbutton.setSize(dimension);
        contentPane.add(manualbutton);

        JButton endbutton = new JButton("Завершить");
        endbutton.setMaximumSize(dimension);
        endbutton.setSize(dimension);
        contentPane.add(endbutton);

        beginbutton.addActionListener(e -> {
            if (mode != null) {
                return;
            }
            mode = Mode.AUTOMATIC;
            thread = getWorkingThread();
            thread.start();
        });

        manualbutton.addActionListener(e -> {
            if (mode == null) {
                mode = Mode.MANUAL;
                path.start();
            }
            if (!mode.equals(Mode.MANUAL)){
                return;
            }
            statusLabel.setText(" Такт № "+ currentTact +" ");
            currentTact ++;
            if (!path.tact()) {
                statusLabel.setText(" Ручная симуляция окончена ");
                currentTact = 0;
            }
        });

        endbutton.addActionListener(e -> {
            if (thread != null) {
                thread.interrupt();
            }
            mode = null;
            currentTact = 0;
            statusLabel.setText(" Cимуляция остановленна ");
        });
    }

    private Thread getWorkingThread() {

        return new Thread(() -> {
            path.start();
            while (path.tact()) {
                statusLabel.setText(" Такт № "+ currentTact + " ");
                currentTact ++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            mode = null;
            statusLabel.setText(" Автоматическая симуляция окончена ");
            currentTact = 0;
        });
    }

    private enum Mode{
        MANUAL,
        AUTOMATIC;
    }
}