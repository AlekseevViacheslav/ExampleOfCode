package operations;

import exceptions.ArithmeticCalculatorException;
import exceptions.InputDataCalculatorException;
import exceptions.OutOfSpaceException;

import java.util.Map;
import java.util.Stack;

public interface Operation {
    void exec(Stack<Double> stack, String[] arguments, Map<String, Double> listOfDefinitions) throws OutOfSpaceException, ArithmeticCalculatorException, InputDataCalculatorException;
}
