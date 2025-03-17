package xyz.tigad049;

import java.lang.Math;
import java.util.ArrayList;


public class Y2024Day2 {
    public static void main(String[] args) {
        partOne();
    }

    public static void testInput() {
        ArrayList<String> inputs;
        Integer safeReports = 0;

        inputs = ReadFile.getInput("src/main/resources/2024/day2_test.txt");
        if (inputs.size() > 0) {
            for (int i = 0; i < inputs.size(); i++) {
                String reportString = inputs.get(i);
                ArrayList<Integer> reportIntegers = getLevels(reportString);
                boolean safe = isSafe(reportIntegers);
                if (safe) {
                    safeReports++;
                }

                System.out.println(reportString + " Safe?: " + safe);
            }
        }

        System.out.println("\n" + safeReports + " safe reports!");
    }

    public static void partOne() {
        ArrayList<String> inputs;
        Integer safeReports = 0;

        inputs = ReadFile.getInput("src/main/resources/2024/day2.txt");
        if (inputs.size() > 0) {
            for (int i = 0; i < inputs.size(); i++) {
                String reportString = inputs.get(i);
                ArrayList<Integer> reportIntegers = getLevels(reportString);
                boolean safe = isSafe(reportIntegers);
                if (safe) {
                    safeReports++;
                }

                System.out.println(reportString + " Safe?: " + safe);
            }
        }

        System.out.println("\n" + safeReports + " safe reports!");
    }

    private static ArrayList<Integer> getLevels(String report) {
        ArrayList<Integer> levels = new ArrayList<>();
        Integer newNumber = 0;

        for (char c : report.toCharArray()) {
            if (!Character.isSpaceChar(c)) {
                newNumber = (newNumber*10) + Character.getNumericValue(c);
            } else {
                levels.add(newNumber);
                newNumber = 0;
            }
        }
        levels.add(newNumber);
        newNumber = 0;

        return levels;
    }

    private static boolean isSafe(ArrayList<Integer> report) {
        boolean isSafe = true;
        boolean isAscending = true;

        if (report.get(0) - report.get(1) > 0) {
            isAscending = false;
        }

        int i = 0;
        while (i < report.size() - 1) {
            int next = i + 1;
            if (next > report.size()) {
                next = report.size();
            }

            if (Math.abs(report.get(i) - report.get((next))) >= 4) {
                isSafe = false;
            }

            if (isAscending) {
                if (report.get(i) - report.get(next) > 0) {
                    isSafe = false;
                }
            } else {
                if (report.get(i) - report.get(next) < 0) {
                    isSafe = false;
                }
            }

            if (report.get(i) == report.get(next)) {
                isSafe = false;
            }

            i++;
        }

        return isSafe;
    }
}

