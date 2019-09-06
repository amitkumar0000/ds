package com.kotlin.BackTracking

class WordBoggle {
    companion object {

        val dict = listOf("GEEKS", "for", "QUIZ", "GO", "UIKS", "EGZQ")
        val boogle = arrayOf(
            arrayOf('G', 'I', 'Z'),
            arrayOf('U', 'E', 'K'),
            arrayOf('Q', 'S', 'E')
        )


        val nr = arrayOf(1, 1, -1, 1, 0, 0, -1, -1)
        val nc = arrayOf(1, -1, 0, 0, -1, 1, -1, 1)

        fun isWordInDic(wordList: MutableList<Char>): Boolean {
            var word: String = String()
            wordList.forEach {
                word += it
            }
            return dict.contains(word)
        }

        fun isSafe(row: Int, col: Int, visited: Array<BooleanArray>) =
            row >= 0 && col >= 0 && row < 3 && col < 3 && !visited[row][col]

        @JvmStatic
        fun main(args: Array<String>) {
            println("--- Boggle Word Problem --")

            printWordInBoggle()
        }


        fun printWordInBoggle() {
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    val visited = Array(3) { BooleanArray(3) { false } }
                    visited[i][j] = true
                    val word = mutableListOf<Char>()
                    val move = 1
                    word.add(boogle[i][j])
                    printUtil1(boogle, visited, i, j, move, word)
                }
            }
        }

        private fun printUtil(
            boogle: Array<Array<Char>>,
            visited: Array<BooleanArray>,
            r: Int,
            c: Int,
            move: Int,
            word: MutableList<Char>
        ): Boolean {
            if (move == 3 * 3)
                return false
            else {
                for (index in 0..7) {
                    val mr = nr[index] + r
                    val mc = nc[index] + c
                    if (isSafe(mr, mc, visited)) {
                        visited[mr][mc] = true
                        word.add(boogle[mr][mc])
                        val lastIndx = word.lastIndex
                        if (word[0] == 'G' && word[1] == 'E') {
                            print("")
                        }
                        if (isWordInDic(word))
                            println("Word found $word")
                        if (printUtil(boogle, visited, mr, mc, move + 1, word = word))
                            return true
                        else {
                            visited[mr][mc] = false
                            word.removeAt(lastIndx)
                        }
                    }
                }
            }
            return false
        }

        private fun printUtil1(
            boogle: Array<Array<Char>>,
            visited: Array<BooleanArray>,
            r: Int,
            c: Int,
            move: Int,
            word: MutableList<Char>
        ) {

            if (word.size == 3 * 3)
                return
            for (index in 0..7) {
                val mr = nr[index] + r
                val mc = nc[index] + c
                if (isSafe(mr, mc, visited)) {
                    visited[mr][mc] = true
                    word.add(boogle[mr][mc])
                    val lastIndx = word.lastIndex
                    if (isWordInDic(word)) println("Word found $word")
                    printUtil1(boogle, visited, mr, mc, move + 1, word = word)
                    visited[mr][mc] = false
                    word.removeAt(lastIndx)
                }
            }
        }


    }
}