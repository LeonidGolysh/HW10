package exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteJsonFile {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\Leonid\\OneDrive\\Рабочий стол\\New folder (2)\\GoIt\\HW\\HW10\\src\\main\\java\\exercise2\\file.txt";
        String outputFile = "C:\\Users\\Leonid\\OneDrive\\Рабочий стол\\New folder (2)\\GoIt\\HW\\HW10\\src\\main\\java\\exercise2\\user.json";

        List<User> userList = readUserFromFile(inputFile);
        writeUsersToJsonFile(userList, outputFile);
    }

    private static List<User> readUserFromFile(String fileName) {
        List<User> userList = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] headers = null;

            if((line = bufferedReader.readLine()) != null) {
                headers = line.split(" ");
            }

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" ");

                if(data.length == headers.length) {
                    User user = new User();

                    for (int i = 0; i < data.length; i++) {
                        String header = headers[i];
                        String value = data[i];

                        if("name".equals(header)) {
                            user.setName(value);
                        } else if("age".equals(header)) {
                            user.setAge(Integer.parseInt(value));
                        }
                    }
                    userList.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }

    private static void writeUsersToJsonFile(List<User> userList, String fileName) {
        try(FileWriter fileWriter = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(userList);

            System.out.println(json);

            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
            }
            fileWriter.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
