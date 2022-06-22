package operations;

import exceptions.OutOfSpaceException;

import java.util.Map;
import java.util.Stack;

public class OperationMinus implements Operation {
    @Override
    public void exec(Stack<Double> stack, String[] arguments, Map<String, Double> listOfDefinitions) throws OutOfSpaceException {
        if (stack.size() < 2) {
            throw new OutOfSpaceException(2);
        }
        double num1 = stack.pop();
        double num2 = stack.pop();
        stack.push(num1-num2);
    }
}
