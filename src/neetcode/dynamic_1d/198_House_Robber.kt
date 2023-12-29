package neetcode.dynamic_1d

import kotlin.math.max

private fun rob(nums: IntArray): Int {
    if(nums.size == 1){
        return nums[0]
    }
    else if(nums.size == 2){
        return max(nums[0], nums[1])
    }
    else if(nums.size == 3){
        return max(nums[1], nums[0] + nums[2])
    }

    nums[2] = nums[0] + nums[2]
    var maxMoney = max(nums[0], nums[2])

    for(i in 3 until nums.size){
        nums[i] = nums[i] + max(nums[i-3], nums[i-2])

        if(nums[i] > maxMoney)
            maxMoney = nums[i]
    }

    return maxMoney
}

fun main(){
    val nums = intArrayOf(1,2,3,1)
    println(rob(nums))  // 4

    val nums2 = intArrayOf(2,7,9,3,1)
    println(rob(nums2))  // 12
}