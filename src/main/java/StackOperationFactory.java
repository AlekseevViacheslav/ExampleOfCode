import exceptions.InputDataCalculatorException;
import operations.Operation;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class StackOperationFactory implements OperationFactory {

    private Map<String, String> operations = new HashMap<>();

    public StackOperationFactory() throws FileNotFoundException {
        getResourceAsStream();
    }

    public Operation getOperationInstance(String operation) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InputDataCalculatorException {
        if (operations.get(operation) == null) {
            throw new InputDataCalculatorException("Нет такой команды, все команды " + operations.keySet().toString());
        }
        Class classDefinition = Class.forName(operations.get(operation));
        return (Operation) classDefinition.newInstance();
    }

    public void getResourceAsStream() throws FileNotFoundException {
        List<String> commands = new BufferedReader(new FileReader(new File("src/main/java/operationsForFactory")))
                .lines().collect(Collectors.toList());
        for (String command: commands) {
            String[] pair = command.split("=");
            operations.put(pair[0], pair[1]);
        }
    }

}
