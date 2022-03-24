import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ScrabbleFrame extends JFrame {

    private ScrabblePresenter presenter;

    public static final String WORD_NOT_IN_DICTIONARY = "Word not in dictionary";
    public static final String WORD_NOT_IN_TILES = "Word not in tiles";

    private final JLabel scoreLabel;
    private JLabel[] tiles;
    private final JTextField inputField;
    private final JButton submitButton;
    private final JLabel outputLabel;
    private JPanel verticalPanel;

    public ScrabbleFrame() {
        setTitle("Touro Scrabble");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        ScrabbleDictionary dictionary = new ScrabbleDictionary();
        LetterPool letterPool = new LetterPool();
        ScrabbleGame scrabbleGame = new ScrabbleGame(dictionary, letterPool);

        presenter = new ScrabblePresenter(this, scrabbleGame);

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
            tiles[i] = new JLabel();
            tilesPanel.add(tiles[i]);
        }

        verticalPanel.add(tilesPanel);

        presenter.fillTiles();
    }

    public void onSubmitClicked(ActionEvent event) {

        String word = inputField.getText();
        presenter.playWord(word);

    }

    public void setScore(String score) {
        scoreLabel.setText("Score: " + score);
    }

    public void setTiles(List<Character> tilesList){
        for (int i = 0; i < tilesList.size(); i++) {
            tiles[i].setText(tilesList.get(i).toString());
        }
    }

    public static void main(String[] args) {
        JFrame frame = new ScrabbleFrame();

        frame.setVisible(true);
    }



}
