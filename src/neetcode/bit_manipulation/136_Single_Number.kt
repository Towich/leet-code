package neetcode.bit_manipulation

/*
        4   100
        1   001
        2   010
        1   001
        2   010
 */

fun singleNumber(nums: IntArray): Int {
    var result = 0

    for(num in nums){
        result = result xor num
    }

    return result
}

fun main(){
    val nums1 = intArrayOf(4,1,2,1,2)
    println(singleNumber(nums1))        // 4

}