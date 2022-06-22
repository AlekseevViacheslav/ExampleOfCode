package operations;

import exceptions.OutOfSpaceException;

import java.util.Map;
import java.util.Stack;

public class OperationPop implements Operation{
    @Override
    public void exec(Stack<Double> stack, String[] arguments, Map<String, Double> listOfDefinitions) throws OutOfSpaceException {
        if (stack.size() < 1) {
            throw new OutOfSpaceException(1);
        }
        stack.pop();
    }
}
