package leetcode

import java.lang.Integer.max

// Not so fast: 610ms/51mb
fun longestSubarrayOld(nums: IntArray): Int {
    var first = 0
    var last: Int
    var maxLength = 0
    var zeroIndex: Int

    while(first < nums.size) {
        last = first
        zeroIndex = -1

        while(last < nums.size) {
            if(nums[last] == 1) {
                last++
                continue
            } else if (zeroIndex == -1) {
                zeroIndex = last
                last++
            } else {
                break
            }
        }

        if(last - first - 1 > maxLength) maxLength = last - first - 1

        first = if (zeroIndex != -1) zeroIndex + 1 else first + 1
    }

    return maxLength
}

fun main() {
    val nums1 = intArrayOf(1, 1, 0, 1)
    println(longestSubarrayOld(nums1))     // 3

    val nums2 = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)
    println(longestSubarrayOld(nums2))     // 5

    val nums3 = intArrayOf(1, 1, 1)
    println(longestSubarrayOld(nums3))     // 2

    val nums4 = intArrayOf(1, 1, 0, 0, 1, 1, 1)
    println(longestSubarrayOld(nums4))     // 3

    val nums5 = intArrayOf(0, 0, 0, 1, 1, 0, 0)
    println(longestSubarrayOld(nums5))     // 2

    val nums6 = intArrayOf(1,0,0,0,0)
    println(longestSubarrayOld(nums6))     // 1
}