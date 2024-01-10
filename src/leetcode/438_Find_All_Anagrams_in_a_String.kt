package leetcode

fun findAnagrams(s: String, p: String): List<Int> {
    if (s.length < p.length) {
        return listOf()
    }

    val resultList = mutableListOf<Int>()
    val mapS = hashMapOf<Char, Int>()
    val mapP = hashMapOf<Char, Int>()

    for (c in p) {
        mapP[c] = mapP.getOrDefault(c, 0) + 1
    }

    for(k in p.indices){
        mapS[s[k]] = mapS.getOrDefault(s[k], 0) + 1
    }

    var left = 0
    var right = p.length-1
    while (right < s.length) {
        var isValid = true
        for (e in mapS.keys) {
            if (mapS[e] != mapP.getOrDefault(e, 0)) {
                isValid = false
            }
        }

        if (isValid)
            resultList.add(left)

        mapS[s[left]] = mapS[s[left]]!! - 1
        if (mapS.getOrDefault(s[left], 0) == 0)
            mapS.remove(s[left])

        left++
        right++

        if(right < s.length)
            mapS[s[right]] = mapS.getOrDefault(s[right], 0) + 1

    }

    return resultList
}

fun main() {
    val s = "cbaebabacd"
    val p = "abc"

    val s1 = "abab"
    val p1 = "ab"

    val s2 = "baa"
    val p2 = "aa"

    val resultList = findAnagrams(s, p).forEach { print("$it ") }       // 0 6
    println()
    val resultList1 = findAnagrams(s1, p1).forEach { print("$it ") }    // 0 1 2
    println()
    val resultList2 = findAnagrams(s2, p2).forEach { print("$it ") }    // 1
}