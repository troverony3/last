package com.company;

public class Ship {
    private final String name;
    private int currentPosition;
    private int tactsOnItem;
    private int size;

    private final boolean movingFromUp;
//    private final int startingOnTakt;

    public Ship(String name, boolean movingFromUp, int startingOnTakt) {
        this.name = name;
        this.movingFromUp = movingFromUp;
//        this.startingOnTakt = startingOnTakt;
        //отложенный старт корабля
        this.tactsOnItem = - startingOnTakt;
    }

    public String getName() {
        return name;
    }

    public void setRiverSize(int size) {
        this.size = size;
        currentPosition = movingFromUp ? size - 1 : 0;
    }

    public boolean isMovingFromUp() {
        return movingFromUp;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getTactsOnItem() {
        return tactsOnItem;
    }

    public void moveOneFurther() {
        tactsOnItem = 0;

        if (!isMoving()) {
            //дошли до конца
            return;
        }
        currentPosition = movingFromUp ? (currentPosition - 1): (currentPosition + 1);
    }

    public void tact() {
        tactsOnItem++;
    }

    public boolean isMoving(){
        return (currentPosition != 0 && movingFromUp) || (currentPosition != (size - 1) && !movingFromUp);
    }
}
