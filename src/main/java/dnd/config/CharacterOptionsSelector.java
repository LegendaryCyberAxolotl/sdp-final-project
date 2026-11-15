
package dnd.config;

import java.util.Scanner;

public class CharacterOptionsSelector {

    public CharacterOptions selectOptions(Scanner scanner) {
        System.out.println("===== D&D CHARACTER CREATION =====");

        String race = choose(scanner, "Race",
                CharacterOptionsValidator.RACES);

        String charClass = choose(scanner, "Class",
                CharacterOptionsValidator.CLASSES);

        String subclass = choose(scanner, "Subclass (" + charClass + ")",
                CharacterOptionsValidator.subclassesFor(charClass));

        CharacterOptions options =
                new CharacterOptions(race, charClass, subclass);

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

            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("Input ended");
            }

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

                if (choice >= 1 && choice <= values.length) {
                    return values[choice - 1];
                }

            } catch (NumberFormatException ignored) {
            }

            System.out.println("Invalid choice. Try again.");
        }
    }
}
