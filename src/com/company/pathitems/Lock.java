package com.company.pathitems;

import javax.swing.*;

public class Lock extends RiverPathItem {
    private static final int TACTS_TO_OPEN_CLOSE_GATE = 1;
    private static final int TACTS_TO_ENTER = 5;
    private static final int TACTS_TO_LEAVE = 1;
    private static final int TACTS_TO_PARK = 1;
    private boolean empty = true;

    public Lock(JRadioButton busyIndicator) {
        super(busyIndicator);
    }

    @Override
    protected int getTactsToCross(boolean movingFormDown) {
        return tacksToLevelWater(movingFormDown) + TACTS_TO_OPEN_CLOSE_GATE + TACTS_TO_ENTER + TACTS_TO_PARK + TACTS_TO_OPEN_CLOSE_GATE + TACTS_TO_LEAVE;
    }

    private int tacksToLevelWater(boolean movingFormDown) {
        if (movingFormDown && empty) {
            empty = !empty;
            return 0;
        } else if (movingFormDown && !empty) {
            empty = !empty;
            return 5;
        } else if (!movingFormDown && empty) {
            empty = !empty;
            return 5;
        } else {
            empty = !empty;
            return 0;
        }
    }
}
