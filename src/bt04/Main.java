package bt04;

import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        try {
            String fileContent = readFile(fileName);
            String[] words = fileContent.split("\\s+");

            List<String> longestWords = findLongestWords(words);
            System.out.println("Các từ có độ dài lớn nhất trong file:");
            for (String word : longestWords) {
                System.out.println("- " + word + " (độ dài: " + word.length() + ")");
            }
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

    public static List<String> findLongestWords(String[] words) {
        int maxLength = 0;
        List<String> longestWords = new ArrayList<>();

        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords = new ArrayList<>();
                longestWords.add(word);
            } else if (length == maxLength) {
                longestWords.add(word);
            }
        }

        return longestWords;
    }
}

