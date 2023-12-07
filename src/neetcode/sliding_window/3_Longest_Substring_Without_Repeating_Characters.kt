package neetcode.sliding_window

import kotlin.math.max

fun lengthOfLongestSubstring(s: String): Int {
    if(s.isEmpty())
        return 0
    else if(s.length == 1)
        return 1

    var left = 0
    var right = 1
    var longest = 1

    var map = mutableMapOf<Char, Int?>()
    map[s[left]] = left

    while(right < s.length){
        if(map[s[right]] == null){
            map[s[right]] = right
            longest = max(longest, right-left+1)
        }
        else{
            val buff = map[s[right]]!! + 1
            for(i in left..map[s[right]]!!){
                map[s[i]] = null
            }

            left = buff
            map[s[right]] = right
        }

        right++
    }

    return longest
}

fun main(){
    val s = "abcabcbb"
    println(lengthOfLongestSubstring(s))

    val s2 = "bbbbb"
    println(lengthOfLongestSubstring(s2))

    val s3 = "pwwkew"
    println(lengthOfLongestSubstring(s3))

    val s4 = "keygkegz"
    println(lengthOfLongestSubstring(s4))
}