package com.kotlin.BackTracking

class StringPermutation {
    companion object {
        var word = "ABC"
        @JvmStatic
        fun main(args:Array<String>){
           var  wCA = word.toCharArray()
            var pStr = ""
            var ind = 0
            wCA.forEach {
                ch -> printPermutation( wCA, ind++,"$ch")
            }
        }

        private fun printPermutation( wCA: CharArray,ind:Int, pStr: String) {

            if(pStr.length == 3) {
                print("$pStr ")
                return
            }
            for(i in 0..2){
                if(i == ind)
                    continue
                else{
                    var nStr =  pStr+wCA[i]
                    printPermutation(wCA,i,nStr)
                    pStr.removeSuffix(""+wCA[i])
                }
            }
        }
    }
}