import exceptions.ArithmeticCalculatorException;
import exceptions.OutOfSpaceException;
import operations.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationTests extends TestBase {

    @Test
    public void arithmeticOperationDivisionTest() throws ArithmeticCalculatorException, OutOfSpaceException {
        new OperationDivision().exec(stack, null, null);
        Assert.assertEquals(stack.size(), 1);
        Assert.assertEquals(stack.peek(), 0.2);
    }

    @Test
    public void arithmeticOperationMinusTest() throws ArithmeticCalculatorException, OutOfSpaceException {
        new OperationMinus().exec(stack, null, null);
        Assert.assertEquals(stack.size(), 1);
        Assert.assertEquals(stack.peek(), -16.0);
    }

    @Test
    public void arithmeticOperationMultiplyTest() throws ArithmeticCalculatorException, OutOfSpaceException {
        new OperationMultiply().exec(stack, null, null);
        Assert.assertEquals(stack.size(), 1);
        Assert.assertEquals(stack.peek(), 80);
    }

    @Test
    public void arithmeticOperationPlusTest() throws ArithmeticCalculatorException, OutOfSpaceException {
        new OperationPlus().exec(stack, null, null);
        Assert.assertEquals(stack.size(), 1);
        Assert.assertEquals(stack.peek(), 24);
    }

    @Test
    public void arithmeticOperationSqrtTest() throws ArithmeticCalculatorException, OutOfSpaceException {
        new OperationSqrt().exec(stack, null, null);
        Assert.assertEquals(stack.size(), 2);
        Assert.assertEquals(stack.peek(), 2);
    }

}
