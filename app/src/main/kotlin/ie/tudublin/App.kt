package ie.tudublin

import java.io.File

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Usage: sudoku <input-file>")
        println("Input file should contain 9 lines with 9 digits each (0 for empty cells)")
        return
    }

    val filename = args[0]
    
    val board = try {
        readBoardFromFile(filename)
    } catch (e: Exception) {
        println("Error reading file: ${e.message}")
        return
    }

    println("Input Board:")
    printBoard(board)
    println()

    val sudoku = Sudoku(board)
    val solved = sudoku.solve()

    if (solved) {
        println("Solution:")
        printBoard(sudoku.getBoard())
    } else {
        println("Could not find a solution (tried ${sudoku.iterations} iterations)")
    }
}

fun readBoardFromFile(filename: String): Array<IntArray> {
    val lines = File(filename).readLines()
    
    if (lines.size != 9) {
        throw IllegalArgumentException("File must contain exactly 9 lines")
    }

    return lines.map { line ->
        val cleanLine = line.replace(" ", "").trim()
        if (cleanLine.length != 9) {
            throw IllegalArgumentException("Each line must contain exactly 9 digits")
        }
        cleanLine.map { it.toString().toInt() }.toIntArray()
    }.toTypedArray()
}

fun printBoard(board: Array<IntArray>) {
    for (i in board.indices) {
        if (i % 3 == 0 && i != 0) {
            println("------+-------+------")
        }
        for (j in board[i].indices) {
            if (j % 3 == 0 && j != 0) {
                print("| ")
            }
            print("${board[i][j]} ")
        }
        println()
    }
}