package seabattle.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Utils {

    public static HashMap<String, Integer> keyMap() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        dictionary.put("A", 0);
        dictionary.put("B", 1);
        dictionary.put("C", 2);
        dictionary.put("D", 3);
        dictionary.put("E", 4);
        dictionary.put("F", 5);
        dictionary.put("G", 6);
        dictionary.put("H", 7);
        dictionary.put("I", 8);
        dictionary.put("J", 9);
        return dictionary;
    }

    public static void clearScreen() {
        System.out.println("\n");
    }

    private static String scanInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

    public static Integer[] scanCoordinates() {
        HashMap<String, Integer> dictionary = keyMap();
        Integer[] coordYX = new Integer[2];
        boolean isBadEnter = true;
        while (isBadEnter) {
            try {
                System.out.print("Please enter coordinate with a space(example \"10 F\"): ");
                String[] input = scanInput().split(" ");
                coordYX[0] = (Integer.parseInt(input[0])) - 1;
                coordYX[1] = dictionary.get(input[1].toUpperCase());
                isBadEnter = checkCoordinates(coordYX);
                if (isBadEnter) {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println("Bad coordinates. Try again.");
            }
        }
        return coordYX;
    }

    public static boolean checkCoordinates(Integer[] coordYX) {
        if (coordYX[0] == null || coordYX[1] == null || coordYX[0] > 9 || coordYX[1] > 9) {
            return true;
        }
        return false;
    }

    public static Integer scanShipType() {
        Integer shipType = null;
        boolean isBadEnter = true;
        while (isBadEnter) {
            try {
                System.out.print("Please enter ship type(1-4): ");
                String input = scanInput();
                shipType = Integer.parseInt(input);
                isBadEnter = checkShipType(shipType);
                if (isBadEnter) {
                    throw new NumberFormatException();
                }
            } catch (Exception e) {
                System.out.println("Bad type. Try again.");
            }
        }
        return shipType;
    }

    public static boolean checkShipType(Integer shipType) {
        if (shipType < 1 || shipType > 4) {
            return true;
        }
        return false;
    }

    public static ArrayList scanShipParams(Field field) {
        ArrayList params = null;
        boolean isLimitOfShip = true;
        while (isLimitOfShip) {
            params = new ArrayList();
            System.out.println("\nEnter ship type. It matches to the number of occupied cells.");
            int shipType = scanShipType();
            params.add(shipType);
            boolean isVacant = checkShipCount(field, shipType);
            if (isVacant){
                System.out.println("\nЕnter the coordinates of the cell in which the beginning of the ship will be.");
                params.add(scanCoordinates());
                System.out.println("\nЕnter the coordinates of the cell in which the end of the ship will be.");
                params.add(scanCoordinates());
                isLimitOfShip = false;
            }
        }

        return params;
    }

    public static boolean checkShipCount(Field field, int shipType) {
        int count = (int) field.getShips().stream()
                .filter(ship -> ship.getShipType().equals(shipType))
                .count();
        if (count < 3) {
            return true;
        }
        return false;
    }

}