package neetcode.arrays_hashing

private fun mergeSort(values: Array<Pair<Int, Int>>) {
    if (values.isNotEmpty()) {
        val buffer = Array<Pair<Int, Int>>(values.size){ (0 to 0) }
        mergeSortImpl(values, buffer, 0, values.size - 1)
    }
}
private fun mergeSortImpl(values: Array<Pair<Int, Int>>, buffer: Array<Pair<Int, Int>>, l: Int, r: Int) {
    if (l < r) {
        val m = (l + r) / 2
        mergeSortImpl(values, buffer, l, m)
        mergeSortImpl(values, buffer, m + 1, r)
        var k = l
        run {
            var i = l
            var j = m + 1
            while (i <= m || j <= r) {
                if (j > r || i <= m && values[i].second < values[j].second) {
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

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val hashMap: HashMap<Int, Int> = HashMap()

    for(num in nums){
        hashMap[num] = hashMap[num]?.plus(1) ?: 1
    }

    val pairArray = hashMap.toList().toTypedArray()
    mergeSort(pairArray)

    val resultTop = IntArray(k)
    for(i in resultTop.indices){
        resultTop[i] = pairArray[pairArray.size-1 - i].first
    }

    return resultTop
}

fun main(){
    println(topKFrequent(intArrayOf(1,1,1,2,2,3,6,4,7,2,3,4,1,2), 2))
    println(topKFrequent(intArrayOf(1), 1))
}