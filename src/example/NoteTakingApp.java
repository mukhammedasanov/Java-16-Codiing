package example;

import java.io.*;
import java.util.Scanner;

public class NoteTakingApp {
    private static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Жөнөкөй эскертмелерди жазуу колдонмосу ---");
            System.out.println("1. Жаңы эскертме кошуу");
            System.out.println("2. Бардык эскертмелерди көрүү");
            System.out.println("3. Бардык эскертмелерди өчүрүү");
            System.out.println("4. Чыгуу");
            System.out.print("Опцияны тандаңыз: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addNote(scanner);
                case 2 -> viewNotes();
                case 3 -> deleteNotes();
                case 4 -> {
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

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // Кошуу режиминде
            writer.write(note + System.lineSeparator());
            System.out.println("Эскертме ийгиликтүү кошулду!");
        } catch (IOException e) {
            System.err.println("Файлга жазууда ката кетти: " + e.getMessage());
        }
    }

    // Бардык эскертмелерди көрүү
    private static void viewNotes() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Scanner scanner = new Scanner(reader);

            System.out.println("\n--- Сиздин эскертмелер ---");
            boolean hasNotes = false;

            while (scanner.hasNext()) {
                hasNotes = true;
                System.out.println(scanner.nextLine());
            }

            if (!hasNotes) {
                System.out.println("Эскертмелер жок.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Эскертмелердин файлы табылган жок. Баштоо үчүн эскертме кошуңуз!");
        } catch (IOException e) {
            System.err.println("Файлды окууда ката кетти: " + e.getMessage());
        }
    }

    // Бардык эскертмелерди өчүрүү
    private static void deleteNotes() {
        try (FileWriter writer = new FileWriter(FILE_NAME)) { // Жазууну тазалоо режиминде
            // Файлды тазалоо үчүн эч нерсе жазбай коёбуз
            System.out.println("Бардык эскертмелер ийгиликтүү өчүрүлдү!");
        } catch (IOException e) {
            System.err.println("Файлды тазалоодо ката кетти: " + e.getMessage());
        }
    }
}
