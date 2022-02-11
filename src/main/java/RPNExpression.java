import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Sara Yaffe
 *
 * User is prompted to input an RPN expression which is passed to a method
 * that evaluates the expression by use of a stack, detecting 2 numbers followed by an operator
 */
public class RPNExpression {

    public static final String SYNTAX_ERROR = "Syntax Error";

    private String expression;
    private Stack<Double> stackExpression;

    public RPNExpression(String expression) {
        this.expression = expression;
        this.stackExpression = new Stack<>();
    }

    /**
     *
     * @return String
     */
    public String evaluate() {

        if (expression.length() == 0) {
            return "no expression given";
        } else {
            String[] splitExpression = expression.split("\\s+");
            for (String s : splitExpression) {

                if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
                    try {
                        Double num1 = stackExpression.pop();
                        Double num2 = stackExpression.pop();
                        double newNum = 0;

                        switch (s) {
                            case "-":
                                newNum = num2 - num1;
                                break;
                            case "+":
                                newNum = num2 + num1;
                                break;
                            case "/":
                                if (num1 != 0) {
                                    newNum = num2 / num1;
                                } else {
                                    return "cannot divide by zero";
                                }
                                break;
                            case "*":
                                newNum = num2 * num1;
                                break;
                        }

                        stackExpression.push(newNum);


                    } catch (EmptyStackException e) {
                        return SYNTAX_ERROR;
                    }

                } else {
                    try {
                        Double num = Double.parseDouble(s);
                        stackExpression.push(num);
                    } catch (NumberFormatException ex) {
                        return SYNTAX_ERROR;
                    }
                }

            }
            String result = String.format("%.2f", stackExpression.pop());
            if (!stackExpression.empty()) {
                return result + "\nextra junk ignored";
            } else {
                return result;
            }

        }
    }

    @Override
    public String toString() {
        return expression + " = " + evaluate();
    }
}
	
	
	
