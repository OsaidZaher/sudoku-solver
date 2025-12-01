package ie.tudublin

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SudokuTest {

    @Test
    fun testSimplePuzzle() {
        println("Testing simple sudoku puzzle...")
        
        // Simple sudoku puzzle
        val board = arrayOf(
            intArrayOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )

        val sudoku = Sudoku(board)
        val solved = sudoku.solve()

        println("Puzzle solved: $solved")
        println("Iterations used: ${sudoku.iterations}")
        
        // Check that it solved s
        assertTrue(solved, "The puzzle should be solvable")
    }

    @Test
    fun testAnotherPuzzle() {
        println("Testing another sudoku puzzle...")
        
        val board = arrayOf(
            intArrayOf(0, 0, 0, 6, 0, 0, 4, 0, 0),
            intArrayOf(7, 0, 0, 0, 0, 3, 6, 0, 0),
            intArrayOf(0, 0, 0, 0, 9, 1, 0, 8, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 5, 0, 1, 8, 0, 0, 0, 3),
            intArrayOf(0, 0, 0, 3, 0, 6, 0, 4, 5),
            intArrayOf(0, 4, 0, 2, 0, 0, 0, 6, 0),
            intArrayOf(9, 0, 3, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 2, 0, 0, 0, 0, 1, 0, 0)
        )

        val sudoku = Sudoku(board)
        val solved = sudoku.solve()

        println("Puzzle solved: $solved")
        println("Iterations used: ${sudoku.iterations}")
        
        assertTrue(solved, "This puzzle should also be solvable")
    }

    @Test
    fun testUnsolvablePuzzle() {
        println("Testing unsolvable puzzle (invalid board)...")
        
        // Invalid puzzle
        val board = arrayOf(
            intArrayOf(5, 5, 0, 0, 7, 0, 0, 0, 0),
            intArrayOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
            intArrayOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
            intArrayOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
            intArrayOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
            intArrayOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
            intArrayOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
            intArrayOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
            intArrayOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
        )

        val sudoku = Sudoku(board)
        val solved = sudoku.solve()

        println("Puzzle solved: $solved")
        println("Iterations used: ${sudoku.iterations}")
        
        assertFalse(solved, "Invalid puzzle should NOT be solvable")
    }
}