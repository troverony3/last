package com.company.pathitems;

import com.company.Ship;

import javax.swing.*;

public class Lock extends RiverPathItem {
    private static final int TACTS_TO_OPEN_CLOSE_GATE = 1;
    private static final int TACTS_TO_ENTER = 5;
    private static final int TACTS_TO_LEAVE = 1;
    private static final int TACTS_TO_PARK = 1;
    private boolean empty = true;

    public Lock(JLabel label, JButton state) {
        super(label, state);
    }

    @Override
    public int getTactsToCross(boolean movingFormDown) {
        return tacksToLevelWater(movingFormDown) + TACTS_TO_OPEN_CLOSE_GATE + TACTS_TO_ENTER + TACTS_TO_PARK + TACTS_TO_OPEN_CLOSE_GATE + TACTS_TO_LEAVE;
    }

    @Override
    public void stop() {
        super.stop();
        empty = true;
    }

    @Override
    public void moveShipIn(Ship ship) {
        super.moveShipIn(ship);
        empty = !empty;
    }

    private int tacksToLevelWater(boolean movingFormDown) {
        if (movingFormDown && empty) {
            return 0;
        } else if (movingFormDown && !empty) {
            return 5;
        } else if (!movingFormDown && empty) {
            return 5;
        } else {
            return 0;
        }
    }
}
