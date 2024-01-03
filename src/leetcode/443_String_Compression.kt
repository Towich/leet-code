package leetcode

fun compress(chars: CharArray): Int {
    if(chars.isEmpty())
        return 0

    var i = 0
    var result = 0

    while (i < chars.size){
        var groupLength = 1

        while(i + groupLength < chars.size && chars[i + groupLength] == chars[i]){
            groupLength++
        }

        chars[result++] = chars[i]
        if(groupLength > 1){
            for(c in groupLength.toString()){
                chars[result++] = c
            }
        }

        i += groupLength
    }

    return result
}

fun main(){
    val chars1 = charArrayOf('a','a','a','b','b','a','a')
    println("oldSize = ${chars1.size} ")
    print("newSize = ${compress(chars1)}")
}