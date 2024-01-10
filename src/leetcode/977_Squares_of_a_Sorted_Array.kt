package leetcode

import kotlin.math.abs

fun sortedSquares(nums: IntArray): IntArray {
    val resultList = mutableListOf<Int>()
    var minIndex = 0
    var minValue = nums[minIndex]

    for(i in 1 until nums.size){
        if(abs(nums[i]) < abs(minValue)){
            minValue = nums[i]
            minIndex = i
        }
    }

    var right = minIndex
    var left = minIndex-1

    while(right < nums.size || left >= 0){
        if(right < nums.size && left >= 0){
            if(abs(nums[right]) < abs(nums[left])){
                resultList.add(nums[right]*nums[right])
                right++
            }
            else{
                resultList.add(nums[left]*nums[left])
                left--
            }
        }
        else if(right < nums.size){
            resultList.add(nums[right]*nums[right])
            right++
        }
        else{
            resultList.add(nums[left]*nums[left])
            left--
        }
    }

    return resultList.toIntArray()
}

fun main(){
    val nums1 = intArrayOf(-4,-1,0,3,10)
    val nums2 = intArrayOf(-7,-3,2,3,11)

    sortedSquares(nums1).forEach { print("$it ") }
    println()

    sortedSquares(nums2).forEach { print("$it ") }
    println()
}