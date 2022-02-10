import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Sara Yaffe
 * 
 * User is prompted to input an RPN expression which is passed to a method
 * that evaluates the expression by use of a stack, detecting 2 numbers followed by an operator 
 *
 */
public class RPNCalculator {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String expression;

		do {
			System.out.println("Enter an RPN expression: ");
			expression = in.nextLine();
			if (expression.length() != 0) {
				System.out.println(evaluate(expression));
			}
		} while (expression.length() != 0);

		System.out.println("The End");

	}

	
	/**
	 * @param expression
	 * @return String
	 * 
	 */
	private static String evaluate(String expression) {
		Stack<Double> stackExpression = new Stack<>();

		String[] splitExpression = expression.split("\\s+");
		for (String s : splitExpression) {

			if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
				try {
					Double num1 = stackExpression.pop();
					Double num2 = stackExpression.pop();
					double newNum = 0.0;

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
					return "Syntax Error";
				}

			} else {
				try {
					Double num = Double.parseDouble(s);
					stackExpression.push(num);
				}

				catch (NumberFormatException ex) {
					return "Syntax Error";
				}
			}

		}
		String result = String.format( "%.2f", stackExpression.pop());
		if (!stackExpression.empty()) {
			return result + "\nextra junk ignored";
		} else {
			return result;
		}

	}
	
	
	
}