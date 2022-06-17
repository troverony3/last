package com.company.pathitems;

import javax.swing.*;

import static com.company.Main.SHIP_SPEED_METERS_PER_SEC;

public class Canal extends RiverPathItem {
    private final int tactsToCross;

    public Canal(int lengthInMeters, JLabel label, JButton state) {
        super(label, state);
        tactsToCross = lengthInMeters / SHIP_SPEED_METERS_PER_SEC;
    }

    @Override
    public int getTactsToCross(boolean movingFromUp) {
        return tactsToCross;
    }
}
