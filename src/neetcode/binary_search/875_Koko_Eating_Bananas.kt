package neetcode.binary_search

fun canEatAll(k: Int, piles: IntArray, h: Int): Boolean{
    var hours = 0

    for(pile in piles){
        hours += (pile/k) + if(pile % k > 0) 1 else 0
    }

    return hours <= h
}

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var lo = 1
    var hi = piles.maxOrNull() ?: 0

    while(lo < hi){
        val mi = (hi+lo)/2

        if(canEatAll(mi, piles, h)) hi = mi
        else lo = mi+1
    }

    return lo
}

fun main(){
    val piles = intArrayOf(3,6,7,11)
    val piles2 = intArrayOf(30,11,23,4,20)
    val piles3 = intArrayOf(30,11,23,4,20)

    val h = 8
    val h2 = 5
    val h3 = 6

    println(minEatingSpeed(piles, h))
    println(minEatingSpeed(piles2, h2))
    println(minEatingSpeed(piles3, h3))
}