package neetcode.two_pointers


// nums = [-1,0,1,2,-1,-4]
// nums = [-4,-1,-1,0,1,2]

fun threeSum(nums: IntArray): List<List<Int>> {
    if(nums.size < 3){
        return List(0){ List(0){0} }
    }
    if(nums.size == 3){
        return if(nums.sum() == 0) listOf(nums.toList()) else List(0){ List(0){0} }
    }

    nums.sort()
    val a = MutableList(0){List(3){0}}
    val s = nums.size
    var j: Int
    var k: Int

    for(i in 0 until s-2){
        if(i!=0 && nums[i] == nums[i-1]){
            continue
        }
        j = i+1
        k = s-1
        while(j < k){
            if(nums[i] + nums[j] + nums[k] > 0){
                k -= 1
            }
            else if(nums[i] + nums[j] + nums[k] < 0){
                j += 1
            }
            else{
                a.add(listOf(nums[i], nums[j], nums[k]))
                j += 1
                k -= 1
                while(j < k && nums[j] == nums[j-1]){
                    j += 1
                }
                while(k < j && nums[k] == nums[k+1]){
                    k -= 1
                }
            }
        }
    }
    return a
}

fun main(){
    val answer = threeSum(intArrayOf(-1,0,1,2,-1,-4))

    answer.forEach{
        print("$it ")
    }
}