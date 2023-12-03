package neetcode.binary_search

private fun search(nums: IntArray, target: Int): Int {
    var leftIndex = 0
    var rightIndex = nums.size-1

    while(rightIndex >= leftIndex){
        val middleIndex = (rightIndex + leftIndex)/2
        if(nums[middleIndex] == target)
            return middleIndex
        else if(nums[middleIndex] < target)
            leftIndex = middleIndex+1
        else
            rightIndex = middleIndex-1
    }

    return -1
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var leftArrayIndex = 0
    var rightArrayIndex = matrix.size-1

    while(rightArrayIndex >= leftArrayIndex){
        val middleArrayIndex = (leftArrayIndex + rightArrayIndex) / 2

        if(target < matrix[middleArrayIndex][0]){
            rightArrayIndex = middleArrayIndex-1
        }
        else if(target > matrix[middleArrayIndex][matrix[middleArrayIndex].size-1]){
            leftArrayIndex = middleArrayIndex+1
        }
        else{
            return search(matrix[middleArrayIndex], target) != -1
        }
    }

    return false
}

fun main(){
    val matrix = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60))
    val target = 1

    println(searchMatrix(matrix, target))
}
