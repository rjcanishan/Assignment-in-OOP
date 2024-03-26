package Assignment;
import java.util.Scanner;

	// Main class to handle user interaction
	public class Main {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the number of Fibonacci elements to generate: ");
	        int count = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        System.out.println("Choose output format:");
	        System.out.println("1. Numbers");
	        System.out.println("2. Words");
	        System.out.print("Enter your choice: ");
	        int choice = scanner.nextInt();

	        FibonacciFormatter formatter;
	        if (choice == 1) {
	            formatter = new NumberFormatter();
	        } else if (choice == 2) {
	            formatter = new WordFormatter();
	        } else {
	            System.out.println("Invalid choice. Defaulting to numbers format.");
	            formatter = new NumberFormatter();
	        }

	        FibonacciSeries series = new FibonacciSeries(formatter);
	        series.generate(count);
	    }
}
