import exceptions.ArithmeticCalculatorException;
import exceptions.InputDataCalculatorException;
import exceptions.OutOfSpaceException;
import operations.Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

class Calculator {

    private final StackOperationFactory stackOperationFactory;
    private final Stack<Double> stack;
    private final Map<String, Double> listOfDefinitions;

    public Calculator(StackOperationFactory stackOperationFactory) {
        this.stackOperationFactory = stackOperationFactory;
        stack = new Stack<>();
        listOfDefinitions = new HashMap<>();
    }

    public void exec() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ArithmeticCalculatorException, InputDataCalculatorException, OutOfSpaceException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] lines = sc.nextLine().split(" ");
            String textOperation = lines[0];
            String[] textArguments = lines.length == 1 ? null : Arrays.copyOfRange(lines, 1, lines.length);
            Operation operation;
            try {
                operation = stackOperationFactory.getOperationInstance(textOperation);
            } catch (InputDataCalculatorException e) {
                e.printStackTrace();
                continue;
            }
            try {
                operation.exec(stack, textArguments, listOfDefinitions);
            } catch (OutOfSpaceException | ArithmeticCalculatorException | InputDataCalculatorException e) {
                e.printStackTrace();
            }
        }
    }

    public void exec(File file) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, OutOfSpaceException, InputDataCalculatorException {
        List<String> commands = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
        for (String command: commands) {
            String[] lines = command.split(" ");
            String textOperation = lines[0];
            String[] textArguments = lines.length == 1 ? null : Arrays.copyOfRange(lines, 1, lines.length);
            Operation operation = stackOperationFactory.getOperationInstance(textOperation);
            try {
                operation.exec(stack, textArguments, listOfDefinitions);
            } catch (OutOfSpaceException | ArithmeticCalculatorException | InputDataCalculatorException e) {
                e.printStackTrace();
            }
        }
    }

}
