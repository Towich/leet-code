package com.company

import java.util.*
import kotlin.random.Random
import kotlin.test.assertEquals

/*
    n -----> 6
    days --> 10 3 5 3 11 9
                b     s
    answer >    2     5

    4
    2 [4 1 2]


 */

fun buySell(array: MutableList<Int>): String{
    var maxDelta = 0

    var rightArray = array.toList()
    var currIndex = 0

    var buyDay = 0
    var buySum = 0
    var sellDay = 0

    for(currNum in array){
        rightArray = rightArray.drop(1)

        if(buyDay != 0 && currNum > buySum || currNum > 1000) {
            currIndex++
            continue
        }


        val rightMax = rightArray.maxOrNull() ?: break
        val delta = rightMax - currNum

        if(delta > maxDelta) {
            maxDelta = delta
            buyDay = currIndex + 1
            buySum = currNum

            for(i in array.indices){
                if(array[i] == rightMax && i+1 > buyDay){
                    sellDay = i + 1
                    break
                }
            }
        }

        currIndex++
    }

    println("maxDelta = $maxDelta")
    return "$buyDay $sellDay"
}

fun test(){
    val array = mutableListOf<Int>()
    val n = 10

    for(i in 1..n) array.add(Random.nextInt(1, 1500))

//    println("done")
    println(array)
    println(buySell(array))
}

fun main(){
//    val n = readLine()!!.toInt()
//    val array = mutableListOf<Int>()
//    val input = Scanner(System.`in`)
//
//
//    for(i in 1..n) array.add(input.nextInt())
//
//    println(buySell(array))
//    assertEquals("2 5", buySell(mutableListOf(10, 3, 5, 3, 11, 9)))
//    assertEquals("0 0", buySell(mutableListOf(5, 5, 5, 5)))
//    assertEquals("0 0", buySell(mutableListOf()))
//    assertEquals("1 4", buySell(mutableListOf(1, 3, 4, 10, 5, 1, 2)))
//    assertEquals("3 4", buySell(mutableListOf(100, 50, 30, 70)))
//    assertEquals("0 0", buySell(mutableListOf(100, 50, 30, 20)))
//    assertEquals("0 0", buySell(mutableListOf(10)))
//    assertEquals("0 0", buySell(mutableListOf(1001, 4000, 5)))
//    assertEquals("1 2", buySell(mutableListOf(1000, 4000, 5)))
//    assertEquals("1 4", buySell(mutableListOf(1, 3, 5, 7)))
//    assertEquals("1 2", buySell(mutableListOf(1, 3, 2, 3)))
//    assertEquals("3 4", buySell(mutableListOf(99, 10, 5, 100, 99)))
//    assertEquals("0 0", buySell(mutableListOf(10, 10)))
//    assertEquals("1 3", buySell(mutableListOf(10, 10, 11)))
//    assertEquals("3 7", buySell(mutableListOf(3, 5, 1, 7, 6, 8, 10, 1, 2, 4)))
//    assertEquals("4 6", buySell(mutableListOf(3, 4, 3, 1, 3, 4, 1, 2, 4, 3)))
//    assertEquals("1 4", buySell(mutableListOf(1, 2, 1, 3, 1, 2, 1, 1, 3, 3)))
//    assertEquals("1 4", buySell(mutableListOf(1, 1, 1, 2)))
//    assertEquals("2 3", buySell(mutableListOf(100, 99, 100, 99)))
//    assertEquals("0 0", buySell(mutableListOf(1444, 2670, 3616, 2766, 4372, 1789)))

    test()
}