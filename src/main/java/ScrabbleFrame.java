import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ScrabbleFrame extends JFrame {

    public static final String WORD_NOT_IN_DICTIONARY = "Word not in dictionary";
    public static final String WORD_NOT_IN_TILES = "Word not in tiles";
    
    private final JLabel scoreLabel;
    private int score = 0;
    private JLabel[] tiles;
    private final JTextField inputField;
    private final JButton submitButton;
    private final JLabel outputLabel;

    private JPanel verticalPanel;

    private ScrabbleGame scrabbleGame;
    private ScrabbleDictionary dictionary;

    public ScrabbleFrame() {
        setTitle("Touro Scrabble");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        scrabbleGame = new ScrabbleGame(dictionary, letterPool);

        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        addTilesPanel(verticalPanel);

        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(120, 60));
        verticalPanel.add(inputField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this::onSubmitClicked);
        verticalPanel.add(submitButton);


        scoreLabel = new JLabel("Score: 0");
        verticalPanel.add(scoreLabel);

        outputLabel = new JLabel("Output: ");
        verticalPanel.add(outputLabel);


    }

    private void addTilesPanel(JPanel verticalPanel) {
        JPanel tilesPanel = new JPanel();
        tilesPanel.setLayout(new FlowLayout());
        tiles = new JLabel[7];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new JLabel(scrabbleGame.tiles.get(i).toString());
            tilesPanel.add(tiles[i]);
        }

        verticalPanel.add(tilesPanel);
    }

    public void onSubmitClicked(ActionEvent event) {
        String word = inputField.getText();
        if (scrabbleGame.playWord(word)) {
            score++;
            scoreLabel.setText("Score: " + score);

            for (int i = 0; i < tiles.length; i++) {
                tiles[i].setText(scrabbleGame.tiles.get(i).toString());
            }

        } else {
            if (!dictionary.isWord(word)) {
                outputLabel.setText(WORD_NOT_IN_DICTIONARY);
            } else {
                outputLabel.setText(WORD_NOT_IN_TILES);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ScrabbleFrame();

        frame.setVisible(true);
    }


}
