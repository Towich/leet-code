package neetcode.dynamic_1d

import kotlin.math.max

private fun rob(nums: IntArray): Int {
    if(nums.size == 1) return nums[0]
    return max(robFun(nums, 0, nums.size-2), robFun(nums, 1, nums.size-1))
}

private fun robFun(nums: IntArray, startInd: Int, endInd: Int): Int{
    var prev1 = 0
    var prev2 = 0

    for(i in startInd..endInd){
        val temp = prev1
        prev1 = max(prev1, prev2 + nums[i])
        prev2 = temp
    }

    return prev1
}

fun main(){
    val nums1 = intArrayOf(2,3,2)
    println(rob(nums1))             // 3

    val nums2 = intArrayOf(1,2,3,1)
    println(rob(nums2))             // 4

    val nums3 = intArrayOf(1,2,3)
    println(rob(nums3))             // 3

    val nums4 = intArrayOf(1,1,3,6,7,10,7,1,8,5,9,1,4,4,3)
    println(rob(nums4))               // 41

    val nums5 = intArrayOf(200,3,140,20,10)
    println(rob(nums5))               // 340

    val nums6 = intArrayOf(2,1,1,2)
    println(rob(nums6))               // 3
}