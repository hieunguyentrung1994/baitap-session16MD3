package bt01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Bước 1: Tạo file "sample.txt" và ghi nội dung mẫu vào file
        createSampleFile();
        // Bước 2: Đọc nội dung từ file và đếm số từ
        String fileName = "sample.txt";
        String fileContent = readFile(fileName);
        int wordCount = countWords(fileContent);

        // Bước 3: Hiển thị số lượng từ trong file
        System.out.println("Số lượng từ trong file: " + wordCount);
    }
    public static void createSampleFile() {
        String fileName = "sample.txt";
        String fileContent = "file được tạo đang làm việc tai Sample.txt \n dòng 2 \n dòng 3 ";

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(fileContent);
            fileWriter.close();
            System.out.println("File created: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
    public static int countWords(String fileContent) {
        String[] words = fileContent.split("\\s+");
        return words.length;
    }
}