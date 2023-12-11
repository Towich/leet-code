package neetcode.sliding_window

fun checkInclusion_BAD(s1: String, s2: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    var start = 0

    for(char in s1){
        map[char] = map.getOrDefault(char, 0) + 1
    }

    for(end in s2.indices){
        if(map[s2[end]] == null){
            if(map[s2[start]] != null){
                map[s2[start]] = map[s2[start]]!! + 1
            }
            start++
        }
        else if(map[s2[end]]!! < 1){
            while(s2[start] != s2[end]) {
                if(map[s2[start]] != null) {
                    map[s2[start]] = map[s2[start]]!! + 1
                }
                start++
            }
            start++
        }
        else{
            map[s2[end]] = map[s2[end]]!! - 1
        }

        var contains = true
        for(e in map){
            if(e.value != 0)
                contains = false
        }
        if(contains) return true
    }

    return false
}

fun checkEquals(map1: Map<Char, Int>, map2: Map<Char, Int>): Boolean{
    var result = true

    for(key in map1.keys){
        if(map2[key] != null && map1[key] == map2[key]){

        }else{
            result = false
        }
    }

    return result
}

fun checkInclusion(s1: String, s2: String): Boolean {
    if(s1.length > s2.length) return false

    val s1Map = mutableMapOf<Char, Int>()
    val s2Map = mutableMapOf<Char, Int>()

    for(i in s1.indices){
        s1Map[s1[i]] = s1Map.getOrDefault(s1[i], 0) + 1
        s2Map[s2[i]] = s2Map.getOrDefault(s2[i], 0) + 1
    }

    for(i in 0 until s2.length-s1.length){
        if(checkEquals(s1Map, s2Map)) return true

        s2Map[s2[i]] = s2Map[s2[i]]!! - 1
        s2Map[s2[s1.length+i]] = s2Map.getOrDefault(s2[s1.length+i], 0) + 1
    }

    return checkEquals(s1Map, s2Map)
}

fun main(){
    val s1 = "ab"
    val s2 = "eidbaooo"

    println(checkInclusion(s1, s2))     // true

    val s11 = "ab"
    val s21 = "eidboaoo"

    println(checkInclusion(s11, s21))     // false

    val s12 = "aba"
    val s22 = "eidbaaoo"

    println(checkInclusion(s12, s22))     // true

    val s13 = "abbc"
    val s23 = "eicbbaac"

    println(checkInclusion(s13, s23))     // true

    val s14 = "adc"
    val s24 = "dcda"

    println(checkInclusion(s14, s24))     // true

    val s15 = "hello"
    val s25 = "ooolleoooleh"

    println(checkInclusion(s15, s25))     // false

    val s16 = "algorithm"
    val s26 = "altruistic"

    println(checkInclusion(s16, s26))     // false
}