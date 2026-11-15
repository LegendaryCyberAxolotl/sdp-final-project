import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Facade facade = new Facade(scanner);

        System.out.println("Welcome to the 'Not Many Dungeons and Not Many Dragons' character creator!");

        boolean running = true;
        try {
            while (running) {
                System.out.println("\n========== MAIN MENU ==========");
                System.out.println("1. Create a character");
                System.out.println("2. Show all characters");
                System.out.println("3. Find a character by name");
                System.out.println("4. Enter an encounter");
                System.out.println("5. Exit");
                System.out.print("Enter 1-5: ");

                if (!scanner.hasNextLine()) {
                    break;
                }

                String input = scanner.nextLine().trim();

                switch (input) {
                    case "1":
                        facade.createCharacter();
                        break;
                    case "2":
                        facade.showCharacters();
                        break;
                    case "3":
                        facade.findCharacterByName();
                        break;
                    case "4":
                        facade.startEncounter();
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number from 1 to 5.");
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("\nInput ended.");
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
