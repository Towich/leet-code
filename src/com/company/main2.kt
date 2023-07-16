package com.company
fun blocks(blocks: Int): Int {
    var sum = 0
    var currLevel = 0

    while(true){
        sum += currLevel + 1

        if(sum <= blocks)
            currLevel++
        else
            break
    }

    return currLevel
}

fun blocks2(blocks: Int): Int {
    var n: Float = 0F
    var answer: Float = 0F

    while(true){
        val currSum = (2.0 + (n - 1))/2.0 * n
        if(currSum <= blocks){
            answer = n
        }
        else{
            break
        }

        n++
    }

    return answer.toInt()
}


fun main() {
    val blocksStr: String = readLine() ?: "0"
    val blocksInt: Int = blocksStr.toInt()

    val answer = blocks2(blocksInt)

    println(answer)
}