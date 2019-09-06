package com.kotlin.sorting

class MergeSorting {
    companion object {
        var arr = arrayOf(10,5,20,2,1,17,190,20,30,10,18,11)
        @JvmStatic
        fun main(args:Array<String>){
            println("==== Merge Sort =====")
            mergeSort(arr,0,arr.size-1)
            arr.forEach {
                print("$it ")
            }
        }

        fun mergeSort(arr:Array<Int>,l:Int,r:Int){
            if(l>=r)
                return
            else{
                var m = (l+r)/2
                mergeSort(arr,l,m)
                mergeSort(arr,m+1,r)
                mergeArray(arr,l,m,r)
            }
        }

        fun mergeArray(arr:Array<Int>, l:Int,m:Int,r:Int){
            var res = Array(r-l+1){0}
            var ind1=l
            var ind2=m+1
            var k = 0
            while(ind1 <= m && ind2 <= r){
                if(arr[ind1] > arr[ind2])
                    res[k++] = arr[ind2++]
                else
                    res[k++] = arr[ind1++]
            }
            while(ind1 <= m)
                res[k++] = arr[ind1++]
            while (ind2 <= r)
                res[k++] = arr[ind2++]

            k=0
            for(i in l..r){
                arr[i] = res[k++]
            }
        }
    }
}