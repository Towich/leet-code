package neetcode.binary_search

private fun search(nums: IntArray, target: Int): Int {
    var leftIndex = 0
    var rightIndex = nums.size-1

    while(rightIndex >= leftIndex){
        val middleIndex = (rightIndex + leftIndex)/2
        if(nums[middleIndex] == target)
            return middleIndex
        else if(nums[middleIndex] < target)
            leftIndex = middleIndex+1
        else
            rightIndex = middleIndex-1
    }

    return -1
}

fun main(){
    val nums = intArrayOf(-1,0,3,5,9,12)
    val nums2 = intArrayOf(-1,0,3,5,9,12)
    val nums3 = intArrayOf(5)
    val nums4 = intArrayOf(2,5)

    val target = 9
    val target2 = 2
    val target3 = 5
    val target4 = 0

    println(search(nums, target))   // 4
    println(search(nums2, target2)) // -1
    println(search(nums3, target3)) // 0
    println(search(nums4, target4)) // -1
}