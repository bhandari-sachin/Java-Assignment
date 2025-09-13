# Simple Calculator Program

This program implements a simple Calculator class. It can add positive integers, reset to zero, and return the current sum. Adding a negative integer throws an exception.

## Code

```java
public class Calculator {
    // The Calculator class (Model)
    public static class CalculatorModel {
        private int total;
        public CalculatorModel() {
            total = 0;
        }
        public void reset() {
            total = 0;
        }
        // Adds positive integers, throws exception for negative integers
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
        CalculatorModel calculator = new CalculatorModel();
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
```

## How the CalculatorModel Class Works

1. The class has a private integer field `total` that keeps track of the current sum.
2. The constructor initializes `total` to zero.
3. The `reset` method sets `total` back to zero.
4. The `add` method takes an integer as input:
    - Throws an IllegalArgumentException if the integer is negative.
    - Adds the integer to `total` if it is positive.
5. The `getTotal` method returns the current value of `total`.

## My Experience with GitHub Copilot

Using GitHub Copilot was definitely worth it, and it seems to improve constantly.

It's great at generating boilerplate code and following existing patterns. It often predicts the code I was about to write, which speeds up development. Sometimes it feels almost spooky when it generates the code I was about to write.

A handy trick: adding a comment like:  
`// What does the above method do?` helps Copilot generate a concise inline explanation.  
                                     `// Adds positive integers, throws exception for negative integers` helps Copilot suggest the implementation.

**Benefits:**
- Saves time on repetitive coding tasks
- Keeps code style consistent with existing patterns
- Helps with inline explanations and documentation

**Drawbacks:**
- You still need to double-check everything; sometimes it suggests unnecessary or slightly off solutions
- Copilot works best when assisting you in implementing something you already understand, rather than figuring out the solution from scratch.

**Overall:** Copilot was extremely helpful for this small project. It sped up implementation while leaving me in control of design and correctness.