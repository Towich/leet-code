package neetcode.dynamic_1d

/*
    It's.. Fibonacci...=)
 */

fun climbStairs_hashMap(n: Int): Int {
    val hashMap = mutableMapOf<Int, Int>()
    hashMap[0] = 0
    hashMap[1] = 1
    hashMap[2] = 2

    for(i in 3..n){
        hashMap[i] = hashMap[i-1]!! + hashMap[i-2]!!
    }

    return hashMap[n]!!
}

fun climbStairs(n: Int): Int {
    if(n <= 2)
        return n

    val array = IntArray(n+1)
    array[1] = 1
    array[2] = 2

    for(i in 3 .. n){
        array[i] = array[i-1] + array[i-2]
    }

    return array[n]
}

fun main(){
    println(climbStairs(2))     // 2
    println(climbStairs(3))     // 3
    println(climbStairs(4))     // 5
    println(climbStairs(5))     // 8
}