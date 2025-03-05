package xyz.tigad049;

import java.util.ArrayList;

public class DayOne2015 {
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void testInput() {
        ArrayList<String> inputs;
        inputs = ReadFile.getInput("src/main/resources/day1_test.txt");
        if (inputs.size() > 0) {
            for (int i = 0; i < inputs.size(); i++) {
                String plan = inputs.get(i);
                int floor = 0;

                for (char c : plan.toCharArray()) {
                    if (c == '(') {
                        floor++;
                    } else if (c == ')') {
                        floor--;
                    }
                }

                System.out.println("Plan: " + plan + " || Floor we landed on: " + String.valueOf(floor));
            }
        }
    }

    public static void partOne() {
        System.out.println("Advent of Code 2015: Day 1, Part 1");
        ArrayList<String> inputs;
        inputs = ReadFile.getInput("src/main/resources/day1.txt");
        if (inputs.size() > 0) {
            for (int i = 0; i < inputs.size(); i++) {
                String plan = inputs.get(i);
                int floor = 0;

                for (char c : plan.toCharArray()) {
                    if (c == '(') {
                        floor++;
                    } else if (c == ')') {
                        floor--;
                    }
                }

                System.out.println("Floor we landed on: " + String.valueOf(floor));
            }
        }
    }

    public static void partTwo() {
        System.out.println("Advent of Code 2015: Day 1, Part 2");
        ArrayList<String> inputs;
        inputs = ReadFile.getInput("src/main/resources/day1.txt");
        if (inputs.size() > 0) {
            for (int i = 1; i < inputs.size() + 1; i++) {
                String plan = inputs.get(i - 1);
                int floor = 0;
                int charPos = 0;

                for (char c : plan.toCharArray()) {
                    if (c == '(') {
                        floor++;
                    } else if (c == ')') {
                        floor--;
                    }
                    charPos++;

                    if (floor == -1) {
                        System.out.println("Entered the basement at character position: " + String.valueOf(charPos));
                    }
                }
            }
        }
    }
}
