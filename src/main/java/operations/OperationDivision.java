package operations;

import exceptions.ArithmeticCalculatorException;
import exceptions.OutOfSpaceException;

import java.util.Map;
import java.util.Stack;

public class OperationDivision implements Operation{
    @Override
    public void exec(Stack<Double> stack, String[] arguments, Map<String, Double> listOfDefinitions) throws OutOfSpaceException, ArithmeticCalculatorException {
        if (stack.size() < 2) {
            throw new OutOfSpaceException(2);
        }
        double num1 = stack.pop();
        double num2 = stack.pop();
        if (num2 == 0) {
            throw new ArithmeticCalculatorException("/", num2);
        }
        stack.push(num1/num2);
    }
}
