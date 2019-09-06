package com.kotlin.BackTracking


class KnightTour {
    companion object {
        private const val row = 8
        private const val col = 8
        private val chess = Array(row) { IntArray(col) }
        private var sol: Array<IntArray> = Array(row) { IntArray(col) }
        private val vR = arrayOf( -1,  1,  2,2, 1, -1, -2, -2 )
        private val vC = arrayOf(-2, -2, -1, 1, 2,  2,  1, -1)

        @JvmStatic
        fun main(args: Array<String>) {
            println("Knight Tour Base Problem")


            for (i in 0 until row) {
                for (j in 0 until col) {
                    sol[i][j] = -1
                }
            }

            kTour()

        }

        private fun kTour() {
            sol[0][0] = 0
            if (kTourUtil(0, 0, 1, sol))
                print("Solution Exist ")
            else
                println("No solution Exist")
        }


        private fun isSafe(r: Int, c: Int) = r >= 0 && c >= 0 && r < row && c < col && sol[r][c] == -1



        private fun kTourUtil(r: Int, c: Int, move: Int, sol: Array<IntArray>): Boolean {
            if (move == row * col) {
                sol.print()
                return true
            } else {
                for (nI in 0 until row) {
                    var nr = r + vR[nI]
                    var nc = c + vC[nI]
                    if (isSafe(nr, nc)) {
                        sol[nr][nc] = move
                        if (kTourUtil(nr, nc, move + 1, sol))
                            return true
                        else
                            sol[nr][nc] = -1
                    }
                }
            }
            return false
        }

        private fun Array<IntArray>.print() {
            forEach {
                it.forEach { value ->
                    print("$value ")
                }
                println()
            }
        }
    }

}