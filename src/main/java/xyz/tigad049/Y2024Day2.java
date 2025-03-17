package xyz.tigad049;

import java.lang.Math;
import java.util.ArrayList;


public class Y2024Day2 {
    public static void main(String[] args) {
        testInput();
    }

    public static void testInput() {
        ArrayList<String> inputs;

        inputs = ReadFile.getInput("src/main/resources/2024/day2_test.txt");
        if (inputs.size() > 0) {
            for (int i = 0; i < inputs.size(); i++) {
                String reportString = inputs.get(i);
                ArrayList<Integer> reportIntegers = getLevels(reportString);
                boolean safe = isSafe(reportIntegers);

                System.out.println(reportString + " Safe?: " + safe);
            }
        }
    }

    private static ArrayList<Integer> getLevels(String report) {
        ArrayList<Integer> levels = new ArrayList<>();

        for (char c : report.toCharArray()) {
            if (!Character.isSpaceChar(c)) {
                levels.add(Character.getNumericValue(c));
            }
        }

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
            if (Math.abs(report.get(i) - report.get((i+1))) > 3) {
                isSafe = false;
            }

            if (isAscending) {
                if (report.get(i) - report.get(i + 1) > 0) {
                    isSafe = false;
                }
            } else {
                if (report.get(i) - report.get(i + 1) < 0) {
                    isSafe = false;
                }
            }

            if (report.get(i) == report.get(i + 1)) {
                isSafe = false;
            }

            i++;
        }

        return isSafe;
    }
}

