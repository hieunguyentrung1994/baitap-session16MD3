package bt05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String sourceFileName = "sample.txt";
        String destinationFileName = "destination.txt";

        try {
            String fileContent = readFile(sourceFileName);
            String uppercaseContent = convertToUppercase(fileContent);
            writeFile(destinationFileName, uppercaseContent);
            System.out.println("Bản sao file đã được tạo: " + destinationFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }

    public static String convertToUppercase(String text) {
        return text.toUpperCase();
    }

    public static void writeFile(String fileName, String content) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(content);
        }
    }
}

