package neetcode

fun productExceptSelf(nums: IntArray): IntArray {

    val resultNums = IntArray(nums.size)
    var currMultLeft = 1
    var currMultRight = 1

    // Initialize current multiplication
    for(element in nums){
        currMultRight *= element
    }

    for(i in nums.indices){
        val leftNum = if(i-1 >= 0) nums[i-1] else 1
        currMultLeft *= leftNum

        if(nums[i] == 0){
            currMultRight = 1
            for(k in i+1 until nums.size){
                currMultRight *= nums[k]
            }
        }
        else
            currMultRight /= nums[i]

        resultNums[i] = currMultLeft * currMultRight
    }

    return resultNums
}


fun main(){
    val answ1 = productExceptSelf(intArrayOf(1,2,3,4))
    val answ2 = productExceptSelf(intArrayOf(-1,1,0,-3,3))

    for(num in answ1)
        print("$num ")
    println()

    for(num in answ2)
        print("$num ")
    println()
}