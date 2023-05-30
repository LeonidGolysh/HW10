package exercise3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class wordFrequencySearch {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Leonid\\OneDrive\\Рабочий стол\\New folder (2)\\GoIt\\HW\\HW10\\src\\main\\java\\exercise3\\words.txt";
        Map<String, Integer> wordFrequency = calculateWordFrequency(fileName);
        printWordFrequency(wordFrequency);
    }

    private static Map<String, Integer> calculateWordFrequency(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for(String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }

    private static void printWordFrequency(Map<String, Integer> wordFrequency) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequency.entrySet());

        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for(Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
