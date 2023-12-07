package neetcode.sliding_window

import kotlin.math.max

fun maxProfit(prices: IntArray): Int {

    var buy = 0
    var sell = 1
    var maxProfit = 0

    while(sell < prices.size){
        if(prices[buy] > prices[sell]){
            buy++
            sell = buy + 1
        }
        else{
            maxProfit = max(maxProfit, prices[sell] - prices[buy])
            sell++
        }
    }

    return maxProfit
}

fun main(){
    val prices = intArrayOf(7,1,5,3,6,4)            // 5
    println(maxProfit(prices))

    val prices2 = intArrayOf(7,6,4,3,1)             // 0
    println(maxProfit(prices2))

    val prices3 = intArrayOf(1,2,3,1,7,9,1,2)       // 8
    println(maxProfit(prices3))

    val prices4 = intArrayOf(4,1,2)                 // 1
    println(maxProfit(prices4))
}