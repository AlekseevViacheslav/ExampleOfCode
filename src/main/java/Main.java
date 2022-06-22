import exceptions.ArithmeticCalculatorException;
import exceptions.InputDataCalculatorException;
import exceptions.OutOfSpaceException;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        StackOperationFactory stackOperationFactory = new StackOperationFactory();
        Calculator calculator = new Calculator(stackOperationFactory);

        try {
            calculator.exec(new File("src/main/resources/test.txt"));
        } catch (OutOfSpaceException | InputDataCalculatorException e) {
            e.printStackTrace();
        }

        try {
            calculator.exec();
        } catch (OutOfSpaceException | ArithmeticCalculatorException | InputDataCalculatorException e) {
            e.printStackTrace();
        }

    }

}
