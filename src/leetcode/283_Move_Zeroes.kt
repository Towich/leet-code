package leetcode

fun moveZeroes_1(nums: IntArray): Unit {
    val zeroes = IntArray(nums.size)

    for(i in nums.indices){
        if(nums[i] == 0){
            zeroes[i] = 1
        }
    }

    // zeroes = [1, 0, 1, 0, 0]

    for(i in nums.indices){
        if(nums[i] == 0) continue

        var offset = 0
        for(k in 0 until i){
            offset += zeroes[k]
        }

        nums[i-offset] = nums[i]

        if(offset != 0)
            nums[i] = 0
    }
}

fun moveZeroes(nums: IntArray) {
    var i = 0
    nums.asSequence().filter { it != 0 }.forEach { nums[i++] = it }
    nums.fill(0, i)
}

fun main(){
    val nums = intArrayOf(0,1,0,3,12)
    moveZeroes(nums)

    nums.forEach { print("$it ") }
}