import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Path jsonPath = args.length > 0 ? Path.of(args[0]) : Path.of("character.json");
        try (Scanner scanner = new Scanner(System.in)) {
            CharacterOptionsSelector selector = new CharacterOptionsSelector();
            CharacterOptions options = selector.selectOptions(jsonPath, scanner);
            Character character = new CharacterCreator().create(options);
            character.showInfo();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}
