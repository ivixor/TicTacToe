package com.company

class TicTacToe(n: Int) {
    var board = Array(n, { arrayOfNulls<String>(n) })
    var currentStep = 0
    val defaultValue = "_"
    var currentPlayer = "o"

    init {
        for (i in board.indices) {
            var row = board[i]
            for (j in row.indices) {
                board[i][j] = defaultValue
            }
            board.set(i, row)
        }
    }

    fun play(i: Int, j: Int) : Boolean {
        val cell = board[i][j]
        if (cell.equals(defaultValue)) {
            board[i][j] = currentPlayer
            var win = checkWin(i, j)
            currentStep++
            calcCurrentPlayer()
            printBoard()
            return win
        } else {
            println("This position is taken!")
            return false
        }
    }

    fun checkWin(i: Int, j: Int) : Boolean {


        return false
    }

    fun calcCurrentPlayer() {
        if (currentStep % 2 == 0) {
            currentPlayer = "0"
        } else {
            currentPlayer = "x"
        }
    }

    fun printBoard() {
        println("\n")
        for (i in board.indices) {
            for (j in board.indices) {
                print(board[i][j])
                print(" ")
            }
            println()
        }
        println("\n")
    }
}