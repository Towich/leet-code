package neetcode.binary_search

private fun search(nums: IntArray, target: Int): Int {
    var lo = 0
    var hi = nums.size - 1

    while (lo < hi) {
        val mid = (hi + lo) / 2

        if(nums[mid] == target)
            return mid
        else if(nums[lo] == target)
            return lo
        else if(nums[hi] == target)
            return hi

        if(nums[lo] < nums[mid]){
            if(nums[lo] <= target && target <= nums[mid]){
                hi = mid
            }
            else{
                lo = mid + 1
            }
        }
        else{
            if(nums[mid] <= target && target <= nums[hi]){
                lo = mid + 1
            }
            else{
                hi = mid
            }
        }
    }

    return when(target){
        nums[lo] -> lo
        nums[hi] -> hi
        else -> -1
    }
}

fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0

    println(search(nums, target))           // 4

    val nums2 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target2 = 3

    println(search(nums2, target2))         // -1

    val nums3 = intArrayOf(1)
    val target3 = 0

    println(search(nums3, target3))         // -1

    val nums4 = intArrayOf(3, 1)
    val target4 = 1

    println(search(nums4, target4))         // 1

    val nums5 = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target5 = 5

    println(search(nums5, target5))         // 1

    val nums6 = intArrayOf(5, 1, 3)
    val target6 = 1

    println(search(nums6, target6))         // 1

    val nums7 = intArrayOf(4,5,6,7,8,1,2,3)
    val target7 = 8

    println(search(nums7, target7))         // 4
}