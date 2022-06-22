import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Stack;

public class TestBase {

    HashMap<String, Double> definitionList;
    Stack<Double> stack;

    @BeforeMethod
    public void init() {
        definitionList = new HashMap<>();
        stack = new Stack<>();
        stack.push(20.);
        stack.push(4.);
    }

}
