package leetcode

fun summaryRanges(nums: IntArray): List<String> {
    if(nums.isEmpty()){
        return listOf()
    }

    val list = mutableListOf<String>()

    var i = 0
    while(i < nums.size){
        val startDest = nums[i++]
        var k = 0

        while(i < nums.size && nums[i] - nums[i-1] == 1){
            i++
            k++
        }

        if(k != 0){
            list.add("$startDest->${nums[i-1]}")
        }
        else{
            list.add("$startDest")
        }
    }

    return list
}

fun main(){
//    val nums1 = intArrayOf(0,1,2,4,5,7)
    val nums1 = intArrayOf(0,2,3,4,6,8,9)
    val result = summaryRanges(nums1)

    result.forEach { println(it) }
}