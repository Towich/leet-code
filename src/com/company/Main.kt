package com.company

fun fib(n: Int): Int {
    val memo = mutableMapOf(1 to 1, 2 to 1)
    for(i in 3..n){
        memo[i] = memo[i-1]!! + memo[i-2]!!
    }
    return memo[n]!!
}

fun main(){
    println(fib(9))
}