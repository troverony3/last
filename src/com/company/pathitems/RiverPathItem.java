package com.company.pathitems;

import javax.swing.*;

public abstract class RiverPathItem {
    protected int tactsToCross;
    protected int currentTactSinceStart;

    private final JRadioButton state;

    protected RiverPathItem(JRadioButton state) {
        this.state = state;
    }

    public JRadioButton getState() {
        return state;
    }

    public void startCrossingUpThePath() {
        currentTactSinceStart = 0;
        state.setSelected(true);
        this.tactsToCross = getTactsToCross(true);
    }

    public void startCrossingDownThePath() {
        currentTactSinceStart = 0;
        state.setSelected(true);
        this.tactsToCross = getTactsToCross(false);
    }

    public void stop(){
        currentTactSinceStart = 0;
    }

    public void tact() {
        currentTactSinceStart++;
    }

    public boolean haveCrossed() {
        return currentTactSinceStart >= tactsToCross;
    }

    protected abstract int getTactsToCross(boolean movingFromUp);
}
