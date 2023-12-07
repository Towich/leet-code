package neetcode.sliding_window

import java.lang.Integer.max
import kotlin.math.max

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = 0.0

    for(i in 0 until k){
        sum += nums[i]
    }

    var maxAverage = sum / k.toDouble()

    for(j in k until nums.size){
        sum += nums[j]
        sum -= nums[j-k]

        maxAverage = max(maxAverage, sum / k.toDouble())
    }

    return maxAverage
}

fun main(){
    val nums = intArrayOf(1,12,-5,-6,50,3)
    val k = 4
    println(findMaxAverage(nums, k))
}