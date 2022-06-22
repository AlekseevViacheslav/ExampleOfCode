import exceptions.InputDataCalculatorException;
import operations.Operation;

import java.io.FileNotFoundException;

public interface OperationFactory {
    Operation getOperationInstance(String operation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InputDataCalculatorException;
    void getResourceAsStream() throws FileNotFoundException;
}
