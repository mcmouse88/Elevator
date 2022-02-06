package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> elevator = new ArrayDeque<>();
        int floor;
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 0;
        int previousFloor = -1;
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
                elevator.offer(floor);
                if (previousFloor != -1) {
                    totalSeconds += Math.abs((floor - previousFloor)) * waitMoveInSeconds + waitDoorsInSeconds;
                }
                previousFloor = floor;
            }

        }
        System.out.println("Лифт проследовал по следующим этажам");
        while (!elevator.isEmpty()) {
            System.out.print(elevator.poll() + " -> ");
        }
        System.out.println("Выход");
        System.out.println("Время затраченное лифтом на маршрут = " + totalSeconds + " сек.");
    }
}
