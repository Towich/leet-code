package neetcode

private fun mergeSortImpl(values: CharArray, buffer: CharArray, l: Int, r: Int) {
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
private fun mergeSort(values: CharArray) {
    if (values.isNotEmpty()) {
        val buffer = CharArray(values.size)
        mergeSortImpl(values, buffer, 0, values.size - 1)
    }
}

private fun isAnagram(s: String, t: String): Boolean {
    val sCharArray = s.toCharArray()
    val tCharArray = t.toCharArray()
    mergeSort(sCharArray)
    mergeSort(tCharArray)

    return sCharArray.contentEquals(tCharArray)
}

fun main(){
    println(isAnagram("anagram", "nagaram"))
    println(isAnagram("rat", "car"))
}

