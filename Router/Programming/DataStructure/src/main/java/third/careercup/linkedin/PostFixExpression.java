package third.careercup.linkedin;

import java.util.Stack;

/**
 * Write an algorithm to evaluate postfix expression.
 * Created by ritesh on 1/14/16.
 */
public class PostFixExpression {

    public static void main(String args[]) {

        final String s= "23+6*9+";

        System.out.println(evaluatePostFixExpression(s));
    }

    public static int evaluatePostFixExpression(String input) {

        char[] charInputs = input.toCharArray();

        final Stack<Integer> stack = new Stack<>();

        for (final char charInput : charInputs) {

            if (isOperator(charInput)) {
                int number1 = stack.pop();
                int number2 = stack.pop();
                try {
                    int result = getResult(number1, number2, charInput);
                    stack.push(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                stack.push(charInput - '0');
            }
        }

       return stack.pop();
    }


    public static boolean isOperator(char operator) {

        switch (operator) {
            case '+':
                return true;
            case '-':
                return true;
            case '*':
                return true;
            case '/':
                return true;
            default:
                return false;
        }
    }

    public static int getResult(int number1, int number2, char operator) throws Exception {

        switch (operator) {
            case '+':
                return number1 + number2;
            case '-':
                return number1 - number2;
            case '*':
                return number1 * number2;
            case '/':
                return number1 / number2;
            default:
                throw new Exception("Not supported");
        }
    }
}
