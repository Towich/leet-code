package lintcode

import kotlin.math.abs

/**
 * @param points: n points on a 2D plane
 * @return: if there is such a line parallel to y-axis that reflect the given points
 */
fun isReflected(points: Array<IntArray>): Boolean {
    if(points.size == 1)
        return false

    var minX = points[0][0]
    var maxX = points[0][0]
    val set = mutableSetOf<Pair<Int, Int>>()

    for(point in points){
        if(point[0] < minX) minX = point[0]
        else if(point[0] > maxX) maxX = point[0]
        set.add(Pair(point[0], point[1]))
    }

    val centerX = (maxX + minX) / 2

    for(point in points){
        val secondX = if(point[0] < centerX) centerX + (centerX - point[0]) else centerX - (centerX - point[0])
        if(Pair(secondX, point[1]) !in set){
            return false
        }
    }

    return true
}

fun main(){
    val points = arrayOf(intArrayOf(1,1), intArrayOf(-1,1), intArrayOf(-1,1))
//    val points = arrayOf(intArrayOf(3,3), intArrayOf(1,3))
    println(isReflected(points))
}