package Assignment;
import java.util.Scanner;

// Interface for Fibonacci Series Formatter
interface FibonacciFormatter {
    String format(int number);
}
	// Formatter for Fibonacci Series in Numbers
	class NumberFormatter implements FibonacciFormatter {
	    @Override
	    public String format(int number) {
	        return String.valueOf(number);
	    }
	}

	// Formatter for Fibonacci Series in Words
	class WordFormatter implements FibonacciFormatter {
	    @Override
	    public String format(int number) {
	        if (number <= 1) {
	            return "One";
	        }
	        String[] words = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	        String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

	        StringBuilder result = new StringBuilder();
	        if (number >= 100) {
	            result.append(words[number / 100]).append(" Hundred ");
	            number %= 100;
	        }
	        if (number >= 20) {
	            result.append(tens[number / 10]).append(" ");
	            number %= 10;
	        }
	        if (number >= 11 && number <= 19) {
	            result.append(teens[number % 10]).append(" ");
	        } else if (number >= 1 && number <= 9) {
	            result.append(words[number]).append(" ");
	        }
	        return result.toString().trim();
	    }

}
