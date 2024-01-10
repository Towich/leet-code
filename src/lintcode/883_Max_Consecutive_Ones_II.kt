package lintcode

import neetcode.trees.TreeNode
import kotlin.math.max

fun findMaxConsecutiveOnes(nums: IntArray): Int{
    var f = 0
    var l = 0
    var maxCons = 0

    var localMax = 0
    var zero = -1
    while(l < nums.size){
        if(nums[l] != 1){
            if(zero == -1){
                zero = l
            }
            else{
                localMax -= (zero - f + 1)
                f = zero+1
                zero = l
            }
        }

        localMax++
        maxCons = max(maxCons, localMax)
        l++
    }

    return maxCons
}

fun main(){
    val nums = intArrayOf(1,0,1,1,0)
    println(findMaxConsecutiveOnes(nums))   // 4

    val nums2 = intArrayOf(1,0,1,0,1)
    println(findMaxConsecutiveOnes(nums2))  // 3

    val nums3 = intArrayOf(1,0)
    println(findMaxConsecutiveOnes(nums3))  // 2

    val nums4 = intArrayOf(0,1,0)
    println(findMaxConsecutiveOnes(nums4))  // 2

    val nums5 = intArrayOf(0,0,0,1)
    println(findMaxConsecutiveOnes(nums5))  // 2

    val nums6 = intArrayOf(0,1,1,1,1,0,0,1,1,1)
    println(findMaxConsecutiveOnes(nums6))  // 5

    val nums7 = intArrayOf(0,0,1,0,1,0)
    println(findMaxConsecutiveOnes(nums7))  // 3

    val nums8 = intArrayOf(1,1,1,1,0,0,0,1,0,1,0,0,1)
    println(findMaxConsecutiveOnes(nums8))  // 5

    val nums9 = intArrayOf(1,0,0,1,1,0,0,1,0,1,0,0,0,1,1,0)
    println(findMaxConsecutiveOnes(nums9))  // 3

    val nums10 = intArrayOf(0,0,0,1,1,0,0,0,1,1,1,0)
    println(findMaxConsecutiveOnes(nums10)) // 4
}

