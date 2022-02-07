package com.company;

import java.util.Deque;

public class Elevator {

    private int floor;

    private static int totalSeconds = 0;
    private static int  previousFloor = -1;

    public Elevator(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "" + floor;
    }

    public static void timeMoveElevator(int floor) {
        final int WAIT_DOORS_IN_SECOND = 10;
        final int WAIT_MOVE_IN_SECOND = 5;
        if (previousFloor != -1) {
            totalSeconds += Math.abs((floor - previousFloor)) * WAIT_MOVE_IN_SECOND + WAIT_DOORS_IN_SECOND;
        }
        previousFloor = floor;
    }

    public static void printResult(Deque<Elevator> floors) {
        timeMoveElevator(0);
        System.out.println("Лифт проследовал по следующим этажам");
        while (!floors.isEmpty()) {
            System.out.print("этаж " + floors.poll() + " -> ");
        }
        System.out.println("Выход");
        System.out.println("Время затраченное лифтом на маршрут = " + totalSeconds + " сек.");
    }

    public static int getPreviousFloor() {
        return previousFloor;
    }
}
