package neetcode.binary_search

fun findMin(nums: IntArray): Int {
    var lo = 0
    var hi = nums.size-1

    while(lo < hi){
        if(nums[lo] < nums[hi])
            return nums[lo]

        val mid = (lo+hi)/2

        if(nums[lo] > nums[mid]) hi = mid
        else lo = mid+1
    }

    return nums[lo]
}

fun main(){
    val nums = intArrayOf(3,4,5,1,2)
    println(findMin(nums))

    val nums2 = intArrayOf(4,5,6,7,0,1,2)
    println(findMin(nums2))

    val nums3 = intArrayOf(11,13,15,17)
    println(findMin(nums3))

    val nums4 = intArrayOf(3,1,2)
    println(findMin(nums4))
}