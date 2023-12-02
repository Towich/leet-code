package neetcode.two_pointers

import java.lang.Integer.min
import kotlin.test.assertEquals

fun trap(height: IntArray): Int {
    var resultSum = 0

    var leftPointer = 0
    var rightPointer = 1

    var highestHeightIndexRight = rightPointer

    while(leftPointer != height.size-1){

        while(height[leftPointer] > height[rightPointer]){

            if(height[rightPointer] > height[highestHeightIndexRight])
                highestHeightIndexRight = rightPointer

            rightPointer++

            if(rightPointer >= height.size){
                rightPointer = highestHeightIndexRight
                break
            }
        }

        val heightOfSegment = min(height[leftPointer], height[rightPointer])
        for(i in leftPointer..rightPointer){
            if(heightOfSegment >= height[i])
                resultSum += heightOfSegment - height[i]
        }

        leftPointer = rightPointer
        rightPointer++
        highestHeightIndexRight = rightPointer
    }

    return resultSum
}

fun main(){
    val testArray = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    val testArray2 = intArrayOf(4,2,0,3,2,5)
    val testArray3 = intArrayOf(2,0,3,1,1,4,2,1,3,4)
    val testArray4 = intArrayOf(4,2,3)

    println(trap(testArray))
    assertEquals(6, trap(testArray))

    println(trap(testArray2))
    assertEquals(9, trap(testArray2))

    println(trap(testArray3))
    assertEquals(12, trap(testArray3))

    println(trap(testArray4))
    assertEquals(1, trap(testArray4))
}
