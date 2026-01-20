/**
 * Description: This class is the interpreter util class of the interpreter design pattern demo.
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.interpreter.util;

import com.adam.app.design.pattern.demo.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InterpreterUtil {

    /**
     * parse the simple expression: just only plus and minus
     * @param expr the expression
     *             e.g. 5 3 2 1 + - *
     * @return the result of the expression
     */
    public static IExpression parse(String expr) {
        // split the expression into tokens
        expr = expr.replaceAll("([+\\-*/()])", " $1 ");
        String[] tokens = expr.trim().split("\\s+");
        IExpression result = new NumberExpression(Integer.parseInt(tokens[0]));

        for (int i = 1; i < tokens.length; i += 2) {
            String operator  = tokens[i];
            int nextValue = Integer.parseInt(tokens[i + 1]);

            // right number expression
            IExpression right = new NumberExpression(nextValue);
            // check operator +, -, *, /
            if (operator.equals("+")) {
                result = new AddExpression(result, right);
            } else if (operator.equals("-")) {
                result = new SubtractExpression(result, right);
            }
        }

        return result;
    }



    /**
     * Evaluate an expression in infix notation.
     * @param expr The expression to evaluate.
     * @return The result of the evaluation.
     * @throws IllegalArgumentException
     */
    public static int evaluate(String expr) throws IllegalArgumentException {
        List<String> postfix = infixToPostfix(expr);
        return evalPostfix(postfix);
    }

    private static List<String> infixToPostfix(String expr) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        // Tokenize expression
        expr = expr.replaceAll("([+\\-*/()])", " $1 ");
        String[] tokens = expr.trim().split("\\s+");
        for (String token : tokens) {
            if (isNumber(token)) {
                output.add(token);
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop(); // pop "("
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }

        // Pop remaining operators
        while (!operators.isEmpty()) {
            String op = operators.pop();
            if (op.equals("(") || op.equals(")")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(op);
        }

        return output;
    }

    private static int evalPostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix) {
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) throw new IllegalArgumentException("Invalid expression");
                int b = stack.pop();
                int a = stack.pop();
                int result;
                if (token.equals("+")) {
                    result = a + b;
                } else if (token.equals("-")) {
                    result = a - b;
                } else if (token.equals("*")) {
                    result = a * b;
                } else if (token.equals("/")) {
                    if (b == 0) throw new ArithmeticException("Division by zero");
                    result = a / b;
                } else {
                    throw new IllegalArgumentException("Unknown operator: " + token);
                }
                stack.push(result);
            }
        }

        if (stack.size() != 1) throw new IllegalArgumentException("Invalid expression");

        return stack.pop();
    }

    private static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int precedence(String op) {
            if (op.equals("+") || op.equals("-")) {
                return 1;
            } else if (op.equals("*") || op.equals("/")) {
                return 2;
            } else {
                return 0;
            }
    }

}
