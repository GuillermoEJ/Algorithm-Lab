# Educational Algorithms Laboratory

Repository with implementations of fundamental algorithms organized in three design paradigms.

---

## MODULE 1: Basic Sorting

**Concept:** Algorithms that reorder elements by applying comparisons and swaps.

**Algorithms:**
- Selection Sort - O(n²) always
- Insertion Sort - O(n²) average, O(n) best case
- Bubble Sort - O(n²) always
- Optimized Bubble Sort - O(n) best case with flag

**When to use:** To understand how basic algorithms work and learn about complexity.

```java
sortingExercises();
```

---

## MODULE 2: Divide and Conquer

**Concept:** Divides the problem into smaller subproblems, solves them recursively, and combines results.

**Algorithms:**
- Binary Search - O(log n)
- Quick Sort - O(n log n) average
- Maximum Subarray - O(n log n)
- Quick Select - O(n) average
- Plus 10+ additional problems

**When to use:** For problems that can be decomposed recursively.

```java
divideAndConquerExercises();
```

---

## MODULE 3: Backtracking

**Concept:** Explores all possible combinations recursively, pruning useless branches.

**Algorithms:**
- Subset Sum - Find subset with exact sum
- Knight's Tour - Complete tour on board without repetition
- N-Queens Problem - Place N queens without threatening each other
- Optimal Knapsack - Maximize value with weight limit
- Optimal Change - Minimum number of coins
- Exact Cost Path - Route with specific length
- Graph Coloring - Color vertices with minimum colors

**When to use:** For combinatorial problems and exhaustive search.

```java
subsetSumBack();        // Subsets
knightsTour();          // Knight
nQueens();              // N-Queens
optimalKnapsack();      // Knapsack
optimalCoins();         // Coins
exactCostPath();        // Path
colorGraph();           // Coloring
```

