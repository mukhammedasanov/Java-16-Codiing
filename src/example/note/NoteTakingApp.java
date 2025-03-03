package example.note;

import java.io.*;
import java.util.Scanner;
import java.util.UUID;

public class NoteTakingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Жөнөкөй эскертмелерди жазуу колдонмосу ---");
            System.out.println("1. Жаңы эскертме кошуу");
            System.out.println("2. Бардык эскертмелерди көрүү");
            System.out.println("3. Чыгуу");
            System.out.print("Опцияны тандаңыз: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Жаңы сапты жутуу

            switch (choice) {
                case 1 -> addNote(scanner);
                case 2 -> viewNotes();
                case 3 -> {
                    running = false;
                    System.out.println("Чыгып жатам... Кош келиңиз!");
                }
                default -> System.out.println("Туура эмес тандоо. Сураныч, кайра аракет кылып көрүңүз.");
            }
        }
        scanner.close();
    }

    // Жаңы эскертме кошуу
    private static void addNote(Scanner scanner) {
        System.out.print("Эскертмени жазыңыз: ");
        String note = scanner.nextLine();

        // Генерациялоо уникалдуу файл аты
        String fileName = "note_" + UUID.randomUUID().toString() + ".txt"; // UUID уникалдуу аттарды берет

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(note);
            System.out.println("Эскертме ийгиликтүү кошулду! Файл аты: " + fileName);
        } catch (IOException e) {
            System.err.println("Файлга жазууда ката кетти: " + e.getMessage());
        }
    }

    // Бардык эскертмелерди көрүү (Бардык файлдарды көрүү)
    private static void viewNotes() {
        // Директорийден бардык файлдарды издеп чыгууну кааласак, төмөнкү кодду кошсо болот
        File folder = new File(".");
        File[] listOfFiles = folder.listFiles((dir, name) -> name.startsWith("note_") && name.endsWith(".txt"));

        System.out.println("\n--- Бардык эскертмелер ---");
        if (listOfFiles != null && listOfFiles.length > 0) {
            for (File file : listOfFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    System.out.println("Файл: " + file.getName());
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.err.println("Файлды окууда ката кетти: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Эскертмелер жок.");
        }
    }
}
