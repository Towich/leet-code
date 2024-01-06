package leetcode

import kotlin.math.abs
import kotlin.math.min

fun isOneEditDistance(s: String, t: String): Boolean {
    var count = 0

    if(abs(s.length - t.length) > 1)
        return false

    var sP = 0
    var tP = 0

    while(sP < s.length && tP < t.length){
        if(s[sP] == t[tP]){
            sP++
            tP++
            continue
        }
        else{
            count++
            if(tP < t.length-1 && s[sP] == t[++tP]){
                sP++
                tP++
                continue
            }
            else if(sP < s.length-1 && t[tP] == s[++sP]){
                sP++
                tP++
                continue
            }
            else{
                return false
            }
        }
    }

    return count == 1
}

fun main(){
    val s = "aDb"
    val t = "adb"

    println(isOneEditDistance(s,t))     // true

    val s1 = "ab"
    val t1 = "ab"

    println(isOneEditDistance(s1,t1))   // false

    val s2 = "abB"
    val t2 = "abbB"

    println(isOneEditDistance(s2,t2))   // true

    val s3 = "abbB"
    val t3 = "abB"

    println(isOneEditDistance(s3,t3))   // true

    val s4 = "abbBB"
    val t4 = "abB"

    println(isOneEditDistance(s4,t4))   // false
}