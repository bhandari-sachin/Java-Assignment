public class Calculator {

    // The Calculator class (Model)
    public static class calculator {
        private int total;

        public calculator() {
            total = 0;
        }

        public void reset() {
            total = 0;
        }

        // sum positive integers , throw exception for negative integers
        public void add(int number) {
            if (number < 0) {
                throw new IllegalArgumentException("Only positive integers are allowed.");
            }
            total += number;
        }

        public int getTotal() {
            return total;
        }
    }

    // Temporary main method to test Calculator
    public static void main(String[] args) {
        calculator calculator = new calculator();
        try {
            calculator.add(5);
            calculator.add(10);
            System.out.println("Total: " + calculator.getTotal()); // Output: Total: 15

            calculator.add(-3); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: Only positive integers are allowed.
        }
    }
}
