package exceptions;

public class ArithmeticCalculatorException extends CalculatorException{
    public ArithmeticCalculatorException(String op, double num) {
        super("Не подходящий параметр " + num + " для операции " + op);
    }
}
