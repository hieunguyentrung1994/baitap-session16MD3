package bt06;


    import java.io.BufferedReader;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.List;

    public class Main {
        public static void main(String[] args) {
            String sourceFileName = "destination.txt";
            String destinationFileName = "destination1.txt";

            try {
                // Đọc nội dung từ file nguồn
                String fileContent = readFile(sourceFileName);

                // Đảo ngược thứ tự các từ trong nội dung
                String reversedContent = reverseWords(fileContent);

                // Ghi nội dung đã đảo ngược vào file đích
                writeFile(destinationFileName, reversedContent);

                System.out.println("Bản sao file đã được tạo: " + destinationFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Đọc nội dung từ file và trả về dưới dạng chuỗi
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

        // Đảo ngược thứ tự các từ trong chuỗi
        public static String reverseWords(String text) {
            String[] words = text.split("\\s+"); // Tách các từ thành mảng các từ
            List<String> wordList = Arrays.asList(words); // Chuyển mảng thành danh sách
            Collections.reverse(wordList); // Đảo ngược thứ tự các phần tử trong danh sách
            return String.join(" ", wordList); // Ghép các từ lại thành một chuỗi mới, cách nhau bởi dấu cách
        }

        // Ghi nội dung vào file
        public static void writeFile(String fileName, String content) throws IOException {
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write(content);
            }
        }
    }


