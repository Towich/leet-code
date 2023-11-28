package neetcode.two_pointers

import java.lang.Integer.max
import java.lang.Integer.min

fun maxArea(height: IntArray): Int {

    var resultMaxArea = 0
    var leftPointer = 0
    var rightPointer = height.size - 1

    while (leftPointer != rightPointer) {
        resultMaxArea = max(min(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer), resultMaxArea)

        if(height[leftPointer] > height[rightPointer]){ rightPointer-- }
        else { leftPointer++ }
    }

    return resultMaxArea
}

fun main() {
    val testArray = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val testArray2 = intArrayOf(1, 1)
    print(maxArea(testArray))
    print(maxArea(testArray2))
}