package com.campusdual.classroom;

import com.campusdual.util.Utils;
import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise32 {

    public static void main(String[] args) {
        Exercise32 exercise = new Exercise32();
        String userInput = null;
        String stringToSave = exercise.generateStringToSave(userInput);

        exercise.printToFile(stringToSave);
        System.out.println("Saved in resources/data.txt.");

    }

    public static String generateStringToSave(String string) {
        if (string != null) {
            return string;
        } else {
            return generateUserInputToSave();
        }
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write: ");
        String string;
        while(!(string = scanner.nextLine()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/resources/data.txt", true))) {
            writer.write(string);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
