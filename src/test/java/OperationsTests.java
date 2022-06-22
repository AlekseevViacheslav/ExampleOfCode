import exceptions.ArithmeticCalculatorException;
import exceptions.InputDataCalculatorException;
import exceptions.OutOfSpaceException;
import operations.OperationDefine;
import operations.OperationPop;
import operations.OperationPush;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OperationsTests extends TestBase {

    @Test
    public void operationPopTest() throws OutOfSpaceException {
        new OperationPop().exec(stack, null, definitionList);
        Assert.assertEquals(stack.size(), 1);
        Assert.assertEquals(stack.peek(), 20);

    }

    @Test
    public void operationPushTest() throws InputDataCalculatorException {
        new OperationPush().exec(stack, new String[]{"4", "3"}, definitionList);
        Assert.assertEquals(stack.size(), 4);
        Assert.assertEquals(stack.peek(), 3);
    }

    @Test
    public void operationDefineTest() throws ArithmeticCalculatorException, InputDataCalculatorException, OutOfSpaceException {
        new OperationDefine().exec(stack, new String[]{"b", "8"}, definitionList);
        Assert.assertEquals(definitionList.size(), 1);
        Assert.assertEquals(definitionList.get("b"), 8);
    }

    @Test
    public void operationPushWithDefinitionTest() throws ArithmeticCalculatorException, InputDataCalculatorException, OutOfSpaceException {
        new OperationDefine().exec(stack, new String[]{"b", "8"}, definitionList);
        new OperationPush().exec(stack, new String[]{"b"}, definitionList);
        Assert.assertEquals(stack.size(), 3);
        Assert.assertEquals(stack.peek(), 8);
    }

}
