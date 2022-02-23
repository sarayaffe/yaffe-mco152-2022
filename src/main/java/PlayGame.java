import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScrabbleGame scrabbleGame = new ScrabbleGame();
        scrabbleGame.playGame(scanner);
    }
}
