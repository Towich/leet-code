package neetcode.arrays_hashing

fun minCostClimbingStairs(cost: IntArray): Int {
    val buffCost = IntArray(cost.size)
    buffCost[0] = cost[0]
    buffCost[1] = cost[1]

    for(i in 2 until cost.size){
        buffCost[i] = Math.min(buffCost[i-1], buffCost[i-2]) + cost[i]
    }

    return Math.min(buffCost[cost.size-1], buffCost[cost.size-2])
}

fun minCostClimbingStairs2(cost: IntArray): Int {
    for(i in 2 until cost.size){
        cost[i] = Math.min(cost[i-1], cost[i-2]) + cost[i]
    }

    return Math.min(cost[cost.size-1], cost[cost.size-2])
}

fun main(){
    println(minCostClimbingStairs2(intArrayOf(10,15,20)))                    // 15
    println(minCostClimbingStairs2(intArrayOf(1,100,1,1,1,100,1,1,100,1)))   // 6
    println(minCostClimbingStairs2(intArrayOf(0,0,0,1)))                     // 0
    println(minCostClimbingStairs2(intArrayOf(0,1,1,1)))                     // 1
    println(minCostClimbingStairs2(intArrayOf(1,2,2,0)))                     // 2
}