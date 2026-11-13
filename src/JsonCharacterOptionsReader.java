import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/** Reads a flat JSON object with string fields: race, class, subclass.
 * No external libraries required; rejects unsupported JSON shapes.
 */
public class JsonCharacterOptionsReader {
    public CharacterOptions read(Path path) throws IOException {
        String content = Files.readString(path, StandardCharsets.UTF_8);
        try {
            Map<String, String> fields = new Parser(content).parse();
            if (!fields.keySet().equals(java.util.Set.of("race", "class", "subclass"))) {
                throw new IllegalArgumentException("JSON must contain exactly: race, class, subclass");
            }
            return new CharacterOptions(fields.get("race"), fields.get("class"), fields.get("subclass"));
        } catch (IllegalArgumentException ex) {
            throw new IOException("Invalid JSON in " + path + ": " + ex.getMessage(), ex);
        }
    }

    private static final class Parser {
        private final String text;
        private int pos;
        Parser(String text) { this.text = text; }

        Map<String, String> parse() {
            Map<String, String> result = new HashMap<>();
            whitespace(); expect('{'); whitespace();
            if (take('}')) { finish(); return result; }
            while (true) {
                String key = string(); whitespace(); expect(':'); whitespace();
                String value = string();
                if (result.putIfAbsent(key, value) != null)
                    throw error("Duplicate field: " + key);
                whitespace();
                if (take('}')) break;
                expect(','); whitespace();
            }
            finish();
            return result;
        }
        void finish() { whitespace(); if (pos != text.length()) throw error("Unexpected trailing content"); }
        void whitespace() {
            while (pos < text.length() && (text.charAt(pos) == ' ' || text.charAt(pos) == '\n'
                    || text.charAt(pos) == '\r' || text.charAt(pos) == '\t')) pos++;
        }
        boolean take(char c) {
            if (pos < text.length() && text.charAt(pos) == c) { pos++; return true; }
            return false;
        }
        void expect(char c) { if (!take(c)) throw error("Expected '" + c + "'"); }
        String string() {
            expect('"');
            StringBuilder value = new StringBuilder();
            while (pos < text.length()) {
                char c = text.charAt(pos++);
                if (c == '"') return value.toString();
                if (c < 0x20) throw error("Control character in string");
                if (c != '\\') { value.append(c); continue; }
                if (pos >= text.length()) throw error("Incomplete escape");
                char escaped = text.charAt(pos++);
                switch (escaped) {
                    case '"': value.append('"'); break;
                    case '\\': value.append('\\'); break;
                    case '/': value.append('/'); break;
                    case 'b': value.append('\b'); break;
                    case 'f': value.append('\f'); break;
                    case 'n': value.append('\n'); break;
                    case 'r': value.append('\r'); break;
                    case 't': value.append('\t'); break;
                    case 'u':
                        if (pos + 4 > text.length()) throw error("Incomplete unicode escape");
                        try { value.append((char) Integer.parseInt(text.substring(pos, pos + 4), 16)); }
                        catch (NumberFormatException ex) { throw error("Invalid unicode escape"); }
                        pos += 4;
                        break;
                    default: throw error("Invalid escape sequence");
                }
            }
            throw error("Unterminated string");
        }
        IllegalArgumentException error(String message) {
            return new IllegalArgumentException(message + " at position " + pos);
        }
    }
}
