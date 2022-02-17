import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class ScrabbleDictionary {

    private HashMap<String, String> words = new HashMap<>();

    public ScrabbleDictionary() {
        File file = new File("dictionary.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] entry = line.split(" ", 2);
                if (entry.length == 1) {
                    words.put(entry[0], "");
                } else {
                    words.put(entry[0], entry[1]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isWord(String lookupWord) {
        return getDefinition(lookupWord) != null;
    }

    public String getDefinition(String lookupWord) {
        String lookupWordUpper = lookupWord.toUpperCase();
        return words.get(lookupWordUpper);
    }
}

