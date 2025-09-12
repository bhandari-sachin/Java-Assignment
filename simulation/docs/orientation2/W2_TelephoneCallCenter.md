# W – Three-Phase Simulation: Telephone Call Centre

**Objective:** Continue the hand simulation until the first customer of type Y exits the system.  

---

## **Simulation Steps**

| Clock | Phase | Router Queue | Router | Oper 1 Queue | Oper 1 | Oper 2 Queue | Oper 2 | Event List | Work Complete (X,Y) |
|-------|-------|--------------|--------|--------------|--------|--------------|--------|------------|-------------------|
| 0     | Init  | Empty        | Idle   | Empty        | Idle   | Empty        | Idle   | B1(5), B2(10) | X=0, Y=0 |
| 5     | A     | –            | –      | –            | –      | –            | –      | Clock moves to 5 | X=0, Y=0 |
| 5     | B     | X1           | Idle   | Empty        | Idle   | Empty        | Idle   | B1(10), B2(10) | X=0, Y=0 |
| 5     | C     | Empty        | X1     | Empty        | Idle   | Empty        | Idle   | B1(10), B2(10) | X=0, Y=0 |
| 6     | A     | –            | –      | –            | –      | –            | –      | Clock moves to 6 | X=0, Y=0 |
| 6     | B     | –            | –      | X1           | Idle   | –            | Idle   | B1(10), B2(10) | X=0, Y=0 |
| 6     | C     | –            | –      | Empty        | X1     | –            | Idle   | B1(10), B2(10) | X=0, Y=0 |
| 10    | A     | –            | –      | –            | –      | –            | –      | Clock moves to 10 | X=0, Y=0 |
| 10    | B     | X2, Y1       | –      | –            | X1     | –            | –      | B1(15), B2(20) | X=0, Y=0 |
| 10    | C     | X2           | Y1     | –            | X1     | –            | –      | B1(15), B2(20) | X=0, Y=0 |
| 15    | A     | –            | –      | –            | –      | –            | –      | Clock moves to 15 | X=0, Y=0 |
| 15    | B     | X3           | –      | –            | X2     | Y1           | –      | B4(16), B3(16), B5(18), B1(20), B2(20) | X=1, Y=0 |
| 15    | C     | –            | X3     | –            | X2     | –            | Y1     | B4(16), B3(16), B5(18), B1(20), B2(20) | X=1, Y=0 |
| 16    | A     | –            | –      | –            | –      | –            | –      | Clock moves to 16 | X=1, Y=0 |
| 16    | B     | –            | –      | X3           | Idle   | –            | Y1     | B3(16), B5(18), B1(20), B2(20) | X=1, Y=0 |
| 16    | C     | –            | –      | Empty        | X3     | –            | Y1     | B5(18), B1(20), B2(20) | X=1, Y=0 |
| 18    | A     | –            | –      | –            | –      | –            | –      | Clock moves to 18 | X=1, Y=0 |
| 18    | B     | –            | –      | –            | X3     | Y2           | Y1     | B1(20), B2(20) | X=1, Y=0 |
| 18    | C     | –            | X3     | –            | –      | Y2           | Y1     | B1(20), B2(20) | X=1, Y=0 |
| 20    | A     | –            | –      | –            | –      | –            | –      | Clock moves to 20 | X=1, Y=0 |
| 20    | B     | –            | –      | X4           | –      | Y3           | Y2     | – | X=1, Y=0 |
| 20    | C     | –            | X4     | –            | –      | Y3           | Y2     | – | X=1, Y=1 |

---

## **Explanation**

- **Clock 15–16:** X3 in router moves to operator 1, Y1 waits for operator 2.  
- **Clock 18:** Y2 arrives; router moves calls into service.  
- **Clock 20:** First Y customer (Y1) exits the system. **Work complete counter updated: Y=1**  
- Simulation stops here as required.  

---

**Result:**  

- **First Y call exits the system at clock = 20 minutes.**  
- **Final Work Complete:** X=1, Y=1  

