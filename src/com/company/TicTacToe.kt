package com.company

enum class WinCondition {
    WIN, CONTINUING, TIE
}

class TicTacToe(dimenstion: Int) {
    var dimension: Int
    var board = Array(dimenstion, { arrayOfNulls<String>(dimenstion) })
    var currentStep = 0
    val defaultValue = "_"
    var currentPlayer = "o"

    init {
        this.dimension = dimenstion

        for (i in board.indices) {
            var row = board[i]
            for (j in row.indices) {
                board[i][j] = defaultValue
            }
            board.set(i, row)
        }
    }

    fun play(i: Int, j: Int) : WinCondition {
        val cell = board[i][j]
        if (cell.equals(defaultValue)) {
            board[i][j] = currentPlayer
            currentStep++
            var winCondition = checkWin(i, j)
            calcCurrentPlayer()
            printBoard()
            return winCondition
        } else {
            println("This position is taken!")
            return WinCondition.CONTINUING
        }
    }

    fun checkWin(i: Int, j: Int) : WinCondition {
        println("current step is: $currentStep")
        if (currentStep < (dimension * dimension)) {
            if (checkRow(i) || checkColumn(j) || checkMainDiagonal() || checkReverseDiagonal()) {
                println("$currentPlayer player has won!")
                return WinCondition.WIN
            } else {
                return WinCondition.CONTINUING
            }
        } else {
            println("tie! everyone are losers!")
            return WinCondition.TIE
        }
    }

    fun checkRow(i: Int) : Boolean {
        var equals = true
        for (k in board.indices) {
            equals = equals && board[i][k].equals(currentPlayer)
        }

        return equals
    }

    fun checkColumn(j: Int) : Boolean {
        var equals = true
        for (k in board.indices) {
            equals = equals && board[k][j].equals(currentPlayer)
        }

        return equals
    }

    fun checkMainDiagonal() : Boolean {
        var equals = true
        for (k in board.indices) {
            for (l in board.indices) {
                if (k == l) {
                    equals = equals && board[k][l].equals(currentPlayer)
                }
            }
        }

        return equals
    }

    fun checkReverseDiagonal() : Boolean {
        var equals = true
        for (k in board.indices) {
            equals = equals && board[k][dimension - k - 1].equals(currentPlayer)
        }

        return equals
    }

    fun calcCurrentPlayer() {
        if (currentStep % 2 == 0) {
            currentPlayer = "o"
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