import java.util.*;

public class ScrabbleGame {

    List<String> playedWords = new ArrayList<>();
    List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary;
    private LetterPool letterPool;


    public ScrabbleGame(ScrabbleDictionary dictionary,
                        LetterPool letterPool) {
        this.dictionary = dictionary;
        this.letterPool = letterPool;
        initializeTiles();
    }

    private void initializeTiles() {
        for (int i = 0; i < 7; i++) {
            tiles.add(letterPool.getRandomLetter());
        }
    }


    public void playGame(Scanner scanner) {
        while (true) {
            System.out.println("Enter word with given letters or 'exit' to end game\n" + tiles);
            String word = scanner.nextLine().toUpperCase();
            if (word.equals("EXIT")) {
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
            for (int i = 0; i < word.length(); i++) {
                tiles.add(letterPool.getRandomLetter());
            }
            return true;
        }
        return false;
    }

    private boolean isWordInTiles(char[] wordLetters) {
        List<Character> tilesCopy = new ArrayList<>(tiles);

        for (char letter : wordLetters) {
            if (!tiles.remove((Character) letter)) {
                tiles = tilesCopy;
                return false;
            }
        }
        return true;
    }
}