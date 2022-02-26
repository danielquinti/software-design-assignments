package exercise2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivan
 */
public class ExpressionTest {

    @Test
    public void testEvaluateSimpleSum() {
        System.out.println("evaluateExpression");
        Sum input = new Sum(new Number(1), new Number(2));
        double expResult = 3.0;
        double result = input.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSimpleSumPolishNotation() {
        System.out.println("evaluateExpression");
        Sum input = new Sum(new Number(1), new Number(2));
        String expResult = "1 2 +";
        String result = input.represent();
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluateSimpleSub() {
        System.out.println("evaluateExpression");
        Subtraction input = new Subtraction(new Number(1), new Number(2));
        double expResult = -1.0;
        double result = input.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSimpleSubPolishNotation() {
        System.out.println("evaluateExpression");
        Subtraction input = new Subtraction(new Number(1), new Number(2));
        String expResult = "1 2 -";
        String result = input.represent();
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluateSumSqrt() {
        System.out.println("evaluateExpression");
        Sum input = new Sum(new Number(1), new SquareRoot(new Number(2)));
        double expResult = 1 + Math.sqrt(2);
        double result = input.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testEvaluateSubSignChange() {
        System.out.println("evaluateExpression");
        Subtraction input = new Subtraction(new Number(1), new SignChange(new Number(2)));
        double expResult = 3;
        double result = input.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testNotationSubSignChange() {
        System.out.println("evaluateExpression");
        Subtraction input = new Subtraction(new Number(1), new SignChange(new Number(2)));
        String result = "1 2 +/- -";
        String expResult = input.represent();
        assertEquals(expResult, result);
    }

    @Test
    public void testSumPolishNotation() {
        System.out.println("evaluateExpression");
        Sum input = new Sum(new Number(1), new SquareRoot(new Number(2)));
        String expResult = "1 2 √ +";
        String result = input.represent();
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluateMultiplication() {
        System.out.println("evaluateExpression");
        Multiplication input = new Multiplication(new Number(1), new SquareRoot(new Number(2)));
        double expResult = 1 * Math.sqrt(2);
        double result = input.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testMultiplicationPolishNotation() {
        System.out.println("evaluateExpression");
        Multiplication input = new Multiplication(new Number(1), new SquareRoot(new Number(2)));
        String expResult = "1 2 √ ×";
        String result = input.represent();
        assertEquals(expResult, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        System.out.println("evaluateExpression");
        Division input = new Division(new Number(1), new Number(0));
        input.evaluate();

    }
    
    @Test(expected = ArithmeticException.class)
    public void testNegativeSQRT() {
        System.out.println("evaluateExpression");
        SquareRoot input = new SquareRoot(new Number(-2));
        input.evaluate();
    }

    @Test
    public void testEvaluateDivision() {
        System.out.println("evaluateExpression");
        Division input = new Division(new Number(1), new SquareRoot(new Number(2)));
        double expResult = 1 / Math.sqrt(2);
        double result = input.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testDivisionPolishNotation() {
        System.out.println("evaluateExpression");
        Division input = new Division(new Number(1), new SquareRoot(new Number(2)));
        String expResult = "1 2 √ ÷";
        String result = input.represent();
        assertEquals(expResult, result);
    }

    @Test
    public void testEvaluate() {
        System.out.println("evaluateExpression");
        Sum input = new Sum(new Number(2), new Multiplication(new Number(5), new SquareRoot(new Number(9))));
        double expResult = 17;
        double result = input.evaluate();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPolishNotation() {
        System.out.println("evaluateExpression");
        Sum input = new Sum(new Number(2), new Multiplication(new Number(5), new SquareRoot(new Number(9))));
        String expResult = "2 5 9 √ × +";
        String result = input.represent();
        assertEquals(expResult, result);
    }
}
