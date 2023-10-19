package neetcode.arrays_hashing

fun longestConsecutive(nums: IntArray): Int {

    if(nums.isEmpty())
        return 0

    val hashMap = sortedMapOf<Int, Boolean>()
    var maxConsecutive = 0

    for(elem in nums){
        hashMap[elem] = true
    }

    var pastElem = hashMap.firstKey()
    var currentConsecutive = 1
    for(elem in hashMap){

        if(elem.key != hashMap.firstKey() && elem.key - pastElem == 1){
            currentConsecutive++
        }
        else{
            currentConsecutive = 1
        }

        if(currentConsecutive > maxConsecutive)
            maxConsecutive = currentConsecutive

        pastElem = elem.key
    }

    return maxConsecutive
}

fun main(){
    println(longestConsecutive(intArrayOf(100,4,200,1,3,2)))
    println(longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
}