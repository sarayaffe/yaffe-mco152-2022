import java.util.*;

public class ScrabbleGame {

    private List<String> playedWords = new ArrayList<>();
    private List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary = new ScrabbleDictionary();
    private Random rnd = new Random();


    public ScrabbleGame() {
        initializeTiles();
    }

    private void initializeTiles() {
        for (int i = 0; i < 7; i++) {
            tiles.add((char) (rnd.nextInt(26) + 'a'));
        }
    }

    public void playGame(Scanner scanner) {
        while (true) {
            System.out.println("Enter word with given letters or 'exit' to end game\n" + tiles);
            String word = scanner.nextLine().toLowerCase();
            if (word.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else if (!playWord(word)) {
                System.out.println("invalid word. try again: ");
            }
        }
    }

    /**
     * If the word exists in the ScrabbleDictionary, the letters exist in the tiles List,
     * and playedWords does not yet contain the word,
     * remove the letters from the list and add new random letters.
     *
     * @param word
     */
    public boolean playWord(String word) {
        char[] wordLetters = word.toCharArray();

        if (dictionary.isWord(word) && !playedWords.contains(word) && isWordInTiles(wordLetters)) {
            playedWords.add(word);
            while (tiles.contains('0')) {
                tiles.remove(Character.valueOf('0'));
            }
            for (int i = 0; i < word.length(); i++) {
                tiles.add((char) (rnd.nextInt(26) + 'a'));
            }
            return true;
        }
        return false;
    }

    private boolean isWordInTiles(char[] wordLetters) {
        List<Character> tilesCopy = new ArrayList<>(tiles);

        for (char letter : wordLetters) {
            if (tiles.contains(letter)) {
                tiles.set(tiles.indexOf(letter), '0');
            } else {
                tiles = tilesCopy;
                return false;
            }
        }
        return true;
    }
}
