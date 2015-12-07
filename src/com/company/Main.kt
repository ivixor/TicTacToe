package com.company

import java.util.*

fun main(args: Array<String>) {
    val n = 3
    var game = TicTacToe(n)
    game.printBoard()

    val scanner = Scanner(System.`in`)
    println("starting...")
    while(true) {
        println("current player is ${game.currentPlayer}")

        try {
            print("enter row number: ")

            var input = scanner.next()

            if (input.equals("\n")) {
                break
            }

            val i = input.toInt()
            print("enter column number: ")
            val j = scanner.next().toInt()

            if ((i >= 0 && i <= n) && (j >= 0 && j <= n)) {
                val win = game.play(i, j)
                if (win == WinCondition.WIN || win == WinCondition.TIE) {
                    break
                }
            } else {
                println("rows and cols value should be between: 0 and $n")
            }
        } catch(e: Exception) {
            println("input is invalid")
        }
    }

    println("exiting...")
}