package com.kotlin.byteToByte._50InterviewQuestion


/***
 * [https://www.byte-by-byte.com/wp-content/uploads/2019/01/50-Coding-Interview-Questions.pdf]
 * @author Amit kumar
 * @version 1.0
 *
 */

class `50InterviewQuestion` {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("===== 50 Interview Question from https://www.byte-by-byte.com/wp-content/uploads/2019/01/50-Coding-Interview-Questions.pdf ====")

            //1. Median of Arrays
            findMedian1()

            findMedian2()

            //2. 0-1 Knapsack
            println("===== 50 Interview Question from https://www.byte-by-byte.com/wp-content/uploads/2019/01/50-Coding-Interview-Questions.pdf ====")

            //3. Matrix product

            //8. Merge K Arrays
//            merge()
        }

        /**
         * [findMedian1]
         * [TimeComplexity : O(m+n)]
         */
        private fun findMedian1() {
            val arr1 = arrayOf(1, 3, 5)
            val arr2 = arrayOf(2, 4, 6)
            println("medianSol1 = ${medianSol1(arr1, arr2)}")
            println("medianSol1 = ${medianSol1(arrayOf(1,3,5,7,8), arrayOf(2,4,6,9))}")
            println("medianSol1 = ${medianSol1(arrayOf(1,3,5,7,9,10,12), arrayOf(2,4,6,8,11,13,14))}")
            println("medianSol1 = ${medianSol1(arrayOf(1,3,8,9,15), arrayOf(7,11,18,19,21,25))}")
            println("medianSol1 = ${medianSol1(arrayOf(3,5,9,10,11,16), arrayOf(4,6,8,15))}")
            println("medianSol1 = ${medianSol1(arrayOf(1,3,5,7,9,10,12), arrayOf(2,4,6,8,11))}")
        }

        private fun medianSol1(a1: Array<Int>, a2: Array<Int>): Float {
            val resArray = mergeSort(a1, a2)
            val mid = resArray.size / 2
            return if (resArray.size % 2 == 0)
                (resArray[mid - 1] + resArray[mid]) / 2.0f
            else
                resArray[mid].toFloat()

        }

        private fun mergeSort(a1: Array<Int>, a2: Array<Int>): Array<Int> {
            var resA = Array(a1.size + a2.size) { 0 }
            var ind1 = 0
            var ind2 = 0
            var k = 0
            while (ind1 < a1.size && ind2 < a2.size) {
                if (a1[ind1] > a2[ind2])
                    resA[k++] = a2[ind2++]
                else
                    resA[k++] = a1[ind1++]
            }
            while (ind1 < a1.size)
                resA[k++] = a1[ind1++]
            while (ind2 < a2.size)
                resA[k++] = a2[ind2++]
            return resA
        }

        /**
         * [findMedian2]
         * [TimeComplexity : log(min(arr1.size,arr2.size))]
         */
        private fun findMedian2(){
            println("medianSol2 : ${medianSol2(arrayOf(3,5,9,10,11,16), arrayOf(4,6,8,15))}")
            println("medianSol2 = ${medianSol2(arrayOf(1,3,5,7,8), arrayOf(2,4,6,9))}")
            println("medianSol2 = ${medianSol2(arrayOf(1,3,5,7,9,10,12), arrayOf(2,4,6,8,11,13,14))}")
            println("medianSol2 = ${medianSol2(arrayOf(1,3,8,9,15), arrayOf(7,11,18,19,21,25))}")
            println("medianSol2 = ${medianSol2(arrayOf(3,5,9,10,11,16), arrayOf(4,6,8,15))}")
            println("medianSol2 = ${medianSol2(arrayOf(1,3,5,7,9,10,12), arrayOf(2,4,6,8,11))}")
        }

        private fun medianSol2(arr1: Array<Int>, arr2: Array<Int>): Float {
            var px:Int
            if(arr1.size > arr2.size){
                var e = arr2.size - 1
                var s = 0
                while(s<=e){
                    px = (s+e+1)/2
                    var py = ((arr1.size+arr2.size+1)/2) - px
                    if(arr2[px-1] < arr1[py] && arr2[px] > arr1[py-1]){
                        if((arr1.size+arr2.size)%2==0){
                            return average(max(arr2[px-1],arr1[py-1]),min(arr2[px],arr1[py]))
                        }else{
                            return max(arr2[px-1],arr1[py-1]).toFloat()
                        }
                    }else if(arr2[px-1] < arr1[py])
                        s = px +1
                    else
                        e = px -1
                }

            }else{
                var e = arr1.size - 1
                var s = 0
                while(s<=e){
                    px = (s+e+1)/2
                    var py = ((arr1.size+arr2.size+1)/2) - px
                    if(arr1[px-1] < arr2[py] && arr1[px] > arr2[py-1]){
                        if((arr1.size+arr2.size)%2==0){
                            return average(max(arr1[px-1],arr2[py-1]),min(arr1[px],arr2[py]))
                        }else{
                            return max(arr1[px-1],arr2[py-1]).toFloat()
                        }
                    }else if(arr1[px-1] < arr2[py])
                        s = px +1
                    else
                        e = px -1
                }
            }
            return -1.0f
        }

        fun max(a:Int, b:Int) = if(a>b) a else b
        fun min(a:Int, b:Int) = if(a>b) b else a
        fun average(a:Int, b:Int) = (a.toFloat()+b.toFloat())/2.0f


        private fun medianOfSortArray(a1: Array<Int>, a2: Array<Int>) {}


        private fun merge() {
            var aSet = mutableSetOf<Array<Int>>()
            aSet.add(arrayOf(1, 4, 7))
            aSet.add(arrayOf(2, 5, 8))
            aSet.add(arrayOf(3, 6, 9))
            aSet.add(arrayOf(31, 61, 91))
            aSet.add(arrayOf(13, 16, 19))
            aSet.add(arrayOf(12, 26, 29))
            aSet.add(arrayOf(0, 26, 39))

            if (aSet.size > 2) {

                var i = 0
                var res: Array<Int>?

                var l1 = aSet.elementAt(i)
                var l2 = aSet.elementAt(++i)

                res = mergetwoArray(l1, l2)

                while (++i < aSet.size)
                    res = mergetwoArray(res!!, aSet.elementAt(i))

                res?.forEach {
                    print("$it ")
                }
            }
        }

        private fun mergetwoArray(l1: Array<Int>, l2: Array<Int>): Array<Int> {
            var res = Array(l1.size + l2.size) { 0 }
            var ind1 = 0
            var ind2 = 0
            var k = 0
            while (ind1 < l1.size && ind2 < l2.size)
                if (l1[ind1] > l2[ind2]) res[k++] = l2[ind2++]
                else res[k++] = l1[ind1++]
            while (ind1 < l1.size) res[k++] = l1[ind1++]
            while (ind2 < l2.size) res[k++] = l2[ind2++]
            return res
        }
    }
}