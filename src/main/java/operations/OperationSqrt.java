package operations;

import exceptions.ArithmeticCalculatorException;
import exceptions.OutOfSpaceException;

import java.util.Map;
import java.util.Stack;

public class OperationSqrt implements Operation{
    @Override
    public void exec(Stack<Double> stack, String[] arguments, Map<String, Double> listOfDefinitions) throws OutOfSpaceException, ArithmeticCalculatorException {

        if (stack.size() < 1) {
            throw new OutOfSpaceException(1);
        }

        double num = stack.pop();

        if (num < 0) {
            throw new ArithmeticCalculatorException("sqrt", num);
        }

        stack.push(Math.sqrt(num));
    }
}
