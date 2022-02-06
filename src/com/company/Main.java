package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Elevator> floors = new ArrayDeque<>();
        int floor;
        while (true) {
            System.out.println("Ожидаю ввода этажа:");
            try {
                floor = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Неправильный формат ввода, используйте числа для ввода этажа");
                scanner.next();
                continue;
            }
            if (floor == 0) {
                break;
            }
            if (floor > 25 || floor < 0) {
                System.out.println("Такого этажа нет в доме");
            } else {
                floors.offer(new Elevator(floor));
                Elevator.timeMoveElevator(floor);
            }
        }
        Elevator.printResult(floors);
    }
}
