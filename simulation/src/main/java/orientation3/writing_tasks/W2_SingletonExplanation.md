# W2: Why Singleton Objects Cannot Be Created with `new`

## Task Description
Explain why a Singleton object cannot be instantiated using `new` from outside the Singleton class.

## Explanation

1. **Private Constructor**
    - In a Singleton class, the constructor is declared `private`.
    - Example:
      ```java
      private Singleton() { }
      ```
    - This prevents external classes from calling `new Singleton()`.

2. **Controlled Instantiation**
    - The class provides a public static method (e.g., `getInstance()`) to return the single instance.
    - Example:
      ```java
      public static Singleton getInstance() {
          if(instance == null) instance = new Singleton();
          return instance;
      }
      ```

3. **Ensures Single Instance**
    - Only the class itself can create the object once.
    - External creation would violate the Singleton property.

## Summary
- Private constructor + static access method ensures exactly **one instance**.
- Any attempt to use `new` externally will result in a **compilation error**.

