package com.kotlin.BackTracking

class NQueen {
    companion object {



        private const val row = 4
        private const val col = 4

        val chess = Array(row) { BooleanArray(col) { false } }
        val occupied = mutableListOf<Cell>()

        fun isSafe(r: Int, c: Int) = !isSameRow(r, c) && !isSameCol(r, c) && !isSameDiagonal(r, c)

        private fun isSameDiagonal(r: Int, c: Int): Boolean {
            var nr = r
            var nc = c
            while(nr >=0  && nc>=0){
                nr -= 1
                nc -= 1
                val cell = Cell(nr,nc)
                if(occupied.contains(cell))
                    return true

            }

            nr = r
            nc = c
            while(nr <row  && nc < col){
                nr += 1
                nc += 1
                val cell = Cell(nr,nc)
                if(occupied.contains(cell))
                    return true

            }

            nr =r
            nc = c
            while(nr>=0){
                nr -= 1
                nc += 1
                val cell = Cell(nr,nc)
                if(occupied.contains(cell))
                    return true
            }

            nr =r
            nc = c
            while(nr< row){
                nr += 1
                nc -= 1
                val cell = Cell(nr,nc)
                if(occupied.contains(cell))
                    return true
            }

            return false
        }

        private fun isSameCol(r: Int, c: Int): Boolean {
            for(i in 0 until r){
                val cell = Cell(i,c)
                if(occupied.contains(cell))
                    return true
            }

            for(i in r+1 until row){
                val cell = Cell(i,c)
                if(occupied.contains(cell))
                    return true
            }
            return false
        }

        private fun isSameRow(r: Int, c: Int): Boolean {

            for(i in 0 until c){
                val cell = Cell(i,c)
                if(occupied.contains(cell))
                    return true
            }

            for(i in c+1 until col){
                val cell = Cell(i,c)
                if(occupied.contains(cell))
                    return true
            }
            return false
        }


        @JvmStatic
        fun main(args: Array<String>) {
            println("---- N Queen Problem ----")

            for (ind in 0 until col) {
                occupied.add(Cell(0,ind))
                if(nQueen(chess, 0, ind, occupied))
                    break
                else
                    occupied.clear()
            }
        }

        private fun nQueen(chess: Array<BooleanArray>, r: Int, c: Int, occupied: MutableList<Cell>): Boolean {
            if (occupied.size == row) {
                occupied.print()
                return true
            } else {
                for (i in 0 until col) {
                    if(isSafe(r+1,i)){
                        occupied.add(Cell(r+1,i))
                        val lInd = occupied.lastIndex
                        if(nQueen(chess,r+1,i,occupied))
                            return true
                        occupied.removeAt(lInd)
                    }
                }
            }
            return false
        }

        private fun MutableList<Cell>.print() {
            this.forEach {
                print("[${it.row} ${it.col}] ")
            }
        }
    }
}

data class Cell(val row: Int, val col: Int)