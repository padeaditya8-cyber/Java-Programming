import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class FileOperations {
    private String filepath;

    public FileOperations(String filepath) {
        this.filepath = filepath;
    }

    public void createNewFile() {
        File file = new File(filepath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    public void readByteFile() {
        File file = new File(filepath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        System.out.println("\n--- Reading File (Byte Stream) ---");
        try (FileInputStream fis = new FileInputStream(file)) {
            int byteData;
            while ((byteData = fis.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Error reading byte stream: " + e.getMessage());
        }
    }

    public void writeByteFile(String data) {
        try (FileOutputStream fos = new FileOutputStream(filepath)) {
            byte[] bytes = data.getBytes();
            fos.write(bytes);
            System.out.println("Data written successfully using Byte Stream.");
        } catch (IOException e) {
            System.err.println("Error writing byte stream: " + e.getMessage());
        }
    }

    public void readCharacterFile() {
        File file = new File(filepath);
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        System.out.println("\n--- Reading File (Character Stream) ---");
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading character stream: " + e.getMessage());
        }
    }

    public void writeCharacterFile(String data) {
        try (FileWriter fw = new FileWriter(filepath);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            bw.write(data);
            bw.newLine();
            System.out.println("Data written successfully using Character Stream.");
        } catch (IOException e) {
            System.err.println("Error writing character stream: " + e.getMessage());
        }
    }

    public void appendDataFile(String data) {
        try (FileWriter fw = new FileWriter(filepath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            bw.write(data);
            bw.newLine();
            System.out.println("Data appended successfully to the file.");
        } catch (IOException e) {
            System.err.println("Error appending data: " + e.getMessage());
        }
    }

    public void displayFileInfo() {
        File file = new File(filepath);
        System.out.println("\n--- File Information ---");
        if (file.exists()) {
            System.out.println("File Name      : " + file.getName());
            System.out.println("Absolute Path  : " + file.getAbsolutePath());
            System.out.println("Size (Bytes)   : " + file.length());
            System.out.println("Is Readable    : " + file.canRead());
            System.out.println("Is Writable    : " + file.canWrite());
            System.out.println("Is Executable  : " + file.canExecute());
        } else {
            System.out.println("File does not exist at path: " + filepath);
        }
    }
}

public class TestFileHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name or relative path (e.g., sample.txt): ");
        String path = scanner.nextLine().trim();

        FileOperations fileOps = new FileOperations(path);
        fileOps.createNewFile();

        int choice = 0;
        do {
            System.out.println("\n================ MENU ================");
            System.out.println("1. File Read using Byte Stream");
            System.out.println("2. File Write using Byte Stream");
            System.out.println("3. File Read using Character Stream");
            System.out.println("4. File Write using Character Stream");
            System.out.println("5. Append Data to File");
            System.out.println("6. File Info");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid menu number.");
                continue;
            }

            switch (choice) {
                case 1:
                    fileOps.readByteFile();
                    break;

                case 2:
                    System.out.print("Enter text to write (Byte Stream): ");
                    String byteData = scanner.nextLine();
                    fileOps.writeByteFile(byteData);
                    break;

                case 3:
                    fileOps.readCharacterFile();
                    break;

                case 4:
                    System.out.print("Enter text to write (Character Stream): ");
                    String charData = scanner.nextLine();
                    fileOps.writeCharacterFile(charData);
                    break;

                case 5:
                    System.out.print("Enter text to append: ");
                    String appendData = scanner.nextLine();
                    fileOps.appendDataFile(appendData);
                    break;

                case 6:
                    fileOps.displayFileInfo();
                    break;

                case 7:
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Enter a value between 1 and 7.");
            }
        } while (choice != 7);

        scanner.close();
    }
}