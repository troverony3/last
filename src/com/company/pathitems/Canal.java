package com.company.pathitems;

import javax.swing.*;

import static com.company.Main.SHIP_SPEED_METERS_PER_SEC;

public class Canal extends RiverPathItem {
    private final int tactsToCross;

    public Canal(int lengthInMeters, JRadioButton busyIndicator) {
        super(busyIndicator);
        tactsToCross = lengthInMeters/SHIP_SPEED_METERS_PER_SEC;
    }

    @Override
    protected int getTactsToCross(boolean movingFromUp) {
        return tactsToCross;
    }
}
