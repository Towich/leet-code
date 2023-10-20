package neetcode.stack

import java.util.*

fun dailyTemperatures_bad(temperatures: IntArray): IntArray {
    val answer = IntArray(temperatures.size)

    for(i in temperatures.indices){
        val currTemp = temperatures[i]

        var k = 1

        while(i+k < temperatures.size && temperatures[i+k] <= currTemp){
            k++
        }

        if(i+k >= temperatures.size){
            answer[i] = 0
        }
        else{
            answer[i] = k
        }

    }

    return answer
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = Stack<Int>()
    val res = IntArray(temperatures.size) { 0 }
    for (i in temperatures.lastIndex downTo 0) {
        while(stack.isNotEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop()
        if (stack.isNotEmpty()) {
            res[i] = stack.peek() - i
        }
        stack.push(i)
    }
    return res
}

fun main(){
    dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).let { for(elem in it) { print("$elem ") } }
    println()

    dailyTemperatures(intArrayOf(30,40,50,60)).let { for(elem in it) { print("$elem ") } }
    println()

    dailyTemperatures(intArrayOf(30,60,90)).let { for(elem in it) { print("$elem ") } }
    println()

    dailyTemperatures(intArrayOf(30)).let { for(elem in it) { print("$elem ") } }
    println()

    dailyTemperatures(intArrayOf(89,62,70,58,47,47,46,76,100,70)).let { for(elem in it) { print("$elem ") } }
    println()
}