package neetcode.arrays_hashing

fun countCharacters(words: Array<String>, chars: String): Int {
    val hashMap = HashMap<Char, Int>()
    var resultSum = 0

    for(i in chars.indices){
        hashMap[chars[i]] = if(hashMap[chars[i]] != null) hashMap[chars[i]]!! + 1 else 1
    }

    for(word in words){
        var isAddToSum = true
        val wordHashMap = HashMap<Char, Int>()

        for(char in word){
            wordHashMap[char] = if(wordHashMap[char] != null) wordHashMap[char]!! + 1 else 1
        }

        for(k in wordHashMap.keys){
            if(hashMap[k] == null || hashMap[k]!! < wordHashMap[k]!!){
                isAddToSum = false
            }
        }

        if(isAddToSum)
            resultSum += word.length
    }

    return resultSum
}

fun main(){
    val words = arrayOf("cat","bt","hat","tree")
    val words2 = arrayOf("hello","world","leetcode")
    val chars = "atach"
    val chars2 = "welldonehoneyr"

    println(countCharacters(words, chars))
    println(countCharacters(words2, chars2))
}