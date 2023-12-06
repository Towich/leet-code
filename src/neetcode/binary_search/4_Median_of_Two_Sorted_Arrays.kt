package neetcode.binary_search

import java.lang.Integer.max
import java.lang.Integer.min

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    if(nums1.isEmpty() && nums2.isEmpty()){
        return 0.0
    }
    else if(nums1.isEmpty()){
        if(nums2.size % 2 == 0){
            return (nums2[nums2.size/2 - 1] + nums2[nums2.size/2]) / 2.0
        }
        else{
            return nums2[nums2.size/2].toDouble()
        }
    }
    else if(nums2.isEmpty()){
        if(nums1.size % 2 == 0){
            return (nums1[nums1.size/2 - 1] + nums1[nums1.size/2]) / 2.0
        }
        else{
            return nums1[nums1.size/2].toDouble()
        }
    }

    var lo1 = 0
    var hi1 = nums1.size-1
    var lo2 = 0
    var hi2 = nums2.size-1

    var resultLow = min(nums1[0], nums2[0])
    var resultHigh = max(nums1[nums1.size-1], nums2[nums2.size-1])

    var size = nums1.size+nums2.size

    while(size >= 1){
        if(lo1 < nums1.size && lo2 < nums2.size){
            if(nums1[lo1] > nums2[lo2]){
                resultLow = if(nums2[lo2] < nums1[lo1]) nums2[lo2] else nums1[lo1]
                lo2++

            }
            else{
                resultLow = if(nums1[lo1] < nums2[lo2]) nums1[lo1] else nums2[lo2]
                lo1++

            }
        }
        else if(lo1 < nums1.size){
            resultLow = nums1[lo1]
            lo1++

        }
        else if(lo2 < nums2.size){
            resultLow = nums2[lo2]
            lo2++

        }

        if(hi1 >= 0 && hi2 >= 0){
            if(nums1[hi1] < nums2[hi2]){
                resultHigh = if(nums2[hi2] > nums1[hi1]) nums2[hi2] else nums1[hi1]
                hi2--

            }
            else{
                resultHigh = if(nums1[hi1] > nums2[hi2]) nums1[hi1] else nums2[hi2]
                hi1--

            }
        }
        else if(hi1 >= 0){
            resultHigh = nums1[hi1]
            hi1--

        }
        else if(hi2 >= 0){
            resultHigh = nums2[hi2]
            hi2--

        }

        size -= 2
    }

    return (resultLow + resultHigh) / 2.0
}

fun main(){
    val nums1 = intArrayOf(1,3)
    val nums2 = intArrayOf(2)

    println(findMedianSortedArrays(nums1, nums2))       // 2.0

    val nums12 = intArrayOf(1)
    val nums22 = intArrayOf(2,3)

    println(findMedianSortedArrays(nums12, nums22))     // 2.0

    val nums13 = intArrayOf(1,2)
    val nums23 = intArrayOf(3,4)

    println(findMedianSortedArrays(nums13, nums23))     // 2.5

    val nums14 = intArrayOf(1,2,6,7)
    val nums24 = intArrayOf(3,4,5)

    println(findMedianSortedArrays(nums14, nums24))     // 4.0

    val nums15 = intArrayOf(1,2,2,2)
    val nums25 = intArrayOf(1,1,5,5)

    println(findMedianSortedArrays(nums15, nums25))     // 2.0

    val nums16 = intArrayOf()
    val nums26 = intArrayOf(1)

    println(findMedianSortedArrays(nums16, nums26))     // 1.0

    val nums17 = intArrayOf(1)
    val nums27 = intArrayOf(2,3,4,5)

    println(findMedianSortedArrays(nums17, nums27))     // 3.0
}