package calculator;

import org.example.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("Starting Calculator tests");
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("Finished Calculator tests");
    }

    @Test
    @DisplayName("Addition should work correctly")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-10, calculator.add(-3, -7));
    }

    @Test
    @DisplayName("Subtraction should work correctly")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-8, calculator.subtract(2, 10));
        assertEquals(0, calculator.subtract(7, 7));
    }

    @Test
    @DisplayName("Multiplication should work correctly")
    void testMultiply() {
        assertEquals(15, calculator.multiply(3, 5));
        assertEquals(0, calculator.multiply(0, 10));
        assertEquals(-20, calculator.multiply(-4, 5));
    }

    @Test
    @DisplayName("Division should work correctly")
    void testDivide() {
        assertEquals(4, calculator.divide(12, 3));
        assertEquals(-2, calculator.divide(-10, 5));
        assertEquals(0, calculator.divide(0, 5));
    }

    @Test
    @DisplayName("Division by zero should throw IllegalArgumentException")
    void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(10, 0)
        );
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    // Part 4: Parameterized test for addition
    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "10, 20, 30",
            "7, 8, 15",
            "-5, 5, 0",
            "-10, -20, -30"
    })
    @DisplayName("Parameterized addition tests")
    void testAddParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }
}
