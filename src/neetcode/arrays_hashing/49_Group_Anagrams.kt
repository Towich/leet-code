package neetcode.arrays_hashing

private fun mergeSort(values: CharArray) {
    if (values.isNotEmpty()) {
        val buffer = CharArray(values.size)
        mergeSortImpl(values, buffer, 0, values.size - 1)
    }
}
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

private fun groupAnagrams(strs: Array<String>): List<List<String>> {

    val resultLists: MutableList<MutableList<String>> = mutableListOf()
    val hashMap: HashMap<String, MutableList<String>> = HashMap()

    for(i in strs.indices){
        val sCharArray = strs[i].toCharArray()
        mergeSort(sCharArray)
        val convertedString = String(sCharArray)
        if(hashMap[convertedString] == null){
            hashMap[convertedString] = mutableListOf(strs[i])
        }
        else{
            hashMap[convertedString]?.add(strs[i])
        }
    }

    var i = 0
    for(map in hashMap){
        resultLists.add(mutableListOf())
        for(value in map.value){
            resultLists[i].add(value)
        }
        i++
    }

    return resultLists
}

fun main(){
    groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}
