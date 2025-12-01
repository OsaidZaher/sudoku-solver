package ie.tudublin

class Sudoku(private val board: Array<IntArray>) {
    var iterations = 0
        private set
    private val maxIterations = 2_000_000

    fun solve(): Boolean {
        iterations = 0
        return placeNumber(0, 0)
    }

    private fun placeNumber(row: Int, col: Int): Boolean {
        iterations++
        
        if (iterations > maxIterations) {
            return false
        }

        var nextRow = row
        var nextCol = col
        
        while (nextRow < 9 && board[nextRow][nextCol] != 0) {
            nextCol++
            if (nextCol == 9) {
                nextCol = 0
                nextRow++
            }
        }

        if (nextRow == 9) return true

        for (num in 1..9) {
            if (isValid(nextRow, nextCol, num)) {
                board[nextRow][nextCol] = num
                if (placeNumber(nextRow, nextCol)) return true
                board[nextRow][nextCol] = 0
            }
        }

        return false
    }

    private fun isValid(row: Int, col: Int, num: Int): Boolean {
        for (c in 0..8) {
            if (board[row][c] == num) return false
        }

        for (r in 0..8) {
            if (board[r][col] == num) return false
        }

        val boxRow = (row / 3) * 3
        val boxCol = (col / 3) * 3
        for (r in boxRow until boxRow + 3) {
            for (c in boxCol until boxCol + 3) {
                if (board[r][c] == num) return false
            }
        }

        return true
    }

    fun getBoard(): Array<IntArray> = board
}