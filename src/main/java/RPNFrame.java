import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RPNFrame extends JFrame {

    private JLabel promptLabel;
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
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        add(verticalPanel);

        promptLabel = new JLabel("Enter RPN Expression");
        verticalPanel.add(promptLabel);

        expressionText =  new JTextField();
        expressionText.setPreferredSize(new Dimension(120, 40));
        verticalPanel.add(expressionText);

        submitButton = new JButton("CALCULATE");
        submitButton.addActionListener(this::onSubmitClick);
        verticalPanel.add(submitButton);

        resultLabel = new JLabel();
        verticalPanel.add(resultLabel);
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
