package leetcode

import kotlin.math.max


private fun merge(intervals: Array<IntArray>): Array<IntArray> {

    val sIntervals = intervals.sortedWith(compareBy { it.elementAt(0) })
    val resultArray = mutableListOf<IntArray>()
    resultArray.add(sIntervals[0])

    var r = 0
    for(i in sIntervals.indices){
        if(resultArray[r][1] >= sIntervals[i][0]){
            resultArray[r][1] = max(resultArray[r][1], sIntervals[i][1])
        }
        else
        {
            resultArray.add(sIntervals[i])
            r++
        }
    }

    return resultArray.toTypedArray()
}

fun main(){
    val intervals = arrayOf(intArrayOf(15,18), intArrayOf(8,10), intArrayOf(2,6), intArrayOf(1,3))
//    val intervals = arrayOf(intArrayOf(1,4), intArrayOf(1,5))

    val result = merge(intervals)

    result.forEach { array ->
        array.forEach { num ->
            print("$num ")
        }
        println()
    }
}