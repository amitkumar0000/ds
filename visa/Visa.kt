package com.kotlin.visa

class Visa {
    companion object {

        var head:DenseLinkedList? = null
        @JvmStatic
        fun main(args:Array<String>){
            println("---- VISA Interview Question -----")

           /* println("S1. Get Max Interval ${getMaxIntervalPoint(arrayOf(1,2), arrayOf())}")
            println("S2. longest contnious Subarray   ${longestContinousSubarray(arrayOf(-2,-3,4,-1,-2,5,-3))}")
            println("S3. longest contnious Subarray   ${kadaneLogestSubarray(arrayOf(-2,-3,4,-1,-2,5,-3))}")
            println("S4. longest contnious Subarray   ${kadaneLogestSubarray(arrayOf(-2,-3,-4,-1,-2,-5,-3))}")
            println("S5. Element 29 is in Sorted Matrix ${isElementInSortedMatrix(50,arrayOf(
                arrayOf(10, 20, 30, 40),
                arrayOf(15, 25, 35, 45),
                arrayOf(27, 29, 37, 48),
                arrayOf(32, 33, 39, 50)
            ),4,4)}")*/

            flattenLinkedList()
        }

        fun getMaxIntervalPoint(arrival : Array<Int>, departure : Array<Int>): Int{
            var max = 0
            return max
        }

        /**
         * [isElementInSortedMatrix]
         *
         */
        fun isElementInSortedMatrix(ele:Int,matrix: Array<Array<Int>>,row:Int,col:Int):Boolean{
            var i = 0
            var j = 0
            for(ind in 1..row+col){
                if(matrix[i][j] == ele)
                    return true
                if(i+1<col && matrix[i][j+1]< ele)
                    i++
                else if(j+1<row)
                    j++
            }
            return false
        }

        /***
         * [longestContinousSubarray]
         * [print] largest continous subarray with start and end index
         */
        fun longestContinousSubarray(arr:Array<Int>): Int{
            var sum =0
            var max = 0
            var start = -1
            var end = -1
            var pos = 0
            arr.forEach {
                sum += it
                if(sum < 0) {
                    sum = 0
                    start = pos + 1
                }
                if(sum > max) {
                    max = sum
                    end = pos
                }
                pos++
            }
            println("---Start Index $start  End Index $end")
            return max
        }

        /**
         * [kadaneLogestSubarray]
         * this will handle the case when all number in array is -ve
         */
        fun kadaneLogestSubarray(arr: Array<Int>):Int{
            var cur_max = arr[0]
            var max_sofar = arr[0]
            var pos = 0
            arr.forEach {
                if(pos!= 0) {
                    cur_max = max(it, cur_max + it)
                    max_sofar = max(max_sofar, cur_max)
                }
                pos++
            }
            return max_sofar
        }

        /** [flattenLinkedList]
         *
         */
        fun flattenLinkedList(){
            createList()

        }

        fun createList(){
            add(DenseLinkedList(5,null,null))
            add(DenseLinkedList(10,null,null))
            add(DenseLinkedList(19,null,null))
            add(DenseLinkedList(28,null,null))

            add(DenseLinkedList(7,null,null),0,true)
            add(DenseLinkedList(8,null,null),0,true)
            add(DenseLinkedList(30,null,null),0,true)

            add(DenseLinkedList(20,null,null),1,true)

            add(DenseLinkedList(22,null,null),2,true)
            add(DenseLinkedList(55,null,null),2,true)

            add(DenseLinkedList(35,null,null),3,true)
            add(DenseLinkedList(40,null,null),3,true)
            add(DenseLinkedList(45,null,null),3,true)

            print("Done")

        }

        fun max(a: Int, b: Int) = if (a > b) a else b

        fun add( node:DenseLinkedList, pos:Int=-1, isDownNode:Boolean=false){
            if(head==null){
                head = node
            }else{
                var ptr = head
                if(isDownNode) {
                    var ps=pos
                    while (ps != 0) {
                        ptr = ptr?.next
                        ps = ps -1
                    }
                    while(ptr?.down!=null){
                        ptr=ptr?.down
                    }
                    ptr?.down=node
                }else{
                    while(ptr?.next!=null)
                        ptr = ptr?.next
                    ptr?.next = node
                }
            }
        }
    }
}

data class DenseLinkedList(val ele:Int, var next:DenseLinkedList?, var down:DenseLinkedList?)

