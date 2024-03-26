package Assignment;

	class FibonacciSeries {
	    private FibonacciFormatter formatter;

	    public FibonacciSeries(FibonacciFormatter formatter) {
	        this.formatter = formatter;
	    }

	    public void generate(int n) {
	        int a = 0, b = 1;
	        System.out.println("Fibonacci Series:");
	        for (int i = 0; i < n; i++) {
	            System.out.print(formatter.format(a) + " ");
	            int next = a + b;
	            a = b;
	            b = next;
	        }
	    }
}
