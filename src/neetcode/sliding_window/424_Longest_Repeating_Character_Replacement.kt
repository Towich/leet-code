package neetcode.sliding_window

import kotlin.math.max

fun characterReplacement(s: String, k: Int): Int {
    var mostFrequentCharCount = 0
    var start = 0
    var max = 0
    val map = mutableMapOf<Char, Int>()

    for(end in s.indices){
        map[s[end]] = map.getOrDefault(s[end], 0) + 1
        mostFrequentCharCount = max(map[s[end]]!!, mostFrequentCharCount)

        if(end - start + 1 - mostFrequentCharCount > k){
            map[s[start]] = map[s[start]]!! - 1
            start++
        }

        max = Math.max(max, end - start + 1)
    }

    return max
}

fun main(){
    val s1 = "ABAB"
    val k1 = 2
    println(characterReplacement(s1, k1))   // 4

    val s2 = "AABABBA"
    val k2 = 1
    println(characterReplacement(s2, k2))   // 4

    val s3 = "ABBB"
    val k3 = 2
    println(characterReplacement(s3, k3))   // 4
}