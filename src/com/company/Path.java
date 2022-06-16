package com.company;

import com.company.pathitems.Canal;
import com.company.pathitems.Lock;
import com.company.pathitems.RiverPathItem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Path {
    private int currentItem;

    private final List<RiverPathItem> path = initPath();

    public List<JRadioButton> getPath() {
        return path.stream().map(RiverPathItem::getState).toList();
    }

    public void start() {
        currentItem = path.size() - 1;
    }

    public boolean tact() {
        if (currentItem == 0) {
            if (path.get(0).haveCrossed()) {
                return false;
            }
        }
        RiverPathItem riverPathItem = path.get(currentItem);
        if (riverPathItem.haveCrossed()) {
            currentItem--;

            path.get(currentItem).startCrossingUpThePath();

            return true;
        }
        riverPathItem.tact();
        return true;
    }

    private static List<RiverPathItem> initPath() {
        final List<RiverPathItem> path = new ArrayList<>();
        path.add(new Canal(860, new JRadioButton("Канал №52")));
        path.add(new Lock(new JRadioButton("шлюз1")));
        path.add(new Canal(1050, new JRadioButton("Канал №53 ")));
        path.add(new Canal(8350, new JRadioButton("Судовой ход №54")));
        path.add(new Canal(600, new JRadioButton("Канал №55")));
        path.add(new Lock(new JRadioButton("шлюз2")));
        path.add(new Canal(600, new JRadioButton("Канал №56 ")));
        path.add(new Canal(4060, new JRadioButton("Судовой ход №57 ")));
        path.add(new Canal(600, new JRadioButton("Канал №58")));
        path.add(new Lock(new JRadioButton("шлюз 3")));
        path.add(new Canal(780, new JRadioButton("Канал №59 ")));
        path.add(new Lock(new JRadioButton("Шлюз №4")));
        path.add(new Canal(780, new JRadioButton("Канал №60 ")));
        path.add(new Lock(new JRadioButton("Шлюз №5")));
        path.add(new Canal(600, new JRadioButton("Канал №61 ")));
        path.add(new Canal(4380, new JRadioButton("Канал судоходный №62 ")));
        path.add(new Canal(790, new JRadioButton("Канал №63")));
        path.add(new Lock(new JRadioButton("Шлюз №6")));
        path.add(new Canal(850, new JRadioButton("Канал №64")));
        return path;
    }
}
