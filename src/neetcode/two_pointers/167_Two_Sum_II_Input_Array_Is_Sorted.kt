package neetcode.two_pointers

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var leftIndex = 0
    var rightIndex = numbers.size-1

    while(true){
        val leftElem = numbers[leftIndex]
        val rightElem = numbers[rightIndex]

        val sum = leftElem + rightElem

        if(sum == target){
            return intArrayOf(leftIndex+1, rightIndex+1)
        }
        else if(sum < target){
            leftIndex++
        }
        else{
            rightIndex--
        }
    }
}

fun main(){
    val answerArray = twoSum(intArrayOf(2,7,11,15), 9)

    answerArray.forEach {
        println(it)
    }
}