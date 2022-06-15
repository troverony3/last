package com.company;

import javax.swing.*;
import java.util.LinkedList;

public class Path {

    private final LinkedList<JRadioButton> path = initPath();

    public LinkedList<JRadioButton> getPath() {
        return path;
    }

    private static LinkedList<JRadioButton> initPath() {
        final LinkedList<JRadioButton> path = new LinkedList<>();
        path.add(new JRadioButton("Канал №52"));
        path.add(new JRadioButton("шлюз1"));
        path.add(new JRadioButton("Канал №53 "));
        path.add(new JRadioButton("Судовой ход №54"));
        path.add(new JRadioButton("Канал №55"));
        path.add(new JRadioButton("шлюз2"));
        path.add(new JRadioButton("Канал №56 "));
        path.add(new JRadioButton("Судовой ход №57 "));
        path.add(new JRadioButton("Канал №58"));
        path.add(new JRadioButton("шлюз 3"));
        path.add(new JRadioButton("Канал №59 "));
        path.add(new JRadioButton("Шлюз №4"));
        path.add(new JRadioButton("Канал №60 "));
        path.add(new JRadioButton("Шлюз №5"));
        path.add(new JRadioButton("Канал №61 "));
        path.add(new JRadioButton("Канал судоходный №62 "));
        path.add(new JRadioButton("Канал №63"));
        path.add(new JRadioButton("Шлюз №6"));
        path.add(new JRadioButton("Канал №64 "));
        return path;
    }
}
