package org.example.strings;

public class StringUtils {

    public boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    public String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
}
