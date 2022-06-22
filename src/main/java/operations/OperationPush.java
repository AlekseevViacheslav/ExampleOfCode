package operations;

import exceptions.InputDataCalculatorException;

import java.util.Map;
import java.util.Stack;

public class OperationPush implements Operation {

    @Override
    public void exec(Stack<Double> stack, String[] arguments, Map<String, Double> listOfDefinitions) throws InputDataCalculatorException {
        for (String argument: arguments) {
            if (listOfDefinitions.get(argument) != null) {
                stack.push(listOfDefinitions.get(argument));
            } else {
                try {
                    stack.push(Double.parseDouble(argument));
                } catch (NumberFormatException e) {
                    throw new InputDataCalculatorException("Неправильный параметр (не число)");
                }
            }
        }
    }
}
