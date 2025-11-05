package string;

import org.example.strings.StringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @ParameterizedTest
    @CsvSource({
            "madam, true",
            "racecar, true",
            "hello, false",
            "A man a plan a canal Panama, true",
            "race a car, false",
            "'', true",
            "a, true"
    })
    @DisplayName("Palindrome tests with various inputs")
    void testIsPalindrome(String input, boolean expected) {
        assertEquals(expected, stringUtils.isPalindrome(input));
    }

    @Test
    @DisplayName("Palindrome should return false for null")
    void testIsPalindromeNull() {
        assertFalse(stringUtils.isPalindrome(null));
    }

    @Test
    @DisplayName("Reverse should work correctly")
    void testReverse() {
        assertEquals("olleh", stringUtils.reverse("hello"));
        assertEquals("", stringUtils.reverse(""));
        assertEquals("a", stringUtils.reverse("a"));
        assertEquals("54321", stringUtils.reverse("12345"));
    }

    @Test
    @DisplayName("Reverse should return null for null input")
    void testReverseNull() {
        assertNull(stringUtils.reverse(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n", "  \t  \n  "})
    @DisplayName("IsBlank should return true for whitespace strings")
    void testIsBlankWhitespace(String input) {
        assertTrue(stringUtils.isBlank(input));
    }

    @Test
    @DisplayName("IsBlank should return true for null")
    void testIsBlankNull() {
        assertTrue(stringUtils.isBlank(null));
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "a", "test string", "  text  "})
    @DisplayName("IsBlank should return false for non-blank strings")
    void testIsBlankNonEmpty(String input) {
        assertFalse(stringUtils.isBlank(input));
    }
}
