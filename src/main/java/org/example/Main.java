package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void printValidPhoneNumbers(String filename) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            Pattern pattern = Pattern.compile("(\\(\\d{3}\\) \\d{3}-\\d{4})|(\\d{3}-\\d{3}-\\d{4})");

            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.matches()) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        printValidPhoneNumbers("C:\\Users\\Leonid\\OneDrive\\Рабочий стол\\New folder (2)\\GoIt\\HW\\HW10\\src\\main\\java\\org\\example\\file.txt");
    }
}