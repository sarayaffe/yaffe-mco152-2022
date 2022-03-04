import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RPNFrame extends JFrame {

    private JTextField expressionText;
    private JButton submitButton;
    private JLabel resultLabel;

    private JPanel verticalPanel;

    private RPNExpression rpn;

    public RPNFrame(){
        setTitle("RPN Calculator");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        verticalPanel = new JPanel();
        verticalPanel.setLayout(new BorderLayout(20, 20));
        add(verticalPanel);

        expressionText =  new JTextField();
        expressionText.setHorizontalAlignment(JTextField.CENTER);
        expressionText.setPreferredSize(new Dimension(170, 60));
        TitledBorder promptBorder = BorderFactory.createTitledBorder("Enter RPN Expression");
        promptBorder.setTitleJustification(TitledBorder.CENTER);
        expressionText.setBorder(promptBorder);
        verticalPanel.add(expressionText, BorderLayout.NORTH);

        submitButton = new JButton("CALCULATE");
        submitButton.addActionListener(this::onSubmitClick);
        verticalPanel.add(submitButton, BorderLayout.CENTER);

        resultLabel = new JLabel("RESULT:");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        verticalPanel.add(resultLabel, BorderLayout.SOUTH);
    }

    public void onSubmitClick(ActionEvent e){
        String expression = expressionText.getText();
        rpn = new RPNExpression(expression);
        resultLabel.setText(rpn.evaluate());

    }

    public static void main(String[] args) {
        JFrame frame = new RPNFrame();
        frame.setVisible(true);
    }


}
