package xyz.tigad049;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {

    }

    public static ArrayList<String> getInput(String filePath) {
        ArrayList<String> data = new ArrayList<String>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String row = myReader.nextLine();
                data.add(row);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        }
        return data;
    }
}
