package leetcode

import kotlin.math.max
import kotlin.math.min

fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {

    var first = 0
    var second = 0

    val resultList = mutableListOf<IntArray>()

    while(first < firstList.size && second < secondList.size){
        val fInterval = firstList[first]
        val sInterval = secondList[second]

        if(sInterval[1] >= fInterval[1] && fInterval[1] >= sInterval[0] ||
            fInterval[1] >= sInterval[1] && sInterval[1] >= fInterval[0])
        {
            resultList.add(intArrayOf(max(fInterval[0], sInterval[0]), min(fInterval[1], sInterval[1])))
        }

        if(fInterval[1] >= sInterval[1])
            second++
        else
            first++

    }

    return resultList.toTypedArray()
}

fun main(){
//    val firstList = arrayOf(intArrayOf(0,2),intArrayOf(5,10),intArrayOf(13,23),intArrayOf(24,25))
//    val secondList = arrayOf(intArrayOf(1,5),intArrayOf(8,12),intArrayOf(15,24),intArrayOf(25,26))

    val firstList = arrayOf(intArrayOf(1,3),intArrayOf(5,9))
    val secondList = Array<IntArray>(0){ intArrayOf() }

    val resultList = intervalIntersection(firstList, secondList)
    resultList.forEach { println("${it[0]} ${it[1]}") }
}