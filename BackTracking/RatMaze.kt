package com.kotlin.BackTracking

class RatMaze {
    companion object {

        val maze = arrayOf(
            arrayOf(1,0,0,0),
            arrayOf(1,1,0,1),
            arrayOf(0,1,0,0),
            arrayOf(0,1,1,1)
        )

        val visited = Array(4){BooleanArray(4) {false} }

        val path:List<String> = mutableListOf()

        val nr = arrayOf(0,0,1,-1)
        val nc = arrayOf(1,-1,0,0)

        val pathStringMap  = HashMap<Int,String>()

        private const val dr=3
        private const val dc=3

        @JvmStatic
        fun main(args:Array<String>){
            println("-- Rat Maze Problem --")

            pathStringMap[0] = "R"
            pathStringMap[1] = "L"
            pathStringMap[2] = "D"
            pathStringMap[3] = "U"

            visited[0][0]=true
            if(ratMazez(path, visited,0,0)) println("\nSolution Found") else println("No Solution exist")
        }

        private fun isSafe(r:Int,c:Int) = r>=0 && c>=0 && r<4 && c<4 && maze[r][c] == 1 && !visited[r][c]

        private fun ratMazez(
            path: List<String>,
            visited:Array<BooleanArray>,
            r:Int,
            c:Int
        ) :Boolean{
            if(r==dr && c==dc){
                path.forEach { print("$it ") }
                return true
            }else {
                for(ind in 0..3){
                    val mr = r + nr[ind]
                    val mc = c + nc[ind]
                    if(isSafe(mr,mc)){
                        val index = (path as MutableList<String>).lastIndex
                        pathStringMap[ind]?.let { path.add(it) }
                        visited[mr][mc] = true
                        if(ratMazez(path,visited,mr,mc)){
                            return true
                        }else{
                            pathStringMap[ind]?.let { path.removeAt(index) }
                            visited[mr][mc] = false
                        }
                    }
                }
            }
            return false
        }

        fun Array<BooleanArray>.print(){
            forEach {
                it.forEach {
                    print("$it ")
                }
                println()
            }
        }

    }
}