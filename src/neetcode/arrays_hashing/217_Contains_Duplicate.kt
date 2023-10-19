package neetcode.arrays_hashing

private fun mergeSortImpl(values: IntArray, buffer: IntArray, l: Int, r: Int) {
    if (l < r) {
        val m = (l + r) / 2
        mergeSortImpl(values, buffer, l, m)
        mergeSortImpl(values, buffer, m + 1, r)
        var k = l
        run {
            var i = l
            var j = m + 1
            while (i <= m || j <= r) {
                if (j > r || i <= m && values[i] < values[j]) {
                    buffer[k] = values[i]
                    ++i
                } else {
                    buffer[k] = values[j]
                    ++j
                }
                ++k
            }
        }
        for (i in l..r) {
            values[i] = buffer[i]
        }
    }
}
private fun mergeSort(values: IntArray) {
    if (values.isNotEmpty()) {
        val buffer = IntArray(values.size)
        mergeSortImpl(values, buffer, 0, values.size - 1)
    }
}

// Complexity = O(n*n/2)
fun containsDuplicate1(nums: IntArray): Boolean {
    for(i in 0 until nums.size - 1){
        for(k in i + 1 until nums.size){
            if(nums[i] == nums[k])
                return true
        }
    }
    return false
}

// Complexity = O(n*log n + n)
fun containsDuplicate2(nums: IntArray): Boolean {

    mergeSort(nums)

    for(i in 0..nums.size - 2){
        if(nums[i] == nums[i+1])
            return true
    }
    return false
}

fun main(){
    println(containsDuplicate2(nums = intArrayOf(1,2,3,1)))
    println(containsDuplicate2(nums = intArrayOf(1,2,3,4)))
    println(containsDuplicate2(nums = intArrayOf(1,1,1,3,3,4,3,2,4,2)))
}