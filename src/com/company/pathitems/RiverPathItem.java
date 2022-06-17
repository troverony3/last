package com.company.pathitems;

import com.company.Ship;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class RiverPathItem {

    private final JLabel label;
    private final JButton state;

    private final Set<Ship> ships = new HashSet<>();


    protected RiverPathItem(JLabel label, JButton state) {
        this.label = label;
        this.state = state;
    }

    public JComponent getLabel() {
        return label;
    }

    public JComponent getState() {
        return state;
    }

    public void removeShip(Ship s){
        ships.remove(s);
        setState();
    }

    public void moveShipIn(Ship ship) {
        ships.add(ship);
        setState();
    }

    private void setState() {
        state.setText(ships.stream().map(Ship::getName).collect(Collectors.joining(" ")));
    }

    public void stop(){
        ships.clear();
        state.setText("");
    }

    public boolean haveCrossed(Ship ship) {
        return ship.getTactsOnItem() >= getTactsToCross(ship.isMovingFromUp());
    }

    public abstract int getTactsToCross(boolean movingFromUp);
}
