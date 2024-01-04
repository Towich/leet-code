package leetcode

fun maxDistToClosest(seats: IntArray): Int {
    var i = 0
    var maxDist = 0
    var isLeftBorder = false

    while(i < seats.size) {
        var dist = 0

        while(i < seats.size && seats[i] != 1) {
            dist++
            i++
        }

        if (isLeftBorder && i < seats.size) {
            dist = if(dist % 2 == 0) dist / 2 else (dist + 1) / 2
        }

        if(dist > maxDist) maxDist = dist

        if(!isLeftBorder) isLeftBorder = true

        i++
    }

    return maxDist
}

fun main() {
    val seats = intArrayOf(1,0,0,0,1,0,1)
    println(maxDistToClosest(seats))    // 2

    val seats2 = intArrayOf(1,0,0,0)
    println(maxDistToClosest(seats2))   // 3

    val seats3 = intArrayOf(0,1)
    println(maxDistToClosest(seats3))   // 1

    val seats4 = intArrayOf(0,1,1,1,0,0,0,0,0,1,1,0,0,0)
    println(maxDistToClosest(seats4))   // 3

    val seats5 = intArrayOf(0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1)
    println(maxDistToClosest(seats5))   // 3
}