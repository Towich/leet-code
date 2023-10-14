package com.company

fun maxDistToClosest(seats: IntArray): Int {
    var currDistance = 0
    var maxDistance = 0
    var isLeftBorder = false

    for (i in seats.indices) {
        if(seats[i] == 0){
            currDistance++

            if(i == seats.size - 1){
                if(currDistance > maxDistance){
                    maxDistance = currDistance
                }
            }

        }else{
            if(isLeftBorder){
                if(currDistance != 0){
                    currDistance++
                    currDistance /= 2

                    if(currDistance > maxDistance){
                        maxDistance = currDistance
                        currDistance = 0
                    }
                }
            }
            else{
                if(currDistance > maxDistance){
                    maxDistance = currDistance
                    currDistance = 0
                }
            }

            isLeftBorder = true
        }
    }

    return maxDistance
}

fun main() {
    println(maxDistToClosest(intArrayOf(1,0,0,0,1,0,1)))
    println(maxDistToClosest(intArrayOf(1,0,0,0)))
    println(maxDistToClosest(intArrayOf(0,1)))
    println(maxDistToClosest(intArrayOf(1,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,1)))
    println(maxDistToClosest(intArrayOf(0,0,1)))
}

