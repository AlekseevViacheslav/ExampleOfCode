package operations;

import exceptions.ArithmeticCalculatorException;
import exceptions.InputDataCalculatorException;
import exceptions.OutOfSpaceException;

import java.util.Map;
import java.util.Stack;

public class OperationDefine implements Operation {

    @Override
    public void exec(Stack<Double> stack, String[] arguments, Map<String, Double> listOfDefinitions) throws OutOfSpaceException, ArithmeticCalculatorException, InputDataCalculatorException {

        if (arguments.length  == 0 || arguments.length  % 2 == 1) {
            throw new InputDataCalculatorException("Неправильное количество аргументов");
        }

        int sizeOfPairsOfArguments = arguments.length / 2;

        for (int i = 0; i < sizeOfPairsOfArguments; i += 2) {

            String par1 = arguments[i];
            try {
                Double.parseDouble(par1);
                throw new InputDataCalculatorException("Неправильный первый параметр (не строка)");
            } catch (NumberFormatException ignored) {
            }

            String par2 = arguments[i+1];
            try {
                Double.parseDouble(par2);
            } catch (NumberFormatException e) {
                throw new InputDataCalculatorException("Неправильный второй параметр (не число)");
            }

            listOfDefinitions.put(arguments[i], Double.valueOf(arguments[i+1]));
        }
    }

}
