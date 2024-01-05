package leetcode

// We can't solve this by Two Pointer.. sadly =(
private fun subarraySumTwoPointers(nums: IntArray, k: Int): Int {
    var count = 0
    var sum = 0

    var l = 0
    var r = 0
    while(r < nums.size || l < nums.size){
        if(l == r){
            if(nums[l] == k){
                count++
            }
            r++
            continue
        }
        if(sum <= k){
            if(r < nums.size) sum += nums[r]
            else break

            r++
        }
        else {
            if(l < nums.size) sum -= nums[l]
            else break

            l++
        }

        if(sum == k) {
            count++
        }
    }

    return count
}


// So solving this with hashmap and prefix sum
private fun subarraySum(nums: IntArray, k: Int): Int {
    var res = 0
    val map = mutableMapOf<Int, Int>()
    var sum = 0

    map[0] = 1

    for(i in nums.indices){
        sum += nums[i]
        res += map.getOrDefault(sum-k, 0)
        map[sum] = 1 + map.getOrDefault(sum, 0)
    }

    return res
}

fun main(){
//    val nums = intArrayOf(1,1,1)
    val nums = intArrayOf(1,2,3)
    val k = 3
    println(subarraySum(nums, k))
}
