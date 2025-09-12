# W1: Age Distribution Algorithm

## Task Description
Draw 1000 age values distributed according to the age distribution of the students in the group. Explain the algorithm so it can be programmed directly.

## Algorithm

1. **Input**
    - `ages`: List of distinct ages of students, e.g., [18, 19, 20, 21, 22]
    - `frequencies`: Corresponding number of students for each age, e.g., [2, 5, 10, 15, 20]

2. **Calculate cumulative distribution**
    - Sum the frequencies to get the total number of students.
    - Compute cumulative probabilities:
      ```
      cumulative[i] = sum(frequencies[0..i])
      ```

3. **Random selection**
    - For each of the 1000 values:  
      a. Generate a random integer `r` between 0 and total-1.  
      b. Find the first age `ages[i]` where `r < cumulative[i]`.  
      c. Assign `ages[i]` as the generated age.

4. **Output**
    - An array/list of 1000 ages following the group’s distribution.

## Notes
- This is equivalent to **inverse transform sampling** using a discrete distribution.
- Randomness ensures variability in generated samples.

