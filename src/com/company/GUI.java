package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class GUI extends JFrame {
    private int currentTact = 0;
    private final JLabel statusLabel = new JLabel(" Ожидание ");
    private final JButton beginbutton = new JButton("Начать автоматически");
    private final JButton manualbutton = new JButton("Начать пошагово");
    private final JButton endbutton = new JButton("Завершить");
    private final Path path = new Path();
    private Thread thread;

    public GUI() {
        super("Симулятор Волго-Балтийского речного водного пути");

        this.setBounds(1, 1, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(0, 2));

        path.getPath().forEach(p -> {
            contentPane.add(p.getLabel());
            contentPane.add(p.getState());
        });

        statusLabel.setHorizontalAlignment(SwingConstants.RIGHT);


        Dimension dimension = new Dimension(120, 40);
        beginbutton.setSize(dimension);
        contentPane.add(beginbutton);

        manualbutton.setSize(dimension);
        contentPane.add(manualbutton);

        contentPane.add(statusLabel);
        endbutton.setMaximumSize(dimension);
        endbutton.setSize(dimension);
        endbutton.setEnabled(false);
        contentPane.add(endbutton);

        beginbutton.addActionListener(e -> {
            beginbutton.setEnabled(false);
            endbutton.setEnabled(true);
            manualbutton.setEnabled(false);

            thread = getWorkingThread();
            thread.start();
        });

        manualbutton.addActionListener(e -> {
            beginbutton.setEnabled(false);
            endbutton.setEnabled(true);

            if (currentTact == 0) {
                path.start(List.of(
                        new Ship("от Москвы", true, 0),
                        new Ship("от Питера", false, 20)));
            }

            statusLabel.setText(" Такт № "+ currentTact +" ");
            currentTact ++;
            if (!path.tact()) {
                stopSimulation(" Ручная симуляция окончена ");
            }
        });

        endbutton.addActionListener(e -> {
            if (thread != null) {
                thread.interrupt();
            }
            stopSimulation(" Cимуляция остановленна ");
        });
    }

    private void stopSimulation(String lable) {
        endbutton.setEnabled(false);
        beginbutton.setEnabled(true);
        manualbutton.setEnabled(true);

        currentTact = 0;
        statusLabel.setText(lable);
        path.stop();
    }

    private Thread getWorkingThread() {
        return new Thread(() -> {
            path.start(List.of(
                    new Ship("от Москвы", true, 0),
                    new Ship("от Питера", false, 20)));

            while (path.tact()) {
                statusLabel.setText(" Такт № "+ currentTact + " ");
                currentTact ++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    currentTact = 0;
                    return;
                }
            }

            stopSimulation(" Автоматическая симуляция окончена ");
        });
    }
}