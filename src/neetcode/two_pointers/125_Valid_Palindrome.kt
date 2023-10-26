package neetcode.two_pointers

import java.util.*

fun isPalindrome(s: String): Boolean {

    val re = Regex("[^A-Za-z0-9]")
    val regexString = re.replace(s, "").replace(" ", "").lowercase(Locale.getDefault())

    var leftPointer = 0
    var rightPointer = regexString.length-1

    for(i in regexString.indices){
        if(regexString[leftPointer] != regexString[rightPointer]){
            return false
        }

        leftPointer++
        rightPointer--
    }

    return true
}

fun main(){
    val s = "A man, a plan, a canal: Panama"
    println(isPalindrome(s))

    val s1 = "race a car"
    println(isPalindrome(s1))

    val s2 = " "
    println(isPalindrome(s2))
}