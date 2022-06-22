package exceptions;

public class OutOfSpaceException extends CalculatorException {
    public OutOfSpaceException(int minSize) {
        super("В стеке меньше + " + minSize + " элементов для проведения операции");
    }
}
