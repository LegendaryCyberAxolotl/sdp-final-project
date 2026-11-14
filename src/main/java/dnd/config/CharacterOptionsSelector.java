package dnd.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CharacterOptionsSelector {
    private final JsonCharacterOptionsReader jsonReader = new JsonCharacterOptionsReader();

    public CharacterOptions selectOptions(Path jsonPath, Scanner scanner) throws IOException {
        if (Files.exists(jsonPath)) {
            if (!Files.isRegularFile(jsonPath)) {
                throw new IOException("JSON path is not a file: " + jsonPath);
            }
            CharacterOptions options = jsonReader.read(jsonPath);
            CharacterOptionsValidator.validate(options);
            System.out.println("Loaded character options from " + jsonPath);
            return options;
        }
        System.out.println("JSON file not found (" + jsonPath + "). Using console selection.");
        return selectFromConsole(scanner);
    }

    private CharacterOptions selectFromConsole(Scanner scanner) {
        System.out.println("===== D&D CHARACTER CREATION =====");
        String race = choose(scanner, "Race", CharacterOptionsValidator.RACES);
        String charClass = choose(scanner, "Class", CharacterOptionsValidator.CLASSES);
        String subclass = choose(scanner, "Subclass (" + charClass + ")",
                CharacterOptionsValidator.subclassesFor(charClass));
        CharacterOptions options = new CharacterOptions(race, charClass, subclass);
        CharacterOptionsValidator.validate(options);
        return options;
    }

    private String choose(Scanner scanner, String title, String[] values) {
        System.out.println("\nChoose " + title + ":");
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
        while (true) {
            System.out.print("Enter 1-" + values.length + ": ");
            if (!scanner.hasNextLine()) throw new IllegalStateException("Input ended");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= values.length) return values[choice - 1];
            } catch (NumberFormatException ignored) { }
            System.out.println("Invalid choice. Try again.");
        }
    }
}
