package com.company;

import com.company.pathitems.Canal;
import com.company.pathitems.Lock;
import com.company.pathitems.RiverPathItem;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<RiverPathItem> path = initPath();
    private List<Ship> ships = new ArrayList<>();

    public List<RiverPathItem> getPath() {
        return path;
    }

    public void start(List<Ship> ships) {
        this.ships = ships;
        this.ships.forEach(s -> s.setRiverSize(path.size()));
    }

    public void stop() {
        path.forEach(RiverPathItem::stop);
        ships = new ArrayList<>();
    }

    public boolean tact() {
        ships.forEach(s -> {
            RiverPathItem riverPathItem = path.get(s.getCurrentPosition());
            if (riverPathItem.haveCrossed(s)) {
                s.moveOneFurther();
                riverPathItem.removeShip(s);
            }
            path.get(s.getCurrentPosition()).moveShipIn(s);
            s.tact();
        });
        return anybodyMoving();
    }

    public boolean anybodyMoving() {
        return ships.stream().map(Ship::isMoving).reduce((a, b) -> a || b).orElse(false);
    }

    private static List<RiverPathItem> initPath() {
        final List<RiverPathItem> path = new ArrayList<>();
        path.add(new Canal(860, new JLabel("Канал №52"), new JButton()));
        path.add(new Lock(new JLabel("Шлюз №1"), new JButton()));
        path.add(new Canal(1050, new JLabel("Канал №53 "), new JButton()));
        path.add(new Canal(8350, new JLabel("Судовой ход №54"), new JButton()));
        path.add(new Canal(600, new JLabel("Канал №55"), new JButton()));
        path.add(new Lock(new JLabel("Шлюз №2"), new JButton()));
        path.add(new Canal(600, new JLabel("Канал №56 "), new JButton()));
        path.add(new Canal(4060, new JLabel("Судовой ход №57 "), new JButton()));
        path.add(new Canal(600, new JLabel("Канал №58"), new JButton()));
        path.add(new Lock(new JLabel("Шлюз № 3"), new JButton()));
        path.add(new Canal(780, new JLabel("Канал №59 "), new JButton()));
        path.add(new Lock(new JLabel("Шлюз №4"), new JButton()));
        path.add(new Canal(780, new JLabel("Канал №60 "), new JButton()));
        path.add(new Lock(new JLabel("Шлюз №5"), new JButton()));
        path.add(new Canal(600, new JLabel("Канал №61 "), new JButton()));
        path.add(new Canal(4380, new JLabel("Канал судоходный №62 "), new JButton()));
        path.add(new Canal(790, new JLabel("Канал №63"), new JButton()));
        path.add(new Lock(new JLabel("Шлюз №6"), new JButton()));
        path.add(new Canal(850, new JLabel("Канал №64"), new JButton()));
        return path;
    }
}
