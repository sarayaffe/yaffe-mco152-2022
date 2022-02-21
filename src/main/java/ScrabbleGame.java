import java.util.*;

public class ScrabbleGame {

    private List<String> playedWords = new ArrayList<>();
    private List<Character> tiles = new ArrayList<>();
    private ScrabbleDictionary dictionary = new ScrabbleDictionary();
    Random rnd = new Random();
    Scanner scanner = new Scanner(System.in);


    public ScrabbleGame() {
        for (int i = 0; i < 7; i++) {
            tiles.add((char) (rnd.nextInt(26) + 'a'));
        }
        playGame(scanner);

    }

    public void playGame(Scanner scanner) {
        while (true) {
            System.out.println("Enter word with given letters\n" + tiles);
            String word = scanner.nextLine();
            char[] wordLetters = word.toCharArray();
            if (playWord(word, wordLetters)) {
                playedWords.add(word);
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < tiles.size(); j++) {
                        if (wordLetters[i] == (tiles.get(j))) {
                            tiles.remove(tiles.get(j));
                            tiles.add((char) (rnd.nextInt(26) + 'a'));
                            //if duplicate in tiles list, only remove one
                        }
                    }
                }
            }
        }

    }


    /**
     * If the word exists in the ScrabbleDictionary and the letters exist in the tiles List,
     * remove the letters from the list and add new *random* letters.
     *
     * @param word
     */


    public boolean playWord(String word, char[] wordLetters) {
        boolean isTile = false;
        for (char letter : wordLetters) {
            isTile = tiles.contains(letter);
        }
        if (dictionary.isWord(word) && !playedWords.contains(word) && isTile) {
            return true;
        }
        return false;
    }
}
